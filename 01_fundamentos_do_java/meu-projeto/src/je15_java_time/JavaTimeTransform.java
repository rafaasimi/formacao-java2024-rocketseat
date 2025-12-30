package je15_java_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JavaTimeTransform {

    public static void main(String[] args) {

        LocalDateTime dataHora = LocalDateTime.of(2025, 12, 5, 8, 30);
        esperaData(dataHora.toLocalDate());
        esperaTime(dataHora.toLocalTime());

        LocalDate localDate = LocalDate.of(2025, 12, 5);
        esperaDateTime(localDate.atTime(8, 0));

        LocalTime localTime = LocalTime.of(8, 36);
        esperaDateTime(localTime.atDate(localDate)); // 2025-12-05T08:36
    }

    static void esperaData(LocalDate data) {
        System.out.println(data); // 2025-12-05
    }

    static void esperaTime(LocalTime time) {
        System.out.println(time); // 08:30
    }

    static void esperaDateTime(LocalDateTime dataHora) {
        System.out.println(dataHora); // 2025-12-05T08:00
    }


}
