package app.controller.comment;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import app.model.comment.CommentModel;
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
    public List<CommentModel> read(@PathVariable int bbs_idx) {
        List<CommentModel> list = commentService.read(bbs_idx);
        return list;
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