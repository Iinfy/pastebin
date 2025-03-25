package Infy.Projects.Pastebin.Controllers;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;
import Infy.Projects.Pastebin.Entities.Paste;
import Infy.Projects.Pastebin.ExceptionHandlers.Exceptions.PasteNotFoundException;
import Infy.Projects.Pastebin.Services.PasteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("/api")
public class ApiController {

    Logger logger = LogManager.getLogger(ApiController.class);

    @Value("${deleteall.enabled}")
    private boolean deleteallEnabled;

    @Autowired
    PasteService pasteService;

    @GetMapping("/{id}")
    public Paste getMethodName(@PathVariable Long id) throws PasteNotFoundException{
        if (pasteService.checkExistById(id)) {
            return pasteService.getById(id).get();
        } else{
            throw new PasteNotFoundException("Paste with id:" + id + " not found");
        }
        
    }
    
    

    @PostMapping("/createpaste")
    public void postMethodName(@RequestBody Paste paste) {
        pasteService.savePaste(paste);
    }
    

    @DeleteMapping("/deleteall")
    public String getMethodName() {
        logger.info("Delete all pastes request created");
        
        if (deleteallEnabled) {
            System.out.println("Deleting all pastes...");
            pasteService.deleteAll();
            
            return "Deleted";
        } else{
            logger.info("Delete all pastes disabled!");
            return "Delete all disabled";
        }
        

    }
    
    
}
