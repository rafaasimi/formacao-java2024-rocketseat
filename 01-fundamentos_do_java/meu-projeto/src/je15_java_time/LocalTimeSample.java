package je15_java_time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeSample {

    public static void main(String[] args) {

        LocalTime horaAtual = LocalTime.now();
        LocalTime horaAtualMais30Minutos = horaAtual.plusMinutes(30);
        LocalTime horaAtualMenos2Horas = horaAtual.minusHours(2);

        System.out.println(horaAtual);
        System.out.println(horaAtualMais30Minutos);
        System.out.println(horaAtualMenos2Horas);

        boolean isPassado = horaAtual.isBefore(horaAtualMenos2Horas);
        System.out.println("A hora atual vem antes do que menos duas horas?: " + isPassado);
        System.out.println("A hora atual vem depois do que menos duas horas?: " + isPassado);

        // Formatação de hora
        LocalTime hora = LocalTime.of(7, 56, 10);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss'h'"); // 07:56:10h
        String horaFormatada = hora.format(formatter);
        System.out.println(horaFormatada);

        // Dados especificos da hora
        System.out.println("Hora: " + horaAtual.getHour());
        System.out.println("Minuto: " + horaAtual.getMinute());
        System.out.println("Segundo: " + horaAtual.getSecond());
        System.out.println("Nano: " + horaAtual.getNano());
    }

}
