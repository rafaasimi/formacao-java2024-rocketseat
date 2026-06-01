package dev.rafaelsimionato.cursos_programacao.modules.courses.useCases;

import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseEntity;
import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseRepository;
import dev.rafaelsimionato.cursos_programacao.modules.courses.exeptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute(String name, String category) {

        List<CourseEntity> courses;

        if (name.isBlank() && category.isBlank()) {
            courses = courseRepository.findAll();
        } else if (name.isBlank()) {
            courses = courseRepository.findByCategoryContainingIgnoreCase(category);
        } else if (category.isBlank()) {
            courses = courseRepository.findByNameContainingIgnoreCase(name);
        } else {
            courses = courseRepository.findByNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(name, category);
        }

        if (courses.isEmpty()) {
            throw new CourseNotFoundException();
        }

        return courses;
    }

}
