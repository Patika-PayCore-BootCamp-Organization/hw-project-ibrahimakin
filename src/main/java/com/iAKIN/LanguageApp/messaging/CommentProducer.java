package com.iAKIN.LanguageApp.messaging;

import com.iAKIN.LanguageApp.config.RabbitMQConfig;
import com.iAKIN.LanguageApp.model.comment.Comment;
import com.iAKIN.LanguageApp.service.CommentService;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/messaging")
public class CommentProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private CommentService commentService;

    @PostMapping("/{message}")
    public String publishMessage(@PathVariable String message) {
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, message);
        return "Success";
    }

    @PostMapping("/comment/{id}")
    public String publishPassenger(@PathVariable Integer id) {
        Comment comment = commentService.getComment(id);
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, comment);
        return "Success";
    }
}