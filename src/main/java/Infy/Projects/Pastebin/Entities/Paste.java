package Infy.Projects.Pastebin.Entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "pastes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paste implements Serializable{
    
    @Id
    private Long id;

    private String text;
}
