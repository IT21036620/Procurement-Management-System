import React, { useState } from "react";
import {
  StyleSheet,
  View,
  TextInput,
  FlatList,
  Text,
  Button,
} from "react-native";

const ContentScreen = () => {
  const [searchQuery, setSearchQuery] = useState(""); // State for the search input
  const [data, setData] = useState([]); // Mock data for search results, can be populated from API

  // Sample function to simulate searching within data
  const handleSearch = () => {
    // For this example, let's assume the data is a list of strings
    // You can filter data based on the searchQuery here
    const filteredData = ["Search result", "Search result", "Search result"]; // This would be the result of your filtering
    setData(filteredData);
  };

  return (
    <View style={styles.container}>
      {/* <View style={styles.header}>
        <Button title="Back" onPress={() => {}} />
        <Text style={styles.title}>Content</Text>
        <Button title="Filter" onPress={() => {}} />
      </View> */}
      <TextInput
        style={styles.searchInput}
        placeholder="Search"
        value={searchQuery}
        onChangeText={(text) => setSearchQuery(text)}
        onSubmitEditing={handleSearch}
      />
      <FlatList
        data={data}
        renderItem={({ item }) => <Text style={styles.item}>{item}</Text>}
        keyExtractor={(item, index) => index.toString()}
      />
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    padding: 10,
  },
  header: {
    flexDirection: "row",
    justifyContent: "space-between",
    alignItems: "center",
    marginBottom: 10,
  },
  title: {
    fontSize: 24,
    fontWeight: "bold",
  },
  searchInput: {
    borderColor: "#ccc",
    borderWidth: 1,
    borderRadius: 10,
    padding: 10,
    marginBottom: 10,
  },
  item: {
    borderColor: "#ccc",
    borderWidth: 1,
    borderRadius: 10,
    padding: 10,
    marginBottom: 10,
  },
});

export default ContentScreen;
