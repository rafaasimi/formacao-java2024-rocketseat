package dev.rafaelsimionato.cursos_programacao.modules.courses.useCases;

import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseEntity;
import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public List<CourseEntity> execute() {
        return this.courseRepository.findAll();
    }

}
