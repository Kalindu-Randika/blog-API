package com.sampleblog.sampleblogproject.exception;

import com.sampleblog.sampleblogproject.payload.ErrorDetails;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Exception exception;
    private WebRequest webRequest;

    // handle specific exceptions
//    @ExceptionHandler(ChangeSetPersister.NotFoundException.class)
//    ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(), webRequest.getDescription(false));
//        return new ResponseEntity<>(errorDetails,HttpStatus.NOT_FOUND);
//}

    // handle global exceptions
}
