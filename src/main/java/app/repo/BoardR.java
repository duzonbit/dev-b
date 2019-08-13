package app.repo;

import app.mo.BoardM;

import org.springframework.data.jpa.repository.JpaRepository;


public interface BoardR extends JpaRepository<BoardM, Integer>{

}
