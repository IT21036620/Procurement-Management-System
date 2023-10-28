import React, { useContext } from "react";
import {
  View,
  Text,
  FlatList,
  TouchableOpacity,
  StyleSheet,
  Alert,
} from "react-native";
import { CartContext } from "../../Context/CartContext";
import { OrderContext } from "../../Context/OrderContext";

const CartScreen = ({ navigation }) => {
  const { cart, total, purchaseItems, removeFromCart, clearCart } =
    useContext(CartContext);
  const { addOrder } = useContext(OrderContext);

  const placeOrder = () => {
    if (total > 100000) {
      Alert.alert(
        "Large Order!",
        `Total price is Rs.${total.toFixed(
          2
        )}. Please get the approval from the Procurement management. Please get the approval from the Procurement management.`,
        [
          {
            text: "Cancel",
            style: "cancel",
          },
          {
            text: "Confirm",
            onPress: () => {
              createOrder();
            },
          },
        ],
        { cancelable: false }
      );
    } else {
      createOrder();
    }
  };

  const createOrder = () => {
    const order = {
      orderNo: "ORD" + Date.now(),
      totalPrice: total,
      status: "pending",
    };
    addOrder(order);
    clearCart();
    navigation.navigate("Orders");
  };

  const renderCartItem = ({ item }) => (
    <View style={styles.cartItem}>
      <View style={styles.itemDetails}>
        <Text style={styles.itemName}>{item.title}</Text>
        <Text style={styles.itemDetail}>
          Quantity: {item.quantity} | Rs. {item.price * item.quantity}
        </Text>
      </View>
      <TouchableOpacity
        onPress={() => removeFromCart(item.id)}
        style={styles.removeItemButton}
      >
        <Text style={styles.buttonText}>Remove</Text>
      </TouchableOpacity>
    </View>
  );

  return (
    <View style={styles.container}>
      <FlatList
        data={cart}
        renderItem={renderCartItem}
        keyExtractor={(item) => item.id.toString()}
        contentContainerStyle={styles.cartList}
      />

      <View style={styles.totalContainer}>
        <Text style={styles.totalText}>Total Price: Rs. {total}</Text>
      </View>

      <TouchableOpacity onPress={placeOrder} style={styles.purchaseButton}>
        <Text style={styles.buttonText}>Purchase</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    backgroundColor: "white",
  },
  cartList: {
    paddingBottom: 50,
  },
  cartItem: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    padding: 16,
    marginVertical: 4,
    backgroundColor: "#f5f5f5",
    borderRadius: 8,
    elevation: 2,
    shadowOpacity: 0.1,
    shadowRadius: 8,
    shadowOffset: { height: 4, width: 0 },
  },
  itemDetails: {
    flex: 1,
  },
  itemName: {
    fontSize: 18,
    fontWeight: "bold",
  },
  itemDetail: {
    fontSize: 14,
    color: "#666",
  },
  itemTotalPrice: {
    fontSize: 16,
    color: "#333",
  },
  totalContainer: {
    position: "absolute",
    bottom: 60,
    left: 16,
    right: 16,
  },
  totalText: {
    fontSize: 20,
    fontWeight: "bold",
  },
  purchaseButton: {
    position: "absolute",
    bottom: 10,
    left: 16,
    right: 16,
    padding: 12,
    backgroundColor: "green",
    alignItems: "center",
    borderRadius: 8,
  },
  buttonText: {
    color: "white",
    fontSize: 16,
  },
  removeItemButton: {
    padding: 5,
    backgroundColor: "red",
    borderRadius: 4,
  },
});

export default CartScreen;
