package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Company;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.CompanyRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class CompanyRepositoryTests {

    @Autowired
    private CompanyRepository companyRepository;

    @Test
    public void CompanyRepository_SaveAll_ReturnSavedCompany() {

        //Arrange
        Company company = Company.builder()
                .companyName("SLIIT")
                .hoAddress("Malabe")
                .contactNo("0112345678")
                .email("sliit@my.sliit.lk").build();

        //Act
        Company savedCompany = companyRepository.save(company);

        //Assert
        Assertions.assertThat(savedCompany).isNotNull(); //Positive
        Assertions.assertThat(savedCompany.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedCompany.getCompanyName()).isEqualTo("SLIIT"); //Positive
        Assertions.assertThat(savedCompany.getHoAddress()).isEqualTo("Malabe"); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        Company company = Company.builder().build();

        Assertions.assertThat(company.getCompanyName()).isEqualTo("hello");  //Negative
        Assertions.assertThat(company.getHoAddress()).isNotNull();  //Negative
    }
}
