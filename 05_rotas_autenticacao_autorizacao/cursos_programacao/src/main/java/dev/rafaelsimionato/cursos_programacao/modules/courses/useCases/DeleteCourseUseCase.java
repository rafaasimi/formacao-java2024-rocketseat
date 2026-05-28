package dev.rafaelsimionato.cursos_programacao.modules.courses.useCases;

import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseRepository;
import dev.rafaelsimionato.cursos_programacao.modules.courses.exeptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public void execute(UUID idCourse) {
        var course = courseRepository.findById(idCourse)
                .orElseThrow(() -> {
                    throw new CourseNotFoundException();
                });

        this.courseRepository.deleteById(course.getId());
    }

}
