package dev.rafaelsimionato.cursos_programacao.modules.courses.exeptions;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException() {
        super("Course not found");
    }
    
}
