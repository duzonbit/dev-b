package app.repo;

import app.mo.BoardDTO;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardRepo extends JpaRepository<BoardDTO, Integer>{

}
