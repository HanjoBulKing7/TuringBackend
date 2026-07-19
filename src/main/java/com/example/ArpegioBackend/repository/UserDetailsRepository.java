package com.example.ArpegioBackend.repository;

import com.example.ArpegioBackend.entity.Users;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.username = :username AND u.email = :email")
    Optional<Users> findByUserNameAndEmail(@Param("username") String username, @Param("email") String email);

    Optional<Users> findByUsername(@NotBlank String username);
}