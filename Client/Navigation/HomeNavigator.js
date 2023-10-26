import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Home from '../components/mediShare/Home';
import CreateRequest from '../components/mediShare/CreateRequest.js'
import MyRequests from '../components/mediShare/MyRequests'

const Stack = createNativeStackNavigator();

function HomeNavigator() {
  return (
      <Stack.Navigator >
        <Stack.Screen name="Home" component={Home} />
        <Stack.Screen name="CreateRequest" component={CreateRequest} />
        <Stack.Screen name="MyRequests" component={MyRequests} />
      </Stack.Navigator>
  );
}

export default HomeNavigator;
