package dev.rafaelsimionato.cursos_programacao.modules.courses;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CourseRepository extends JpaRepository<CourseEntity, UUID> {

    List<CourseEntity> findByNameContainingIgnoreCaseOrCategoryContainingIgnoreCase(String name, String category);

}
