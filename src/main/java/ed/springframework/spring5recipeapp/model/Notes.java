package ed.springframework.spring5recipeapp.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Entity
public class Notes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne //dont use Cascade because we allow the Recipe to own this. if we delete the Note object we dont wanna go back and delete the recipe object
    private Recipe recipe;

    @Lob // allow the user to write more than 250 character in the database for recipe notes
    private String recipeNotes;

    public Notes() {
    }
}
