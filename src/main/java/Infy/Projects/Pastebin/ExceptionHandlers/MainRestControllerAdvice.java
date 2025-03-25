package Infy.Projects.Pastebin.ExceptionHandlers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import Infy.Projects.Pastebin.ExceptionHandlers.Exceptions.PasteNotFoundException;

@RestControllerAdvice
public class MainRestControllerAdvice {
    
    @ExceptionHandler(PasteNotFoundException.class)
    public String pasteNotFound(PasteNotFoundException exception){
        return exception.getMessage();
    }
}
