/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lab11bonus;

/**
 *
 * @author adria
 */
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class MyExceptionAdvice {
    @ExceptionHandler(value = MyException.class)
    public ResponseEntity<MyErrorResponse>
    handleGenericNotFoundException(MyException e){
        MyErrorResponse error = new MyErrorResponse(e.getMessage());
        return new ResponseEntity<MyErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
}
