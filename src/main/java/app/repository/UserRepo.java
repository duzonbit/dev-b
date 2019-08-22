package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import app.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer> {

    @Query(value = "Select * From user Where user_id= :user_id", nativeQuery = true)
    UserModel findByUserId(String user_id);
}