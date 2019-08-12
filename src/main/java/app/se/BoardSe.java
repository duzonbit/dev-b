
package app.se;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.mo.BoardDTO;
import app.repo.BoardRepo;

/**
 * BoardSe
 */
@Service
public class BoardSe {

    @Autowired
    BoardRepo boardRepo;

    // 글 리스트 불러오기
    public List<BoardDTO> findAll() {
		return boardRepo.findAll();
    }
    // 글 쓰기 저장
    public void create(BoardDTO boardDTO) {
		boardRepo.saveAndFlush(boardDTO);
    }
    // 글 읽기
    public BoardDTO read(int idx) {
		return boardRepo.findByDetail(idx);
    }
    // // 글 수정 저장
    // public void update(BoardDTO boardDTO) {
	// 	boardRepo.update(boardDTO.getName(), boardDTO.getPw(), boardDTO);
	// }

}