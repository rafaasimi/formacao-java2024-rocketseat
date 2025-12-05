package je15_java_time;

import java.time.LocalDateTime;

public class LocalDateTimeSample {

    public static void main(String[] args) {

        LocalDateTime dataHoraAtual = LocalDateTime.now(); // 2025-12-05T08:26:02.343461400
        System.out.println(dataHoraAtual); // 2025-12-05T08:21:56.845843200
        System.out.println(dataHoraAtual.withNano(0)); // 2025-12-05T08:21:56
        System.out.println(dataHoraAtual.withSecond(0).withNano(0)); // 2025-12-05T08:24

        LocalDateTime proximoMes = dataHoraAtual.plusMonths(1);
        System.out.println(proximoMes); // 2026-01-05T08:26:02.343461400

        // Comparando datas
        LocalDateTime dataHora1 = LocalDateTime.of(2025, 12, 5, 8, 27);
        LocalDateTime dataHora2 = LocalDateTime.of(1996, 10, 7, 9, 15);
        System.out.println(dataHora1.equals(dataHora2)); // false

    }
}
