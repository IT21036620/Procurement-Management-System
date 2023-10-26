import React from 'react';
import { View, Text, Image, StyleSheet } from 'react-native';

const ProfileScreen = () => {
    // Sample data for the profile
    const profile = {
        name: "John Doe",
        email: "john@example.com",
        phoneNumber: "+1234567890",
        image: "https://via.placeholder.com/150",  // Replace with the actual profile image URL
    };

    return (
        <View style={styles.container}>
            <Image source={{ uri: profile.image }} style={styles.profileImage} />
            <Text style={styles.profileName}>{profile.name}</Text>
            <Text style={styles.profileDetail}>Email: {profile.email}</Text>
            <Text style={styles.profileDetail}>Phone: {profile.phoneNumber}</Text>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        padding: 20,
        backgroundColor: '#f5f5f5',
        alignItems: 'center',
    },
    profileImage: {
        width: 150,
        height: 150,
        borderRadius: 75, // Half of width and height for a circle
        marginBottom: 20,
        borderColor: '#ccc',
        borderWidth: 2,
    },
    profileName: {
        fontSize: 24,
        fontWeight: 'bold',
        marginBottom: 10,
    },
    profileDetail: {
        fontSize: 18,
        marginVertical: 5,
    },
});

export default ProfileScreen;
