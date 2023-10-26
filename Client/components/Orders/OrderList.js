import React, { useContext } from 'react';
import { View, Text, FlatList, TouchableOpacity, StyleSheet } from 'react-native';
import { OrderContext } from '../../Context/OrderContext';

const OrderListScreen = ({ navigation }) => {
    const { orders } = useContext(OrderContext);

    const handleOrderClick = (order) => {
        navigation.navigate('OrderDetailsScreen', { order });
    };

    const renderOrder = ({ item }) => (
        <TouchableOpacity onPress={() => handleOrderClick(item)} style={styles.orderItem}>
            <Text style={styles.orderNo}>Order No: {item.orderNo}</Text>
            <Text style={styles.orderPrice}>Total Price: Rs.{item.totalPrice}</Text>
            <Text style={styles.orderStatus}>Status: {item.status}</Text>
        </TouchableOpacity>
    );

    return (
        <View style={styles.container}>
            <FlatList
                data={orders}
                renderItem={renderOrder}
                keyExtractor={(item) => item.orderNo.toString()}
            />
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 16,
        backgroundColor: '#f5f5f5',
    },
    orderItem: {
        padding: 16,
        marginVertical: 8,
        borderColor: '#e5e5e5',
        borderWidth: 1,
        borderRadius: 8,
        backgroundColor: 'white',
        shadowColor: "#000",
        shadowOffset: {
            width: 0,
            height: 1,
        },
        shadowOpacity: 0.2,
        shadowRadius: 1.41,
        elevation: 2,
    },
    orderNo: {
        fontWeight: 'bold',
        marginBottom: 5,
    },
    orderPrice: {
        marginBottom: 5,
    },
    orderStatus: {
        fontStyle: 'italic',
        color: 'gray',
    },
});

export default OrderListScreen;
