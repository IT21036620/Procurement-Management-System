package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Invoice;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.InvoiceRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDateTime;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class InvoiceRepositoryTests {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Test
    public void InvoiceRepository_SaveAll_ReturnSavedInvoice() {

        //Arrange
        Invoice invoice = Invoice.builder()
                .description("order1")
                .dueDate(LocalDateTime.parse("2023-10-30T13:30:00"))
                .documentDate(LocalDateTime.parse("2023-10-16T13:30:00"))
                .totalAmount(500.50).build();

        //Act
        Invoice savedInvoice = invoiceRepository.save(invoice);

        //Assert
        Assertions.assertThat(savedInvoice).isNotNull(); //Positive
        Assertions.assertThat(savedInvoice.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedInvoice.getDescription()).isEqualTo("order1"); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        Invoice invoice = Invoice.builder().build();

        Assertions.assertThat(invoice.getDescription()).isEqualTo("empty");  //Negative
        Assertions.assertThat(invoice.getTotalAmount()).isEqualTo(100.00);  //Negative
    }
}
