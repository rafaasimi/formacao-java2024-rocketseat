package dev.rafaelsimionato.gestao_cursos.exceptions;

public class CourseNotFoundException extends RuntimeException{
    public CourseNotFoundException() {
        super("Curso não encontrado.");
    }
}
