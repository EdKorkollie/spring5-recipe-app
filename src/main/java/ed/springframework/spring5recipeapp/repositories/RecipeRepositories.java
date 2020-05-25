package ed.springframework.spring5recipeapp.repositories;

import ed.springframework.spring5recipeapp.model.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepositories extends CrudRepository<Recipe, Long> {
}
