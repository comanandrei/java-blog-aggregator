package ru.andrei.ro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.andrei.ro.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
