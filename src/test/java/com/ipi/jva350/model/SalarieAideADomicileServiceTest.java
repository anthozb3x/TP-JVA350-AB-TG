package com.ipi.jva350.model;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
public class SalarieAideADomicileServiceTest {

    @Autowired
    public SalarieAideADomicileService salarieAideADomicileService;

    @Autowired
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @BeforeEach
    public void setUp() {
        SalarieAideADomicile salarie = new SalarieAideADomicile("Paul",
                LocalDate.of(2023, 6, 28), LocalDate.now(), 280, 2.5,
                260, 30, 1);
        salarieAideADomicileRepository.save(salarie);
    }

    @Test
    public void testCalculeLimiteEntrepriseCongesPermis() {

        // GIVEN
        LocalDate moisEnCours = LocalDate.of(2024, 3, 1);
        double congesPayesAcquisAnneeNMoins1 = 25;
        LocalDate moisDebutContrat = LocalDate.of(2019, 5, 15);
        LocalDate premierJourDeConge = LocalDate.of(2024, 7, 1);
        LocalDate dernierJourDeConge = LocalDate.of(2024, 7, 15);

        // WHEN
        long limiteCongesPermis = salarieAideADomicileService.calculeLimiteEntrepriseCongesPermis(moisEnCours, congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourDeConge, dernierJourDeConge);
        long resultatAttendu = 11;

        // THEN
        Assertions.assertEquals(resultatAttendu, limiteCongesPermis, "La limite de congés permis calculée doit correspondre au résultat attendu");
    }

}
