package com.ipi.jva350.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import com.ipi.jva350.model.Entreprise;

public class EntrepriseTest {
    @Test
    public void testEstDansPlageTrue() {

        // GIVEN

        // WHEN
            boolean res = Entreprise.estDansPlage(LocalDate.now(), LocalDate.of(2024,02,18), LocalDate.of(2024,04,10));
        // THEN

        Assertions.assertEquals(true, res, "La date indiquée est bien dans la plage selectionnée");
    }

    @Test
    public void testEstDansPlageFalse() {

        // GIVEN

        // WHEN
        boolean res = Entreprise.estDansPlage(LocalDate.now(), LocalDate.of(2012,02,18), LocalDate.of(2023,04,10));
        // THEN

        Assertions.assertEquals(false, res, "La date indiquée n'est pas dans la plage selectionnée");
    }
}