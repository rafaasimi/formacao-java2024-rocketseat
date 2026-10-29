package dev.rafaelsimionato.gestao_cursos.modules.course.useCases;

import dev.rafaelsimionato.gestao_cursos.exceptions.CourseNotFoundException;
import dev.rafaelsimionato.gestao_cursos.modules.course.entities.CourseEntity;
import dev.rafaelsimionato.gestao_cursos.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ActiveCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID courseId) {

        CourseEntity courseEntity = courseRepository.findById(courseId).orElseThrow(() -> {
            throw new CourseNotFoundException();
        });

        courseEntity.setActive(!courseEntity.getActive());

        return courseRepository.save(courseEntity);
    }

}
