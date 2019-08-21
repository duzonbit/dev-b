package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{

}