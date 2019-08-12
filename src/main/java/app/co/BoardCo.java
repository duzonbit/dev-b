package app.co;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BoardCo {
    
    @GetMapping("/generate")
    public String generate(){
        
        return "generate";
    }
    
    @GetMapping("/create")
    public String createV() {
        return "creat";
    }
    
    @PostMapping(value="/create")
    public String create() {
        return "list";
    }

    
    @GetMapping("/")
    public String list(Model model) {
        return "list";
    }

    @GetMapping("/{page}")
    public String page(Model model) {
        return "list";
    }

    @GetMapping("/read/{idx}")
    public String read(Model model){
        return "read";
    }


    @GetMapping("/update/{idx}")
    public String updateV(Model model){
        return "update";
    }

    @PostMapping("/update/{idx}/name/{name}/pw/{pw}")
    public String update(Model model) {
        
        return "redirect:/";
    }

    @PostMapping("/delete/{idx}/name/{name}/pw/{pw}")
    public String delete(Model model) {
        return "redirect:/";
    }
}