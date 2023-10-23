package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.CreditNote;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.CreditNoteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CreditNoteRepositoryTests {

    @Autowired
    private CreditNoteRepository creditNoteRepository;

    @Test
    public void CreditNoteRepository_SaveAll_ReturnSavedCreditNote() {

        //Arrange
        CreditNote creditNote = CreditNote.builder()
                .description("order1")
                .amount(500.75).build();

        //Act
        CreditNote savedCreditNote = creditNoteRepository.save(creditNote);

        //Assert
        Assertions.assertThat(savedCreditNote).isNotNull(); //Positive
        Assertions.assertThat(savedCreditNote.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedCreditNote.getDescription()).isEqualTo("order1"); //Positive
        Assertions.assertThat(savedCreditNote.getAmount()).isGreaterThan(0); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        CreditNote creditNote = CreditNote.builder().build();

        Assertions.assertThat(creditNote.getDescription()).isEqualTo("");  //Negative
        Assertions.assertThat(creditNote.getAmount()).isLessThan(0);  //Negative
    }
}
