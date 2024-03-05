package com.ipi.jva350.model;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;


@DataJpaTest
public class SalarieAideADomicileRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SalarieAideADomicileRepository repository;

    @BeforeEach
    public void setUp() {

        // GIVEN
        SalarieAideADomicile salarie = new SalarieAideADomicile("Paul",
                LocalDate.of(2023, 6, 28), LocalDate.now(), 20, 2.5,
                9, 1, 8);
        entityManager.persist(salarie);
        entityManager.flush();
    }
    @Test
    public void testPartCongesPrisTotauxAnneeNMoins1() {

        // WHEN
        Double result = repository.partCongesPrisTotauxAnneeNMoins1();

        // THEN
        Assertions.assertNotNull(result);
        Assertions.assertEquals(8.0, result, 0.01);

    }
}
