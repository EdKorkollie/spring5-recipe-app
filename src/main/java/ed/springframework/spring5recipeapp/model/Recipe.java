package ed.springframework.spring5recipeapp.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Identity supports the auto generation of a sequence in different databases
    private Long id;

    private String description;
    private String prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String dierections;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe") //passed in recipe on mappedBy bc it is the target property on the child class.
    private Set<Ingredient> ingredients;
    @Lob //storing a large object field
    private Byte[] image;
    @Enumerated(value = EnumType.STRING) //this is so that when it persist in the data base it will have the actual Enum values (Easy, moderate, hard). if we used EnumType.ORDINAL, it would save it as 1,2,3 etc
    private Difficulty difficulty;

    @OneToOne(cascade = CascadeType.ALL) // cascade makes the recipe the owner of Notes
    private Notes notes;

    @ManyToMany
    @JoinTable(name = "recipe_category", joinColumns = @JoinColumn(name = "recipe_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public Integer getCookTime() {
        return cookTime;
    }

    public void setCookTime(Integer cookTime) {
        this.cookTime = cookTime;
    }

    public Integer getServings() {
        return servings;
    }

    public void setServings(Integer servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDierections() {
        return dierections;
    }

    public void setDierections(String dierections) {
        this.dierections = dierections;
    }

    public Byte[] getImage() {
        return image;
    }

    public void setImage(Byte[] image) {
        this.image = image;
    }

    public Notes getNotes() {
        return notes;
    }

    public void setNotes(Notes notes) {
        this.notes = notes;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
