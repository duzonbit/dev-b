package app.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.mo.BoardDTO;

public interface BoardRepo extends JpaRepository<BoardDTO, Integer>{

    public static final String FIND_BY_DETAIL = "Select * From board Where idx = :idx";
    public static final String UPDATE = "UPDATE board SET title = :boardDTO.title, content = :boardDTO.content WHERE idx = 1;";

    public static final String DELETE = "DELETE from board where idx=:idx and name=:name and pw=:pw";

    @Query(value=FIND_BY_DETAIL, nativeQuery=true)
    public BoardDTO findByDetail(@Param("idx") int idx);

    @Transactional
    @Modifying
    @Query(value=UPDATE, nativeQuery=true)
    public void update(@Param("boardDTO") BoardDTO boardDTO);


    public void delete(@Param("boardDTO") BoardDTO boardDTO);
}
