package com.example.CSVfileToMysql.repository;

import com.example.CSVfileToMysql.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<Users,Long> {


    Users findByEmail(String email);

    @Query("select u from Users u where u.email in :emails")
    List<Users> findByEmails(@Param("emails") List<String> emails);
}
