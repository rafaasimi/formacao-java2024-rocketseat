package dev.rafaelsimionato.cursos_programacao.modules.courses.controllers;

import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseEntity;
import dev.rafaelsimionato.cursos_programacao.modules.courses.useCases.CreateCourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCourse(@RequestBody CourseEntity courseEntity) {
        try {
            var result = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error creating course");
        }
    }

}
