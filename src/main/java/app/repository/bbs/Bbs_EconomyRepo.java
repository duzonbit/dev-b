package app.repository.bbs;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.bbs.Bbs_EconomyModel;
/**
 * Bbs_EconomyRepo
 */
public interface Bbs_EconomyRepo extends JpaRepository<Bbs_EconomyModel, Integer> {
    
}