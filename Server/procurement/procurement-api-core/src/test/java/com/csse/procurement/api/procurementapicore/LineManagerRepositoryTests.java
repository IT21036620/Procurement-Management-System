package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.LineManager;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.LineManagerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class LineManagerRepositoryTests {

    @Autowired
    private LineManagerRepository lineManagerRepository;

    @Test
    public void LineManagerRepository_SaveAll_ReturnSavedLineManager() {

        //Arrange
        LineManager lineManager = LineManager.builder()
                .userName("Nimal")
                .password("password")
                .contactNo("0321234567")
                .email("nimal@my.sliit.lk")
                .employeeCode("def123")
                .role("Manager")
                .managementCode("manage123")
                .authorizedStatus(true).build();

        //Act
        LineManager savedLineManager = lineManagerRepository.save(lineManager);

        //Assert
        Assertions.assertThat(savedLineManager).isNotNull(); //Positive
        Assertions.assertThat(savedLineManager.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedLineManager.getAuthorizedStatus()).isEqualTo(true); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        LineManager lineManager = LineManager.builder().build();

        Assertions.assertThat(lineManager.getEmail()).isEqualTo("email");  //Negative
        Assertions.assertThat(lineManager.getRole()).isEqualTo("Admin");  //Negative
    }
}
