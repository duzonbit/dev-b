package app.co;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        List<BoardM> list = boardSe.findAll();
		model.addAttribute("list", list);
		return "list";
    }

    @GetMapping("/{page}")
    public String page(Model model) {
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
}