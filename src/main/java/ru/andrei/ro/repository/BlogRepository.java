package ru.andrei.ro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ru.andrei.ro.entity.Blog;
import ru.andrei.ro.entity.User;

public interface BlogRepository extends JpaRepository<Blog, Integer> {

	List<Blog> findByUser(User user);
}
