package com.mithilesh.tms.repository;

import com.mithilesh.tms.dto.UserDto;
import com.mithilesh.tms.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {

    @Query("select u from User u where u.email =:e")
    User findByEmail(@Param("e") String email);

}
