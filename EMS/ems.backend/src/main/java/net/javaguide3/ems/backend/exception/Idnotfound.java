package net.javaguide3.ems.backend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class Idnotfound  extends RuntimeException{
    public Idnotfound(String msg)
    {
        super(msg);
    }

}
