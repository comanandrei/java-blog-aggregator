package ru.andrei.ro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.andrei.ro.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
