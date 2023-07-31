package net.javaguides.springbootrestefulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springbootrestefulwebservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
