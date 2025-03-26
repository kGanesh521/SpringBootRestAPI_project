package com.SpringBoot_restapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourcesNotFoundExecption  extends RuntimeException{

    public ResourcesNotFoundExecption(String message){
        super(message);
    }

}
