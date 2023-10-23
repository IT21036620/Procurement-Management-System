package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Payment;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.PaymentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PaymentRepositoryTests {

    @Autowired
    private PaymentRepository paymentRepository;

    @Test
    public void PaymentRepository_SaveAll_ReturnSavedPayment() {

        //Arrange
        Payment payment = Payment.builder()
                .paymentType("Cash")
                .status(true).build();

        //Act
        Payment savedPayment = paymentRepository.save(payment);

        //Assert
        Assertions.assertThat(savedPayment).isNotNull(); //Positive
        Assertions.assertThat(savedPayment.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedPayment.getPaymentType()).isEqualTo("Cash"); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        Payment payment = Payment.builder().build();

        Assertions.assertThat(payment.getStatus()).isEqualTo(false);  //Negative
        Assertions.assertThat(payment.getPaymentType()).isEqualTo("free");  //Negative
    }
}
