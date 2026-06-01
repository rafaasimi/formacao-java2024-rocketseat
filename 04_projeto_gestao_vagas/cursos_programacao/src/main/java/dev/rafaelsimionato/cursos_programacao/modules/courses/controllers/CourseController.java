package dev.rafaelsimionato.cursos_programacao.modules.courses.controllers;

import dev.rafaelsimionato.cursos_programacao.modules.courses.CourseEntity;
import dev.rafaelsimionato.cursos_programacao.modules.courses.dto.CreateCourseRequestDTO;
import dev.rafaelsimionato.cursos_programacao.modules.courses.dto.UpdateCourseRequestDTO;
import dev.rafaelsimionato.cursos_programacao.modules.courses.useCases.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/courses")
@Tag(name = "Cursos", description = "Endpoints relacionados aos cursos")
public class CourseController {

    @Autowired
    private CreateCourseUseCase createCourseUseCase;

    @Autowired
    private GetCourseUseCase getCourseUseCase;

    @Autowired
    private UpdateCourseUseCase updateCourseUseCase;

    @Autowired
    private DeleteCourseUseCase deleteCourseUseCase;

    @Autowired
    private ToggleActiveCourseUseCase toggleActiveCourseUseCase;

    @PostMapping("/")
    @Operation(summary = "Criar novo curso", description = "Endpoint responsável pela criação de um novo curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", content = {
                    @Content(
                            schema = @Schema(implementation = CourseEntity.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Error creating course")
    })
    public ResponseEntity<Object> createCourse(@RequestBody CreateCourseRequestDTO createCourseRequestDTO) {

        var courseEntity = CourseEntity.builder()
                .name(createCourseRequestDTO.getName())
                .category(createCourseRequestDTO.getCategory())
                .teacher(createCourseRequestDTO.getTeacher())
                .active(createCourseRequestDTO.isActive())
                .build();

        try {
            var result = this.createCourseUseCase.execute(courseEntity);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error creating course");
        }
    }

    @GetMapping("/")
    @Operation(summary = "Buscar cursos", description = "Endpoint responsável pela busca por uma lista de cursos baseada em filtros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            array = @ArraySchema(schema = @Schema(implementation = CourseEntity.class))
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Course not found")
    })
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

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar curso", description = "Endpoint responsável por realizar a atualização de dados de um curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            schema = @Schema(implementation = CourseEntity.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Course not found")
    })
    public ResponseEntity<Object> updateCourse(@PathVariable UUID id, @RequestBody UpdateCourseRequestDTO updateCourseRequestDTO) {

        var courseEntity = CourseEntity.builder()
                .name(updateCourseRequestDTO.getName())
                .category(updateCourseRequestDTO.getCategory())
                .teacher(updateCourseRequestDTO.getTeacher())
                .build();

        try {
            var result = this.updateCourseUseCase.execute(id, courseEntity);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remover curso", description = "Endpoint responsável por excluir um curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "400", description = "Course not found")
    })

    public ResponseEntity<Object> deleteCourse(@PathVariable UUID id) {
        try {
            this.deleteCourseUseCase.execute(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/active")
    @Operation(summary = "Habilitar curso", description = "Endpoint responsável habilitar ou desabilitar um curso")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = {
                    @Content(
                            schema = @Schema(implementation = CourseEntity.class)
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Course not found")
    })
    public ResponseEntity<Object> toggleActiveCourse(@PathVariable UUID id) {
        try {
            var result = this.toggleActiveCourseUseCase.execute(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
