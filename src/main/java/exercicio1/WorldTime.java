package exercicio1;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * Classe utilitária que permite obter a hora atual de um país.
 * A hora é calculada com a biblioteca
 * <a href="https://www.joda.org/joda-time/">Joda-Time</a>, a partir do fuso
 * horário associado ao país indicado.
 * Nos países com vários fusos horários (por exemplo, Estados Unidos, Brasil,
 * Rússia ou Austrália), é usado o fuso da capital ou da cidade principal.
 * No caso de Portugal, é usado o fuso de Portugal continental.
 *
 * @author Pedro Cunha
 * @version 1.0
 */
public class WorldTime {

    /**
     * Construtor privado, porque esta classe não deve ser instanciada.
     */
    private WorldTime() {
    }

    /**
     * Devolve a hora atual do país indicado, no formato {@code HH:mm}.
     * O país é identificado pelo seu código ISO de duas letras (por exemplo,
     * {@code "PT"}, {@code "BR"} ou {@code "JP"}). O código não distingue
     * maiúsculas de minúsculas e os espaços no início e no fim são ignorados.
     * A hora é apresentada no formato de 24 horas ({@code HH}), para evitar a
     * ambiguidade do formato de 12 horas sem indicação de AM/PM.
     *
     * @param siglaPais código ISO de duas letras do país (por exemplo, {@code "PT"})
     * @return a hora atual do país no formato {@code HH:mm} (por exemplo,
     *         {@code "14:30"}); {@code "Erro: País não indicado."} se o código
     *         for {@code null}; ou {@code "Erro: País desconhecido."} se o país
     *         não for suportado
     */
    public static String getTimeByCountry(String siglaPais) {
        if (siglaPais == null) {
            return "Erro: País não indicado.";
        }

        String sigla = siglaPais.trim().toUpperCase();
        String zona = getZonaHoraria(sigla);

        if (zona == null) {
            return "Erro: País desconhecido.";
        }

        DateTimeZone fuso = DateTimeZone.forID(zona);
        DateTime horaAgora = new DateTime(fuso);

        String hora = horaAgora.toString("HH:mm");

        return hora;
    }

    /**
     * Devolve o identificador do fuso horário associado a um país.
     * Os identificadores seguem o formato da base de dados de fusos horários
     * usada pelo Joda-Time (por exemplo, {@code "Europe/Lisbon"}).
     *
     * @param codigoPais código ISO de duas letras do país, em maiúsculas
     *                   (não pode ser {@code null})
     * @return o identificador do fuso horário do país, ou {@code null} se o
     *         país não for suportado
     */
    private static String getZonaHoraria(String codigoPais) {
        return switch (codigoPais) {
            // Europa
            case "PT" -> "Europe/Lisbon";      // Portugal continental (Açores têm outro fuso)
            case "ES" -> "Europe/Madrid";
            case "FR" -> "Europe/Paris";
            case "DE" -> "Europe/Berlin";
            case "IT" -> "Europe/Rome";
            case "GB" -> "Europe/London";
            case "IE" -> "Europe/Dublin";
            case "NL" -> "Europe/Amsterdam";
            case "BE" -> "Europe/Brussels";
            case "CH" -> "Europe/Zurich";
            case "GR" -> "Europe/Athens";
            case "PL" -> "Europe/Warsaw";
            case "SE" -> "Europe/Stockholm";
            case "RU" -> "Europe/Moscow";      // Rússia tem 11 fusos; usa Moscovo

            // América
            case "US" -> "America/New_York";   // EUA têm vários fusos; usa a costa leste
            case "CA" -> "America/Toronto";    // Canadá tem vários fusos; usa Toronto
            case "MX" -> "America/Mexico_City";
            case "BR" -> "America/Sao_Paulo";  // Brasil tem vários fusos; usa São Paulo/Brasília
            case "AR" -> "America/Argentina/Buenos_Aires";
            case "CL" -> "America/Santiago";
            case "CO" -> "America/Bogota";
            case "PE" -> "America/Lima";

            // África
            case "AO" -> "Africa/Luanda";
            case "MZ" -> "Africa/Maputo";
            case "CV" -> "Atlantic/Cape_Verde";
            case "ZA" -> "Africa/Johannesburg";
            case "EG" -> "Africa/Cairo";
            case "MA" -> "Africa/Casablanca";
            case "NG" -> "Africa/Lagos";
            case "KE" -> "Africa/Nairobi";

            // Ásia
            case "CN" -> "Asia/Shanghai";
            case "JP" -> "Asia/Tokyo";
            case "IN" -> "Asia/Kolkata";
            case "KR" -> "Asia/Seoul";
            case "AE" -> "Asia/Dubai";
            case "SG" -> "Asia/Singapore";
            case "TH" -> "Asia/Bangkok";
            case "TR" -> "Europe/Istanbul";
            case "IL" -> "Asia/Jerusalem";

            // Oceânia
            case "AU" -> "Australia/Sydney";   // Austrália tem vários fusos; usa Sydney
            case "NZ" -> "Pacific/Auckland";

            default -> null;                   // país desconhecido
        };
    }
}