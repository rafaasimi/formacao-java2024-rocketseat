package dev.rafaelsimionato.gestao_cursos.modules.course.useCases;

import dev.rafaelsimionato.gestao_cursos.modules.course.dtos.CreateCourseRequestDTO;
import dev.rafaelsimionato.gestao_cursos.modules.course.entities.CourseEntity;
import dev.rafaelsimionato.gestao_cursos.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(CreateCourseRequestDTO createCourseRequestDTO) {

        CourseEntity courseEntity = CourseEntity
                .builder()
                .name(createCourseRequestDTO.getName())
                .category(createCourseRequestDTO.getCategory())
                .teacher(createCourseRequestDTO.getTeacher())
                .active(createCourseRequestDTO.getActive() != null ? createCourseRequestDTO.getActive() : false)
                .build();

        return courseRepository.save(courseEntity);

    }

}
