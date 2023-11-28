package com.yt.backend.controller;

import com.yt.backend.model.Comment;
import com.yt.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @PostMapping("/comment/add")
    public String addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return "Comment added successfully..";
    }
    @RequestMapping("/comment/{id}")
    public Comment getCommentById(@PathVariable("id") String id) {
        long commentId = Long.parseLong(id);
        return commentService.getCommentById(commentId);
    }


    @RequestMapping("/comment")
    public List<Comment> getComment(){return commentService.getComment();}

    @PutMapping("/comment")
    public Comment updateComment(@RequestBody Comment comment){return commentService.updateComment(comment);}

    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable("id") long id){
        commentService.deleteComment(id);
        return "Comment Successfully Deleted";
    }
}
