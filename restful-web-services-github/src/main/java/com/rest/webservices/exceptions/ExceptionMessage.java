package com.rest.webservices.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class ExceptionMessage {

    private Date timeSTamp;
    private String message;
    private String details;
}
