import React from 'react';
import { View, Text, FlatList, StyleSheet } from 'react-native';

const OrderDetailsScreen = ({ route }) => {
    const { order } = route.params; // Get the order details from navigation params

    const renderOrderItem = ({ item }) => (
        <View style={styles.itemContainer}>
            <Text style={styles.itemName}>{item.name}</Text>
            <Text style={styles.itemQuantity}>Quantity: {item.quantity}</Text>
            <Text style={styles.itemPrice}>Rs. {item.price * item.quantity}</Text>
        </View>
    );

    return (
        <View style={styles.container}>
            <Text style={styles.orderNo}>Order No: {order.orderNo}</Text>
            <Text style={styles.totalPrice}>Total Price: Rs. {order.totalPrice}</Text>
            <Text style={styles.status}>Status: {order.status}</Text>

            <FlatList
                data={order.items}
                renderItem={renderOrderItem}
                keyExtractor={(item, index) => index.toString()}
            />
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 16,
    },
    orderNo: {
        fontWeight: 'bold',
        fontSize: 18,
        marginBottom: 10,
    },
    totalPrice: {
        fontSize: 16,
        marginBottom: 10,
    },
    status: {
        fontStyle: 'italic',
        marginBottom: 20,
    },
    itemContainer: {
        padding: 10,
        borderBottomWidth: 1,
        borderColor: '#e5e5e5',
        flexDirection: 'row',
        justifyContent: 'space-between',
    },
    itemName: {
        fontSize: 16,
    },
    itemQuantity: {
        fontSize: 14,
    },
    itemPrice: {
        fontSize: 14,
        fontWeight: 'bold',
    },
});

export default OrderDetailsScreen;
