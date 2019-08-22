package app.repository;

import app.model.BbsModel;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BbsRepo extends JpaRepository<BbsModel, Integer> {

}
