package com.iAKIN.LanguageApp.service.impl;

import com.iAKIN.LanguageApp.exception.NotFoundException;
import com.iAKIN.LanguageApp.model.comment.Comment;
import com.iAKIN.LanguageApp.repository.CommentRepository;
import com.iAKIN.LanguageApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment getComment(Integer id) {
        return commentRepository.findById(id).orElseThrow(() -> new NotFoundException("Comment"));
    }
}