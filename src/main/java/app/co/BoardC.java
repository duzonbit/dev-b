package app.co;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import app.mo.BoardM;
import app.repo.BoardR;
import app.se.BoardS;

@Controller
public class BoardC {
    
	@Autowired
	BoardS boardSe;
	
	@Autowired
	BoardR boardRepo;
    
    @GetMapping("/create")
    public String createV() {
        return "create";
    }
    
    @PostMapping(value="/create")
    public String create(BoardM boardDTO) {
        boardSe.create(boardDTO);
		return "redirect:/";
    }

    
    @GetMapping("/")
    public String list(Model model) {
        Pageable pageable = PageRequest.of(0, 10, new Sort(Direction.DESC, "idx"));
        Page<BoardM> page = boardRepo.findAll(pageable);
        model.addAttribute("page", page);
        return "list";
    }

    @GetMapping("/{index}")
    public String page(@PathVariable int index, Model model) {
        Pageable pageable = PageRequest.of(index-1, 10, new Sort(Direction.DESC, "idx"));
        Page<BoardM> page = boardRepo.findAll(pageable);
        model.addAttribute("page", page);
        return "list";
    }



    @GetMapping("/read/{idx}")
    public String read(@PathVariable int idx, Model model){
        BoardM boardDTO = boardSe.read(idx);
		model.addAttribute("board", boardDTO);
        return "read";
    }

    @GetMapping("/update/{idx}")
    public String updateV(@PathVariable int idx, Model model){
        BoardM boardDTO = boardSe.read(idx);
		model.addAttribute("board", boardDTO);
        return "update";
    }

    @PostMapping("/update/")
    public String update( BoardM boardDTO) {
        boardSe.update(boardDTO);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String delete(BoardM boardDTO) {
        boardSe.delete(boardDTO);
        return "redirect:/";
    }

    @ResponseBody
    @GetMapping("/test/page")
    public Page<BoardM> page1(Model model) {
        Pageable pageable = PageRequest.of(0, 10, new Sort(Direction.DESC, "idx"));
        Page<BoardM> page = boardRepo.findAll(pageable);
        return page;
    }

    @ResponseBody
    @GetMapping("/test/")
    public Map<String,Object> test(Model model) {
        List<BoardM> list = boardSe.findAll();
		model.addAttribute("list", list);
        return model.asMap();
    }
}