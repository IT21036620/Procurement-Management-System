package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.PurchaseOrder;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.PurchaseOrderRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class PurchaseOrderRepositoryTests {

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;

    @Test
    public void PurchaseOrderRepository_SaveAll_ReturnSavedPurchaseOrder() {

        //Arrange
        PurchaseOrder purchaseOrder = PurchaseOrder.builder()
                .poReference("ref123")
                .status("PENDING")
                .totalPrice(1500.50).build();

        //Act
        PurchaseOrder savedPurchaseOrder = purchaseOrderRepository.save(purchaseOrder);

        //Assert
        Assertions.assertThat(savedPurchaseOrder).isNotNull(); //Positive
        Assertions.assertThat(savedPurchaseOrder.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedPurchaseOrder.getPoReference()).isEqualTo("ref123"); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        PurchaseOrder purchaseOrder = PurchaseOrder.builder().build();

        Assertions.assertThat(purchaseOrder.getStatus()).isEqualTo("hello");  //Negative
        Assertions.assertThat(purchaseOrder.getPoReference()).isEqualTo("ref");  //Negative
    }
}
