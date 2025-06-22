package cz.czechitas.ukol06.svatky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.nio.file.Path;
import java.time.MonthDay;
import java.util.List;

public class SvatkySluzba {

    private final ObjectMapper objectMapper = JsonMapper.builder()
            .addModule(new JavaTimeModule())
            .build();
    private final Path cestaKDatum = Path.of("data/svatky.json");
    private final SeznamSvatku seznamSvatku;

    public SvatkySluzba() throws IOException {
        //  načíst seznam svátků ze souboru svatky.json
        seznamSvatku = objectMapper.readValue(cestaKDatum.toFile(), SeznamSvatku.class);
        // Následující řádek po vlastní implementaci smažete.
        // seznamSvatku = null;
    }

    public List<String> vyhledatSvatkyDnes() {
        return vyhledatSvatkyKeDni(MonthDay.now());
    }

    public List<String> vyhledatSvatkyKeDni(MonthDay day) {
        /*  List<Svatek> svatekList = seznamSvatku.getSvatky();
        List<String> vysledek = new ArrayList<>();
        for (int i = 0; i < svatekList.size(); i++) {
            Svatek svatek = svatekList.get(i);
            if (svatek.getDen().equals(day)) {
                vysledek.add(svatek.getJmeno());
            }
        }
        return vysledek; */


        return seznamSvatku.getSvatky()                                          // získat seznam svátků
                .stream()                                                // převést na Stream
                .filter(svatek -> svatek.getDen().equals(day))   // pomocí metody filter() vybrat jen ty, které odpovídají zadanému dni (porovnat MonthDay pomocí metodyequals())
                .map(Svatek::getJmeno)                                 //  .map(svatek -> svatek.getJmeno()   // pomocí metody map() získat z objektu jméno
                .toList();                                            // pomocí toList() převést na List

        // Následující řádek po vlastní implementaci smažete.
        // return List.of();
    }
}
