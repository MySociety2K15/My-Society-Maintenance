package com.springboot.societymaintenance.repository;

import com.springboot.societymaintenance.model.Flat;
import com.springboot.societymaintenance.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u where u.email = ?1 AND u.password = ?2 and rownum=1")
    Optional<User> findByEmailAndPassword(String email, String password);

    //Optional<User> findUserByFlat(Flat flat);
}