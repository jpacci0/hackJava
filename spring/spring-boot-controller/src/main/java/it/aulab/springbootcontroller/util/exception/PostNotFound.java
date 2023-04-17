package it.aulab.springbootcontroller.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Post not found")
public class PostNotFound extends RuntimeException {
    
}
