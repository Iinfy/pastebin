package Infy.Projects.Pastebin.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import Infy.Projects.Pastebin.Entities.Paste;
import Infy.Projects.Pastebin.ExceptionHandlers.Exceptions.PasteNotFoundException;
import Infy.Projects.Pastebin.Services.PasteService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
public class MainController {

    @Autowired
    PasteService pasteService;

    @GetMapping("/about")
    public String getAboutPage() {
        return "aboutPage";
    }

    @GetMapping("/")
    public String getPasteCreatePage(Model model) {
        model.addAttribute("paste", new Paste());
        return "pastePage";
    }
    

    @GetMapping("/{id}")
    public String getPaste(@PathVariable Long id, Model model) throws PasteNotFoundException{
        if (pasteService.checkExistById(id)) {
            model.addAttribute("paste", pasteService.getById(id).get());
            return "pastePage";
        } else{
            throw new PasteNotFoundException("Paste with id:" + id + "not found");
        }
        

        
    }

    @PostMapping("/paste")
    public String postMethodName(@ModelAttribute Paste paste) {
        System.out.println(paste);
        pasteService.savePaste(paste);
        return "redirect:/paste";
    }
    
    
    
    
    
}
