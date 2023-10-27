import React, { useState, useContext } from 'react';
import { View, Text, StyleSheet, TextInput, TouchableOpacity, Image } from 'react-native';
import { CartContext } from '../../Context/CartContext'; // Adjust this import to your file structure

const ItemDetailsScreen = ({ route, navigation }) => {
    const { item } = route.params;
    const [quantity, setQuantity] = useState(1);

    const { addToCart } = useContext(CartContext);

    const handleAddToCart = () => {
        addToCart({ ...item, quantity: parseInt(quantity) });
        navigation.navigate('CartScreen')
        //goBack();
    };

    if (!route.params || !route.params.item) {
        return <Text>Error: No item details provided!</Text>;
    }

    return (
        <View style={styles.container}>
            <Image source={{ uri: item.image }} style={styles.itemImage} />
            <Text style={styles.itemTitle}>{item.title}</Text>
            <Text style={styles.itemPrice}>{item.price}</Text>
            <Text style={styles.itemDescription}>{item.description}</Text>

            <Text style={styles.quantityLabel}>Quantity:</Text>
            <TextInput
                value={quantity.toString()}
                onChangeText={setQuantity}
                keyboardType="numeric"
                style={styles.quantityInput}
            />

            <TouchableOpacity onPress={handleAddToCart} style={styles.addToCartButton}>
                <Text style={styles.buttonText}>Add to Cart</Text>
            </TouchableOpacity>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 16,
        alignItems: 'center',
        backgroundColor: 'white',
    },
    itemImage: {
        width: 150,
        height: 150,
        marginBottom: 20,
        borderRadius: 10,
    },
    itemTitle: {
        fontSize: 24,
        fontWeight: 'bold',
        marginBottom: 10,
    },
    itemPrice: {
        fontSize: 20,
        marginBottom: 20,
    },
    quantityLabel: {
        fontSize: 18,
        marginBottom: 8,
    },
    quantityInput: {
        width: 100,
        height: 40,
        borderWidth: 1,
        borderColor: '#e5e5e5',
        padding: 8,
        marginBottom: 20,
        textAlign: 'center',
    },
    addToCartButton: {
        padding: 12,
        backgroundColor: 'blue',
        borderRadius: 8,
    },
    buttonText: {
        color: 'white',
        fontSize: 16,
    },
});

export default ItemDetailsScreen;
