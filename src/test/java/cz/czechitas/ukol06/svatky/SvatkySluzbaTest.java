package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {
    //implementovat test metody vyhledatSvatkyKeDni
    @Test
    void vyhledatSvatkyKeDni_0() throws IOException {
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        List<String> seznamJmen = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(1, 1));
        assertEquals(0, seznamJmen.size());
    }
    @Test
    void vyhledatSvatkyKeDni_1() throws IOException {
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        List<String> seznamJmen = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(1, 4));
        assertEquals(1, seznamJmen.size());

    }
    @Test
    void vyhledatSvatkyKeDni_moc() throws IOException {
        SvatkySluzba svatkySluzba = new SvatkySluzba();
        List<String> seznamJmen = svatkySluzba.vyhledatSvatkyKeDni(MonthDay.of(1, 2));
        assertEquals(2, seznamJmen.size());


    }
}
