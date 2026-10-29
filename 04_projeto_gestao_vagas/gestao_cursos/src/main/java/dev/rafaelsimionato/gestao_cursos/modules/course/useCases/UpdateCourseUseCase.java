package dev.rafaelsimionato.gestao_cursos.modules.course.useCases;

import dev.rafaelsimionato.gestao_cursos.exceptions.CourseNotFoundException;
import dev.rafaelsimionato.gestao_cursos.modules.course.dtos.UpdateCourseRequestDTO;
import dev.rafaelsimionato.gestao_cursos.modules.course.entities.CourseEntity;
import dev.rafaelsimionato.gestao_cursos.modules.course.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateCourseUseCase {

    @Autowired
    private CourseRepository courseRepository;

    public CourseEntity execute(UUID courseId, UpdateCourseRequestDTO dto) {
        CourseEntity course = this.courseRepository.findById(courseId)
                .orElseThrow(CourseNotFoundException::new);

        if (dto.getName() != null && !dto.getName().isBlank()) {
            course.setName(dto.getName());
        }

        if (dto.getCategory() != null && !dto.getCategory().isBlank()) {
            course.setCategory(dto.getCategory());
        }

        if (dto.getTeacher() != null && !dto.getTeacher().isBlank()) {
            course.setTeacher(dto.getTeacher());
        }

        return this.courseRepository.save(course);
    }

}
