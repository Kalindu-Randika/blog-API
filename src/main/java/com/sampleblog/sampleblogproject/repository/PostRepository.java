package com.sampleblog.sampleblogproject.repository;

import com.sampleblog.sampleblogproject.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PostRepository extends JpaRepository<Post, Long> {
}
