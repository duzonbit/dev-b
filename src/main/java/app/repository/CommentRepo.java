package app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.model.CommentModel;;

/**
 * CommentR
 */
public interface CommentRepo extends JpaRepository<CommentModel, Integer>{
 

    public static final String FIND_BY_BOARD_ID = "Select * From comment Where board_idx= :board_idx";

    @Query(value = FIND_BY_BOARD_ID, nativeQuery = true)
    List<CommentModel> findByBoard_idx(int board_idx);

    @Query( value = "select * from comment where bbs_idx = :bbs_idx", nativeQuery=true)
	List<CommentModel> findByBbs_idx(int bbs_idx);
    
}