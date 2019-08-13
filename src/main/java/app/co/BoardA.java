package app.co;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.repo.BoardR;
import app.se.BoardS;

@Controller
public class BoardA {

    @Autowired
	BoardS boardSe;
	
	@Autowired
    BoardR boardRepo;
    
    
}