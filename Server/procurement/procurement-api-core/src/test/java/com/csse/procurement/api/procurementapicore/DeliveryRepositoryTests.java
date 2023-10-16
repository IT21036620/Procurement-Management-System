package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Delivery;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.DeliveryRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class DeliveryRepositoryTests {

    @Autowired
    private DeliveryRepository deliveryRepository;

    @Test
    public void DeliveryRepository_SaveAll_ReturnSavedDelivery() {

        //Arrange
        Delivery delivery = Delivery.builder()
                .deliveryAddress("Malabe")
                .status("DISPATCHED").build();

        //Act
        Delivery savedDelivery = deliveryRepository.save(delivery);

        //Assert
        Assertions.assertThat(savedDelivery).isNotNull(); //Positive
        Assertions.assertThat(savedDelivery.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedDelivery.getStatus()).isEqualTo("DISPATCHED"); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        Delivery delivery = Delivery.builder().build();

        Assertions.assertThat(delivery.getDeliveryAddress()).isEqualTo("address");  //Negative
        Assertions.assertThat(delivery.getStatus()).isEqualTo("PENDING");  //Negative
    }
}
