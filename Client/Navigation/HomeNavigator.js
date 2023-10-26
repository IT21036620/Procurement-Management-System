import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Home from '../components/Home/HomeScreen';
import ItemDetails from '../components/Items/ItemDetails';

const Stack = createNativeStackNavigator();

function HomeNavigator() {
  return (
      <Stack.Navigator screenOptions={{ headerShown:false,}} >
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="ItemDetails" component={ItemDetails} />
      </Stack.Navigator>
  );
}

export default HomeNavigator;
