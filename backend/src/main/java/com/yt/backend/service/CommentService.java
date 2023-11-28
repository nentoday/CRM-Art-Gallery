package com.yt.backend.service;

import com.yt.backend.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CommentService {
    Comment addComment(Comment comment);
    Comment getCommentById(long id);
    List<Comment> getComment();
    Comment updateComment(Comment comment);
    void deleteComment(long id);

}
