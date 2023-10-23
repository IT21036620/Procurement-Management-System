package com.csse.procurement.api.procurementapicore;

import com.csse.procurement.api.procurementapicore.adapter.jpa.entity.Item;
import com.csse.procurement.api.procurementapicore.adapter.jpa.repository.ItemRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class ItemRepositoryTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void ItemRepository_SaveAll_ReturnSavedItem() {

        //Arrange
        Item item = Item.builder()
                .name("Tokyo Super")
                .description("Cement")
                .price(1000.00).build();

        //Act
        Item savedItem = itemRepository.save(item);

        //Assert
        Assertions.assertThat(savedItem).isNotNull(); //Positive
        Assertions.assertThat(savedItem.getId()).isGreaterThan(0); //Positive
    }

    @Test
    public void testNegativeAssertions() {
        Item item = Item.builder().build();

        Assertions.assertThat(item.getName()).isEqualTo("item");  //Negative
        Assertions.assertThat(item.getPrice()).isLessThan(0);  //Negative
    }
}
