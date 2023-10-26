import React from "react";
import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  FlatList,
  TextInput,
} from "react-native";
import { Ionicons } from "@expo/vector-icons"; // Assuming you're using Expo. If not, adjust accordingly.

const DATA = [
  { id: "1", title: "Item #1 Name", price: "$19.99" },
  { id: "2", title: "Item #2 Name", price: "$29.99" },
  { id: "3", title: "Item #3 Name", price: "$39.99" },
];

const HomeScreen = () => {
  const renderItem = ({ item }) => (
    <View style={styles.itemContainer}>
      <View style={styles.itemImage}></View>
      <Text style={styles.itemTitle}>{item.title}</Text>
      <Text style={styles.itemPrice}>{item.price}</Text>
    </View>
  );

  return (
    <View style={styles.container}>
      <TextInput style={styles.searchBar} placeholder="Search" />
      <Text style={styles.sectionTitle}>Hot deals</Text>
      <FlatList
        data={DATA}
        renderItem={renderItem}
        keyExtractor={(item) => item.id}
        horizontal={true}
      />
      <Text style={styles.sectionTitle}>Trending</Text>
      <FlatList
        data={DATA}
        renderItem={renderItem}
        keyExtractor={(item) => item.id}
        horizontal={true}
      />
      {/* Add more sections as needed */}
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 16,
    backgroundColor: "white",
  },
  header: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    marginBottom: 16,
  },
  headerTitle: {
    fontSize: 20,
    fontWeight: "bold",
  },
  searchBar: {
    height: 40,
    borderRadius: 20,
    backgroundColor: "#f0f0f0",
    paddingLeft: 16,
    marginBottom: 16,
  },
  sectionTitle: {
    fontSize: 18,
    fontWeight: "bold",
    marginBottom: 8,
  },
  itemContainer: {
    marginRight: 16,
    width: 100,
    alignItems: "center",
  },
  itemImage: {
    width: 80,
    height: 80,
    backgroundColor: "#f0f0f0",
    marginBottom: 8,
  },
  itemTitle: {
    fontSize: 14,
  },
  itemPrice: {
    fontSize: 12,
    color: "gray",
  },
});

export default HomeScreen;
