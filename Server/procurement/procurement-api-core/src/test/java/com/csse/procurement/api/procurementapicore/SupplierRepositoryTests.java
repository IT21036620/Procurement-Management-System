package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Requisition;
import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Supplier;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.SupplierRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class SupplierRepositoryTests {

    @Autowired
    private SupplierRepository supplierRepository;

    @Test
    public void SupplierRepository_SaveAll_ReturnSavedSupplier() {

        //Arrange
        Supplier supplier = Supplier.builder()
                .supplierName("Kusal")
                .address("Moratuwa")
                .contactNo("0778765432")
                .email("kusal@my.sliit.lk").build();

        //Act
        Supplier savedSupplier = supplierRepository.save(supplier);

        //Assert
        Assertions.assertThat(savedSupplier).isNotNull(); //Positive
        Assertions.assertThat(savedSupplier.getId()).isGreaterThan(0); //Positive
        Assertions.assertThat(savedSupplier.getContactNo()).isEqualTo("0778765432"); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        Supplier supplier = Supplier.builder().build();

        Assertions.assertThat(supplier.getSupplierName()).isEqualTo("name");  //Negative
        Assertions.assertThat(supplier.getAddress()).isEqualTo("city");  //Negative
    }
}
