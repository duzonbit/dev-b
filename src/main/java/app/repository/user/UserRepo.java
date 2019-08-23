package app.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;

import app.model.user.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{

}