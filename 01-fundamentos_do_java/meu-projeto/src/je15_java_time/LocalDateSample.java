package je15_java_time;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class LocalDateSample {

    public static void main(String[] args) {

        LocalDate dataAtual = LocalDate.now();
//        LocalDate dataNascimento = LocalDate.of(1996, 10, 7);
        LocalDate dataNascimento = LocalDate.of(1996, Month.OCTOBER, 7);

        System.out.println("Hoje é dia: " + dataAtual);
        System.out.println("Minha data de nascimento: " + dataNascimento);

        // Formatação de data
        String stringDataBr = "07/10/1996";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(stringDataBr, formatter);
        System.out.println("Data formato BR: " + stringDataBr + " e a data padrão ISO é: " + dataFormatada);

        DateTimeFormatter formatterPadraoBr = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Eu nasci em: " + formatterPadraoBr.format(dataNascimento));

        // Manipulação de data
        LocalDate aniversarioRafael = LocalDate.of(1996, 10, 7);
        LocalDate dataQueTera30Anos = aniversarioRafael.plusYears(30);
        System.out.println("Terei 30 anos em: " + dataQueTera30Anos);

        LocalDate dataPagamento = LocalDate.of(2025, 12, 04);
        LocalDate dataPagamentoMenos90Dias = dataPagamento.minusDays(90);
        System.out.println("Data pagamento menos 90 dias é: " + dataPagamentoMenos90Dias);

        System.out.println("Já completei 30 anos?: " + dataAtual.isAfter(dataQueTera30Anos));

        // Formatações prontas
        System.out.println(dataAtual.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT))); // 04/12/2025
        System.out.println(dataAtual.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM))); // 4 de dez. de 2025
        System.out.println(dataAtual.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG))); // 4 de dezembro de 2025
        System.out.println(dataAtual.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL))); // quinta-feira, 4 de dezembro de 2025

        // Formatações com locales
        LocalDate dataPadraoSistema = LocalDate.now();
        Locale[] locales = {
                Locale.CANADA,
                Locale.US,
                Locale.UK,
                Locale.of("pt", "BR")
        };

        for(Locale locale : locales) {
            String dataFormated = dataPadraoSistema.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).withLocale(locale));
            System.out.println(dataFormated);
        }


    }

}
