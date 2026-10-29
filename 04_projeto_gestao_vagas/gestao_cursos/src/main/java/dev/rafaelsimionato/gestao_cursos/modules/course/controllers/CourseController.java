package dev.rafaelsimionato.gestao_cursos.modules.course.controllers;

import dev.rafaelsimionato.gestao_cursos.modules.course.dtos.CreateCourseRequestDTO;
import dev.rafaelsimionato.gestao_cursos.modules.course.dtos.UpdateCourseRequestDTO;
import dev.rafaelsimionato.gestao_cursos.modules.course.entities.CourseEntity;
import dev.rafaelsimionato.gestao_cursos.modules.course.useCases.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private GetCoursesUseCase getCoursesUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private ActiveCourseUseCase activeCourseUseCase;

    @PostMapping("/")
    public ResponseEntity<CourseEntity> create(@Valid @RequestBody CreateCourseRequestDTO createCourseRequestDTO) {
        var result = createCourseUseCase.execute(createCourseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/")
    public ResponseEntity<List<CourseEntity>> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
        var result = getCoursesUseCase.execute(name, category);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseEntity> update(@PathVariable UUID courseId, @Valid @RequestBody UpdateCourseRequestDTO updateCourseRequestDTO) {
        var result = updateCourseUseCase.execute(courseId, updateCourseRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> delete(@PathVariable UUID courseId) {
        var result = deleteCourseUseCase.execute(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PatchMapping("/{courseId}/active")
    public ResponseEntity<CourseEntity> active(@PathVariable UUID courseId) {
        var result = activeCourseUseCase.execute(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
