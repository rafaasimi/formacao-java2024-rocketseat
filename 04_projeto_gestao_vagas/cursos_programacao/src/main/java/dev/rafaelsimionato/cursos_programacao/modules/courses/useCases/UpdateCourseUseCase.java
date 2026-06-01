package dev.rafaelsimionato.cursos_programacao.modules.courses.useCases;

import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseEntity;
import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseRepository;
import dev.rafaelsimionato.cursos_programacao.modules.courses.exeptions.CourseNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID idCourse, CourseEntity courseEntity) {
        var course = this.courseRepository.findById(idCourse)
                .orElseThrow(() -> {
                    throw new CourseNotFoundException();
                });

        course.setName(courseEntity.getName());
        course.setCategory(courseEntity.getCategory());
        course.setTeacher(courseEntity.getTeacher());

        return this.courseRepository.save(course);
    }

}
