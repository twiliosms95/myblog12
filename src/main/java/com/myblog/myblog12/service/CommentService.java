package com.myblog.myblog12.service;

import com.myblog.myblog12.payload.CommentDto;

public interface CommentService {

    CommentDto createComment(CommentDto commentDto, long postId);

    CommentDto updateComment(long id, CommentDto commentDto, long postId);

    void deleteComment(long id);
}
