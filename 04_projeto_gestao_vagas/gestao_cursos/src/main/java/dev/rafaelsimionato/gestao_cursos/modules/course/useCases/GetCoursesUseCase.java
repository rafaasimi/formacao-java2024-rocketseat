package dev.rafaelsimionato.gestao_cursos.modules.course.useCases;

import dev.rafaelsimionato.gestao_cursos.modules.course.entities.CourseEntity;
import dev.rafaelsimionato.gestao_cursos.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetCoursesUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(String name, String category) {
        return courseRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
    }

}
