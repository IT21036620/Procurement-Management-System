import React, { useState } from "react";
import { View, Text, TextInput, Button, Modal, StyleSheet,TouchableOpacity } from "react-native";

const ItemDetails = ({ route, navigation }) => {
  const item = route.params.item;

  const [quantity, setQuantity] = useState(1);
  const [showModal, setShowModal] = useState(false);

  const totalPrice = quantity * parseFloat(item.price.replace("$", ""));

  return (
    <View style={styles.container}>
      <Text>{item.title}</Text>
      <Text>{item.price}</Text>
      <TextInput
        keyboardType="number-pad"
        style={styles.input}
        value={String(quantity)}
        onChangeText={(text) => setQuantity(Number(text))}
      />
      <Text>Total Price: ${totalPrice.toFixed(2)}</Text>
      <Button
        title="Purchase"
        onPress={() => {
          if (totalPrice > 10000) {
            setShowModal(true);
          } else {
            // Implement your purchase logic here
          }
        }}
      />
      <Modal visible={showModal} transparent={true} animationType="slide">
        <View style={styles.modalContainer}>
          <View style={styles.modalContent}>
            <Text>Total price is Rs.{totalPrice.toFixed(2)}</Text>
            <Text>Please get the approval from the Procurement management.</Text>
            <TouchableOpacity style={styles.sendButton} onPress={() => {
                setShowModal(false);}}>
                    <Text style={styles.sendButtonText}>Send</Text>
                    </TouchableOpacity>
          </View>
        </View>
      </Modal>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
  },
  sendButton: {
    backgroundColor: "#4CAF50", // or the color of the button in your design
    paddingVertical: 15,
    paddingHorizontal: 40,
    borderRadius: 25,
    alignItems: "center",
    marginTop: 20,
},
sendButtonText: {
    fontSize: 18,
    color: "white",
    fontWeight: "bold",
},
sendButtonSubtext: {
    fontSize: 12,
    color: "white",
},
  input: {
    borderWidth: 1,
    padding: 10,
    marginVertical: 20,
  },
  modalContainer: {
    flex: 1,
    justifyContent: "center",
    alignItems: "center",
    backgroundColor: "rgba(0, 0, 0, 0.5)",
  },
  modalContent: {
    width: "80%",
    padding: 20,
    backgroundColor: "white",
    alignItems: "center",
    borderRadius: 10,
  },
});

export default ItemDetails;
