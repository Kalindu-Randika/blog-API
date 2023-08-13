package com.sampleblog.sampleblogproject.service;

import com.sampleblog.sampleblogproject.payload.CommentDto;
import org.springframework.data.crossstore.ChangeSetPersister;

import java.util.List;

public interface CommentService {

    CommentDto createComment(long postId, CommentDto commentDto) throws ChangeSetPersister.NotFoundException;

    List<CommentDto> getCommentsByPostId(long postId);

}
