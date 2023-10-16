package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.SiteManager;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.SiteManagerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SiteManagerRepositoryTests {

    @Autowired
    private SiteManagerRepository siteManagerRepository;

    @Test
    public void SiteManagerRepository_SaveAll_ReturnSavedSiteManager() {

        //Arrange
        SiteManager siteManager = SiteManager.builder()
                .userName("Kamal")
                .password("password")
                .contactNo("0112345678")
                .email("kamal@my.sliit.lk")
                .employeeCode("abc123")
                .role("Manager")
                .authorizedStatus(true).build();

        //Act
        SiteManager savedSiteManager = siteManagerRepository.save(siteManager);

        //Assert
        Assertions.assertThat(savedSiteManager).isNotNull(); //Positive
        Assertions.assertThat(savedSiteManager.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedSiteManager.getEmployeeCode()).isEqualTo("abc123"); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        SiteManager siteManager = SiteManager.builder().build();

        Assertions.assertThat(siteManager.getAuthorizedStatus()).isEqualTo(false);  //Negative
        Assertions.assertThat(siteManager.getEmployeeCode()).isEqualTo("code");  //Negative
    }
}
