package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.charity.model.Category;

import javax.validation.Valid;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "SELECT name\n" +
            "FROM category;",
            nativeQuery = true)
    List<String> findAllNameCategories();

    @Query(value = "SELECT *\n" +
            "FROM category\n" +
            "WHERE id IN (:category_name);",
            nativeQuery = true)
    List<Category> findAllCategoriesByName(@Param("category_name") String category_name);
}
