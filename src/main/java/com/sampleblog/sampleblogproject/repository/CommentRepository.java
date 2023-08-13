package com.sampleblog.sampleblogproject.repository;

import com.sampleblog.sampleblogproject.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
