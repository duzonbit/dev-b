
package app.se;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mo.BoardDTO;
import app.repo.BoardRepo;

@Service
public class BoardSe {

  @Autowired
  BoardRepo boardRepo;

  public List<BoardDTO> findAll() {
    return boardRepo.findAll();
  }

  public void create(BoardDTO boardDTO) {
    boardRepo.saveAndFlush(boardDTO);
  }

  public BoardDTO read(int idx) {
    return boardRepo.findById(idx).orElse(null);
  }
  
  public void update(BoardDTO boardDTO) {
    BoardDTO res= boardRepo.findById(boardDTO.getIdx()).orElse(null);
    if(res==null)
      return;
      
    if(res.getIdx()==boardDTO.getIdx()
    &&res.getName().equals(boardDTO.getName())
    &&res.getPw().equals(boardDTO.getPw())){
      boardRepo.save(boardDTO);
    }
  }

  public void delete(BoardDTO boardDTO){
    BoardDTO res= boardRepo.findById(boardDTO.getIdx()).orElse(null);
    if(res.getIdx()==boardDTO.getIdx()
    &&res.getPw().equals(boardDTO.getPw())){
      boardRepo.deleteById(boardDTO.getIdx());
    }
  }
}