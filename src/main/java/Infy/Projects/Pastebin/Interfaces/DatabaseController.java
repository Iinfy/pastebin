package Infy.Projects.Pastebin.Interfaces;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Infy.Projects.Pastebin.Entities.Paste;

@Repository
public interface DatabaseController extends MongoRepository<Paste,Long>{

}
