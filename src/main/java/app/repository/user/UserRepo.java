package app.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.model.user.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer>{

    public static final String FIND_SELFT_BY_ID = "Select * From user Where user_id= :idd";

    @Query(value = FIND_SELFT_BY_ID, nativeQuery = true)
    UserModel findByUserId(@Param("idd") String id);
}