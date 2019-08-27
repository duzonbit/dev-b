package app.controller.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.comment.CommentModel;
import app.model.comment.CommentPage;
import app.service.CommentService;
;

/**
 * CommentM
 */
@RestController
@CrossOrigin("origin-allowed=*")  // 접근? 인증?
@RequestMapping(value = "/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    
    @GetMapping(value = "/{bbs_idx}" )
    public List<CommentModel> list(@PathVariable int bbs_idx) {
        List<CommentModel> list = commentService.read(bbs_idx);
        return list;
    }

    @GetMapping(value = "/max/{bbs_idx}" )
    public int maxpage(@PathVariable Optional<Integer> bbs_idx) {
        return commentService.maxpage(bbs_idx.orElse(1));
    }

    @GetMapping(value = "/{bbs_idx}/{pagecurr}" )
    public Map<String, CommentPage> read(@PathVariable Optional<Integer> bbs_idx, @PathVariable Optional<Integer> pagecurr) {
        Map<String, CommentPage> map = new HashMap<String, CommentPage>();
        List<CommentModel> list = commentService.count(bbs_idx.orElse(1), pagecurr.orElse(0));

        int maxpage = commentService.maxpage(bbs_idx.orElse(1));

        CommentPage page = new CommentPage();
        page.setList(list);
        page.setMaxpage(maxpage);
        page.setCurrpage(pagecurr.orElse(0));
        page.setSize(10);

        map.put("page", page);
        return map;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Map<String, String> create(@RequestBody CommentModel commentModel) {
        Map<String, String> map = new HashMap<String, String>();
        commentService.create(commentModel);
        map.put("message", "success");
        return map;
    }

    @RequestMapping(value = "/", method = RequestMethod.PUT)
    public Map<String, String> update(@RequestBody CommentModel commentModel) {
        Map<String, String> map = new HashMap<String, String>();
        String ms = commentService.update(commentModel) ? "success" : "fail";
        map.put("message", ms);
        return map;
    }

    @RequestMapping(value = { "/" }, method = RequestMethod.DELETE)
    public Map<String, String> delete(@RequestBody CommentModel commentModel) {
        Map<String, String> map = new HashMap<String, String>();
        String ms = commentService.delete(commentModel) ? "success" : "fail";
        map.put("message", ms);
        return map;
    }
}