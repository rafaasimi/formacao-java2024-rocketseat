package dev.rafaelsimionato.gestao_cursos.modules.course.controllers;

import dev.rafaelsimionato.gestao_cursos.exceptions.ErrorMessageDTO;
import dev.rafaelsimionato.gestao_cursos.modules.course.dtos.CreateCourseRequestDTO;
import dev.rafaelsimionato.gestao_cursos.modules.course.dtos.UpdateCourseRequestDTO;
import dev.rafaelsimionato.gestao_cursos.modules.course.entities.CourseEntity;
import dev.rafaelsimionato.gestao_cursos.modules.course.useCases.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Cursos", description = "Endpoints responsáveis pelo gerenciamento de cursos.")
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

    @Operation(
            summary = "Cadastro de curso",
            description = "Endpoint responsável pelo cadastro de um novo curso."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", content = @Content(schema = @Schema(implementation = CourseEntity.class))),
            @ApiResponse(responseCode = "500")
    })
    @PostMapping("/")
    public ResponseEntity<CourseEntity> create(@Valid @RequestBody CreateCourseRequestDTO createCourseRequestDTO) {
        var result = createCourseUseCase.execute(createCourseRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @Operation(
            summary = "Listagem de cursos",
            description = "Endpoint responsável pelo listagem de cursos baseado em filtros."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    content = @Content(array = @ArraySchema(schema = @Schema(implementation = CourseEntity.class)))),
    })
    @GetMapping("/")
    public ResponseEntity<List<CourseEntity>> getAll(@RequestParam(required = false) String name, @RequestParam(required = false) String category) {
        var result = getCoursesUseCase.execute(name, category);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(
            summary = "Atualização de curso",
            description = "Endpoint responsável pelo atualização de um curso."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CourseEntity.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorMessageDTO.class)))
    })
    @PatchMapping("/{courseId}")
    public ResponseEntity<CourseEntity> update(@PathVariable UUID courseId, @Valid @RequestBody UpdateCourseRequestDTO updateCourseRequestDTO) {
        var result = updateCourseUseCase.execute(courseId, updateCourseRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(
            summary = "Remoção de curso",
            description = "Endpoint responsável pela remoção de um curso."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Curso removido com sucesso."),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorMessageDTO.class)))
    })
    @DeleteMapping("/{courseId}")
    public ResponseEntity<String> delete(@PathVariable UUID courseId) {
        var result = deleteCourseUseCase.execute(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @Operation(
            summary = "Habilitar curso",
            description = "Endpoint responsável por habilitar/desabilitar um curso."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = CourseEntity.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorMessageDTO.class)))
    })
    @PatchMapping("/{courseId}/active")
    public ResponseEntity<CourseEntity> active(@PathVariable UUID courseId) {
        var result = activeCourseUseCase.execute(courseId);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
