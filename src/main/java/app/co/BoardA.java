package app.co;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import app.repo.BoardR;
import app.se.BoardS;

@RestController("/board")
public class BoardA {

    @Autowired
	BoardS boardSe;
	
	@Autowired
    BoardR boardRepo;
    
    
}