package com.wanderlust.wanderlust.repository.user;

import com.wanderlust.wanderlust.model.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUserName(String userName);

}
