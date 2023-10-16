package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Requisition;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.RequisitionRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class RequisitionRepositoryTests {

    @Autowired
    private RequisitionRepository requisitionRepository;

    @Test
    public void RequisitionRepository_SaveAll_ReturnSavedRequisition() {

        //Arrange
        Requisition requisition = Requisition.builder()
                .reqOrdNo("Nimal")
                .details("password")
                .status("PENDING").build();

        //Act
        Requisition savedRequisition = requisitionRepository.save(requisition);

        //Assert
        Assertions.assertThat(savedRequisition).isNotNull(); //Positive
        Assertions.assertThat(savedRequisition.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedRequisition.getStatus()).isEqualTo("PENDING"); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        Requisition requisition = Requisition.builder().build();

        Assertions.assertThat(requisition.getStatus()).isEqualTo("hello");  //Negative
        Assertions.assertThat(requisition.getReqOrdNo()).isEqualTo("negative");  //Negative
    }
}
