package app.repository.bbs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.model.bbs.BbsModel;

public interface BbsRepo extends JpaRepository<BbsModel, Integer>{

    public static final String FIND_MAXIDX = "SELECT * FROM bbs ORDER BY idx DESC LIMIT 1";

    @Query(value = FIND_MAXIDX, nativeQuery = true)
    int findMAXidx();
}