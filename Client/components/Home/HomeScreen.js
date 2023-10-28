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
import { Ionicons } from "@expo/vector-icons";

const DATA = [
  {
    id: "1",
    title: "High-Quality Bricks",
    price: "200.00",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306428/bricks_zfdxnu.jpg",
    description:
      "High-quality red bricks for your construction needs. These bricks are known for their durability and strength, making them ideal for various building projects. They are suitable for both residential and commercial construction.",
  },
  {
    id: "3",
    title: "High-Grade Cement",
    price: "5000.00",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306766/cement_v1mpjz.png",
    description:
      "High-quality cement for strong and durable construction. Our cement is manufactured to meet industry standards and is perfect for building sturdy structures. It ensures long-lasting results and excellent bonding.",
  },
  {
    id: "10",
    title: "Premium Steel Materials",
    price: "1000.00",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307418/Steel_klpqua.jpg",
    description:
      "Premium steel materials for a wide range of construction applications. Our steel products are known for their strength and reliability, making them the ideal choice for structural and building projects.",
  },
];
const DATA2 = [
  {
    id: "2",
    title: "Heavy-Duty Bulldozers",
    price: "2000000.00",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306596/Bulldozer_gmicia.jpg",
    description:
      "Powerful bulldozers for heavy-duty earthmoving tasks. These bulldozers are designed to handle tough terrains and excavation work. They come equipped with advanced features for increased efficiency and productivity.",
  },
  {
    id: "4",
    title: "Heavy-Duty Cranes",
    price: "9000000.00",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306865/Cranes_lv53zw.jpg",
    description:
      "Heavy-duty cranes for lifting and transporting heavy materials and equipment on your construction site. These cranes are designed to meet the demands of large-scale projects and provide precision and safety.",
  },
  {
    id: "6",
    title: "Versatile Excavator",
    price: "5000000.00",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307075/Excavator_ru8lpi.jpg",
    description:
      "A versatile excavator for digging, trenching, and other excavation tasks. This excavator is built for flexibility and precision, making it an essential tool for your construction projects.",
  },
];
const DATA3 = [
  {
    id: "5",
    title: "Electrical Panels and Accessories",
    price: "59.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698306991/Electrical-panel_tehsez.jpg",
    description:
      "A wide range of electrical panels and accessories for your electrical system needs. We offer top-quality panels, switches, outlets, and electrical components to ensure a safe and reliable electrical setup.",
  },
  {
    id: "11",
    title: "Switches and Outlets",
    price: "119.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307496/Switches-and-outlets_rrnoos.png",
    description:
      "High-quality switches and outlets for your electrical needs. These components are designed for safety, efficiency, and compatibility with various electrical systems.",
  },
  {
    id: "14",
    title: "Wiring and Cables",
    price: "149.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307830/wiring-and-cables_s1swpb.jpg",
    description:
      "High-quality wiring and cables for your electrical installations. These cables are known for their reliability and safety, ensuring a secure electrical connection.",
  },
];
const DATA4 = [
  {
    id: "8",
    title: "Durable Pipes and Fittings",
    price: "89.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307245/Pipes_l6ymdj.png",
    description:
      "Durable pipes and fittings for your plumbing needs. Our high-quality plumbing supplies ensure leak-free connections and long-term performance in plumbing systems.",
  },
  {
    id: "9",
    title: "Safety Goggles",
    price: "99.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307353/Safety-goggles_mtu0ho.jpg",
    description:
      "Safety goggles designed to protect your eyes from dust, debris, and other hazards on the construction site. These goggles provide clear vision and comfort during work.",
  },
  {
    id: "12",
    title: "Modern Toilets",
    price: "129.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307679/toilet_jos3du.jpg",
    description:
      "Modern toilets with innovative features and water-saving capabilities. These toilets are designed for comfort and functionality, making them a great addition to any restroom.",
  },
  {
    id: "13",
    title: "Efficient Water Heaters",
    price: "139.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307747/Water-heater_fo7k8k.jpg",
    description:
      "Efficient water heaters for reliable hot water supply in your building. Our water heaters are energy-efficient and designed for consistent performance.",
  },
];
const DATA5 = [
  {
    id: "7",
    title: "Safety Hard Hats",
    price: "79.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307157/Hard-hats_gc3s6d.jpg",
    description:
      "Safety hard hats designed to protect construction workers from head injuries on the job. These hard hats meet safety standards and come with adjustable straps for a comfortable fit.",
  },
  {
    id: "9",
    title: "Safety Goggles",
    price: "99.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307353/Safety-goggles_mtu0ho.jpg",
    description:
      "Safety goggles designed to protect your eyes from dust, debris, and other hazards on the construction site. These goggles provide clear vision and comfort during work.",
  },
  {
    id: "10",
    title: "Premium Steel Materials",
    price: "109.99",
    image:
      "https://res.cloudinary.com/dbcmklrpv/image/upload/v1698307418/Steel_klpqua.jpg",
    description:
      "Premium steel materials for a wide range of construction applications. Our steel products are known for their strength and reliability, making them the ideal choice for structural and building projects.",
  },
];

const HomeScreen = ({ navigation }) => {
  const renderItem = ({ item }) => (
    <TouchableOpacity
      onPress={() => navigation.navigate("ItemDetails", { item })}
    >
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
        <Text style={styles.sectionTitle}>Electrical Supplies</Text>
        <FlatList
          data={DATA3}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
          horizontal={true}
        />
        <Text style={styles.sectionTitle}>Construction Equipment</Text>
        <FlatList
          data={DATA2}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
          horizontal={true}
        />

        <Text style={styles.sectionTitle}>Plumbing Supplies</Text>
        <FlatList
          data={DATA4}
          renderItem={renderItem}
          keyExtractor={(item) => item.id}
          horizontal={true}
        />
        <Text style={styles.sectionTitle}>Safety Equipment</Text>
        <FlatList
          data={DATA5}
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
