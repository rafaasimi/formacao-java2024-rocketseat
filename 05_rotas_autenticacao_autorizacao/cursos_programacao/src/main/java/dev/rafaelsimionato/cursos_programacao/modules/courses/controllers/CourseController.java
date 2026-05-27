package dev.rafaelsimionato.cursos_programacao.modules.courses.controllers;

import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseEntity;
import dev.rafaelsimionato.cursos_programacao.modules.courses.useCases.CreateCourseUseCase;
import dev.rafaelsimionato.cursos_programacao.modules.courses.useCases.GetCourseUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private GetCourseUseCase getCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCourse(@RequestBody CourseEntity courseEntity) {
        try {
            var result = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating course");
        }
    }

    @GetMapping("/")
    public ResponseEntity<Object> getCourses(
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String category) {
        try {
            var result = this.getCourseUseCase.execute(name, category);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
