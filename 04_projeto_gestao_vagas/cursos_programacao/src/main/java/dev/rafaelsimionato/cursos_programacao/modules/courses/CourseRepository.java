package dev.rafaelsimionato.cursos_programacao.modules.courses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    List<CourseEntity> findByNameContainingIgnoreCase(String name);
    List<CourseEntity> findByCategoryContainingIgnoreCase(String category);
    List<CourseEntity> findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(String name, String category);

}
