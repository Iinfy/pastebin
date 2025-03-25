package Infy.Projects.Pastebin.Services;

import java.util.Optional;

import javax.swing.text.DefaultEditorKit.PasteAction;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Infy.Projects.Pastebin.Entities.Paste;
import Infy.Projects.Pastebin.Interfaces.DatabaseController;

@Service
public class PasteService {

    Logger logger = LogManager.getLogger(PasteAction.class);
    
    @Autowired
    private DatabaseController databaseController;

    @Transactional
    @Cacheable(value = "pastes", key = "#id")
    public Optional<Paste> getById(Long id){
        logger.info("Getting from database paste:" + id);
        System.out.println("Getting from database paste:" + id);
        return databaseController.findById(id);
    }

    @Transactional
    public void savePaste(Paste paste){
        Long count = databaseController.count();
        Paste pasteToSave = new Paste(count+1L,paste.getText());
        databaseController.save(pasteToSave);
        logger.info("Saved paste:" + pasteToSave);
    }

    @Transactional
    @CacheEvict
    public void deleteAll(){
        databaseController.deleteAll();
        logger.info("All pastes deleted");
    }

    @Transactional
    @CacheEvict
    public void deletePaste(Long id){
        databaseController.deleteById(id);
        logger.info("Deleted paste:" + id);
    }

    @Transactional
    public boolean checkExistById(Long id){
        return databaseController.existsById(id);
    }

}
