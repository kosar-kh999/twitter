package ir.maktab.service;

import ir.maktab.model.Comment;
import ir.maktab.repository.CommentRepository;

public class CommentService {
    CommentRepository commentRepository = new CommentRepository();

    public void writeComment(Comment comment) {
        commentRepository.creat(comment);
    }

    public Comment findByUsername(String username) {
        return commentRepository.findByUsername(username);
    }

    public void editComment(Comment comment) {
        commentRepository.update(comment);
    }

    public void removeComment(Comment comment) {
        commentRepository.remove(comment);
    }
}
