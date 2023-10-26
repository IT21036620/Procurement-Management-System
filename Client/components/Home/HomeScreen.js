import React from "react";
import {
  StyleSheet,
  Text,
  View,
  TouchableOpacity,
  FlatList,
  TextInput,
  ScrollView,
  Image,
} from "react-native";
import { Ionicons } from "@expo/vector-icons"; // Assuming you're using Expo. If not, adjust accordingly.

const DATA = [
  {
    id: "1",
    title: "Bricks",
    price: "$19.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306428/bricks_zfdxnu.jpg",
  },
  {
    id: "2",
    title: "Bulldozers",
    price: "$29.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306596/Bulldozer_gmicia.jpg",
  },
  {
    id: "3",
    title: "Cement",
    price: "$39.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306766/cement_v1mpjz.png",
  },
  {
    id: "4",
    title: "Cranes",
    price: "$49.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306865/Cranes_lv53zw.jpg",
  },
  {
    id: "5",
    title: "Electrical panels",
    price: "$59.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306991/Electrical-panel_tehsez.jpg",
  },
  {
    id: "6",
    title: "Excavator",
    price: "$69.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307075/Excavator_ru8lpi.jpg",
  },
  {
    id: "7",
    title: "Hard hats",
    price: "$79.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307157/Hard-hats_gc3s6d.jpg",
  },
  {
    id: "8",
    title: "Pipes",
    price: "$89.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307245/Pipes_l6ymdj.png",
  },
  {
    id: "9",
    title: "Safety goggles",
    price: "$99.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307353/Safety-goggles_mtu0ho.jpg",
  },
  {
    id: "10",
    title: "Steel",
    price: "$109.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307418/Steel_klpqua.jpg",
  },
  {
    id: "11",
    title: "Switches and outlets",
    price: "$119.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307496/Switches-and-outlets_rrnoos.png",
  },
  {
    id: "12",
    title: "Toilets",
    price: "$129.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307679/toilet_jos3du.jpg",
  },
  {
    id: "13",
    title: "Water heaters",
    price: "$139.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307747/Water-heater_fo7k8k.jpg",
  },
  {
    id: "14",
    title: "Wiring and cables",
    price: "$149.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307830/wiring-and-cables_s1swpb.jpg",
  },
];

const HomeScreen = ({ navigation }) => {
  const renderItem = ({ item }) => (
    <TouchableOpacity onPress={() => navigation.navigate('ItemDetails', { item })}>
    <View style={styles.itemContainer}>
      <Image source={{ uri: item.image }} style={styles.itemImage} />
      <Text style={styles.itemTitle}>{item.title}</Text>
      <Text style={styles.itemPrice}>{item.price}</Text>
    </View>
    </TouchableOpacity>
  );

  return (
    <ScrollView style={styles.container}>
      <View style={styles.container}>
        <TextInput style={styles.searchBar} placeholder="Search" />
        <Text style={styles.sectionTitle}>Building Materials</Text>
        <FlatList
          data={DATA}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
          horizontal={true}
        />
        <Text style={styles.sectionTitle}>Construction Equipment</Text>
        <FlatList
          data={DATA}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
          horizontal={true}
        />
        <Text style={styles.sectionTitle}>Electrical Supplies</Text>
        <FlatList
          data={DATA}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
          horizontal={true}
        />
        <Text style={styles.sectionTitle}>Plumbing Supplies</Text>
        <FlatList
          data={DATA}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
          horizontal={true}
        />
        <Text style={styles.sectionTitle}>Safety Equipment</Text>
        <FlatList
          data={DATA}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
          horizontal={true}
        />
        {/* Add more sections as needed */}
      </View>
    </ScrollView>
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
