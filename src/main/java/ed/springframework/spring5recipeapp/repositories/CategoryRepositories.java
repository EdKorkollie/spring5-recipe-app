package ed.springframework.spring5recipeapp.repositories;

import ed.springframework.spring5recipeapp.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepositories extends CrudRepository<Category, Long> {
}
