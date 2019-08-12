package app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.ui.Model;

import app.mo.BoardDTO;

public interface BoardRepo extends JpaRepository<BoardDTO, Integer>{

    public static final String FIND_BY_DETAIL = "Select * From board Where idx = :idx";
    // public static final String UPDATE = "Select * From Board1 Where idx = :idx";

    @Query(value=FIND_BY_DETAIL, nativeQuery=true)
    public BoardDTO findByDetail(@Param("idx") int idx);

    // @Query(value=UPDATE, nativeQuery=true)
    // public void update(@Param("name") String name, @Param("pw") String pw, );
}
