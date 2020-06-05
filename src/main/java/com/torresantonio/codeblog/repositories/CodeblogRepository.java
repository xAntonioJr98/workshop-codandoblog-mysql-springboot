package com.torresantonio.codeblog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.torresantonio.codeblog.entities.Post;

public interface CodeblogRepository extends JpaRepository<Post, Long> {
	
	
}
