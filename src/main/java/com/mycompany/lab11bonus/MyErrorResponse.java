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
import java.time.LocalDateTime;

public class MyErrorResponse {
    public String message;
    public MyErrorResponse(String message) {
        this.message=message;
    }
    public String getMessage(){
        return message;
    }
    public void setMessage(String message){
        this.message=message;
    }
}
