package it.aulab.springbootcontroller.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/*
 *  Exception --------------> tutte le classi che derivano devono essere gestite con try catch o throws
 *  |
 *  |
 *  |___ RuntimeException
 * 
 */


// @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Insert all required fields: firstname, lastname, email")
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AuthorBadRequest extends RuntimeException {
    public AuthorBadRequest() {
    }
    public AuthorBadRequest(String message) {
        super(message);
    }
}
