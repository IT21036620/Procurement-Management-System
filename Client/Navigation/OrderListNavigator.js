import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import OrderDetailsScreen from '../components/Orders/OrderDetailsScreen';
import OrderListScreen from '../components/Orders/OrderList';

const Stack = createNativeStackNavigator();

function OrderListNavigator() {
  return (
      <Stack.Navigator screenOptions={{ headerShown:false,}} >
        <Stack.Screen name="OrderListScreen" component={OrderListScreen} />
        <Stack.Screen name="OrderDetailsScreen" component={OrderDetailsScreen} />
      </Stack.Navigator>
  );
}

export default OrderListNavigator;
