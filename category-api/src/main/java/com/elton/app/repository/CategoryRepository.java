package  com.elton.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.elton.app.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	List<Category> findByDescriptionContainingIgnoreCase(String description);

	Category findByDescriptionEqualsIgnoreCase(String description);
}