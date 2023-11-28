package com.yt.backend.service.impl;

import com.yt.backend.model.Comment;
import com.yt.backend.repository.CommentRepository;
import com.yt.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Override
    public Comment addComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(long id) {
        return commentRepository.findById(id).get();
    }

    @Override
    public List<Comment> getComment() {
        return (List<Comment>) commentRepository.findAll();
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }
}
