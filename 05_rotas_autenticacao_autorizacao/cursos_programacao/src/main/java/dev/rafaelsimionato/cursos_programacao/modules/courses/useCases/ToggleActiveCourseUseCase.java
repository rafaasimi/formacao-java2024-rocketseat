package dev.rafaelsimionato.cursos_programacao.modules.courses.useCases;

import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseEntity;
import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseRepository;
import dev.rafaelsimionato.cursos_programacao.modules.courses.exeptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ToggleActiveCourseUseCase {

    @Autowired
    CourseRepository courseRepository;

    public CourseEntity execute(UUID idCourse) {
        var course = this.courseRepository.findById(idCourse)
                .orElseThrow(() -> {
                    throw new CourseNotFoundException();
                });

        course.setActive(!course.isActive());
        return this.courseRepository.save(course);
    }

}
