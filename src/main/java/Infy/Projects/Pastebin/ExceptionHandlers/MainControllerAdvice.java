package Infy.Projects.Pastebin.ExceptionHandlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import Infy.Projects.Pastebin.ExceptionHandlers.Exceptions.PasteNotFoundException;

@ControllerAdvice
public class MainControllerAdvice {
    
    @ExceptionHandler(PasteNotFoundException.class)
    public String pasteNotFound(PasteNotFoundException pasteNotFoundException){
        return "redirect:/";
    }
}
