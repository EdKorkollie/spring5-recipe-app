package ed.springframework.spring5recipeapp.services;

import ed.springframework.spring5recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
}
