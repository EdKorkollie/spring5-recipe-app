package ed.springframework.spring5recipeapp.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity supports the auto generation of a sequence in different databases
    private Long id;

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    @Lob
    private String directions;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") //passed in recipe on mappedBy bc it is the target property on the child class.
    private Set<Ingredient> ingredients =new HashSet<>();
    @Lob //storing a large object field
    private Byte[] image;
    @Enumerated(value = EnumType.STRING) //this is so that when it persist in the data base it will have the actual Enum values (Easy, moderate, hard). if we used EnumType.ORDINAL, it would save it as 1,2,3 etc
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL) // cascade makes the recipe the owner of Notes
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>(); // this to avoid having a null pointer exception if you forget to set it

    public Recipe addIngredient(Ingredient ingredient) {
        ingredient.setRecipe(this);
        this.ingredients.add(ingredient);
        return this;
    }

}
