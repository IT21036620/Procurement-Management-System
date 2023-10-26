import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import CartScreen from '../components/Cart/CartScreen';

const Stack = createNativeStackNavigator();

function CartNavigator() {
  return (
      <Stack.Navigator screenOptions={{ headerShown:false,}} >
        <Stack.Screen name="CartScreen" component={CartScreen} />
      </Stack.Navigator>
  );
}

export default CartNavigator;
