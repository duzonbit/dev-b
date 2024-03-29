package app.repository.comment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.model.comment.CommentModel;


/**
 * CommentR
 */
public interface CommentRepo extends JpaRepository<CommentModel, Integer> {

    @Query(value = "select * from comment where bbs_idx = :bbs_idx", nativeQuery = true)
    List<CommentModel> findByBbs_idx(int bbs_idx);

    
    @Query(value = "select COUNT(*) from comment where bbs_idx = :bbs_idx", nativeQuery = true)
    int findBycount(int bbs_idx);

    @Query(value = "select * from comment where bbs_idx = :bbs_idx LIMIT :pagestart, 10", nativeQuery = true)
    List<CommentModel> findBycount(int bbs_idx, int pagestart);


}