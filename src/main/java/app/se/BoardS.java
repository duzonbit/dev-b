
package app.se;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mo.BoardM;
import app.repo.BoardR;

@Service
public class BoardS {

  @Autowired
  BoardR boardRepo;

  public List<BoardM> findAll() {
    return boardRepo.findAll();
  }

  public void create(BoardM boardDTO) {
    boardRepo.saveAndFlush(boardDTO);
  }

  public BoardM read(int idx) {
    return boardRepo.findById(idx).orElse(null);
  }
  
  public boolean update(BoardM boardDTO) {
    BoardM res= boardRepo.findById(boardDTO.getIdx()).orElse(null);
      
    if(res.getIdx()==boardDTO.getIdx()
    &&res.getName().equals(boardDTO.getName())
    &&res.getPw().equals(boardDTO.getPw())){
      boardRepo.save(boardDTO);
      return true;
    }else{
      return false;
    }
  }

  public boolean delete(BoardM boardDTO){
    BoardM res= boardRepo.findById(boardDTO.getIdx()).orElse(null);
    if(res.getIdx()==boardDTO.getIdx()
    &&res.getPw().equals(boardDTO.getPw())){
      boardRepo.deleteById(boardDTO.getIdx());
      return true;
    }else{
      return false;
    }
  }
}