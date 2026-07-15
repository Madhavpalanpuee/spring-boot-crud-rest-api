package com.example.springbootcrud.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbootcrud.entities.User;

public interface UserRepositories extends JpaRepository<User, Long> {

}
