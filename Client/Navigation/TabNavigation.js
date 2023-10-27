import { StyleSheet, Text, View } from "react-native";
import React from "react";
import { createBottomTabNavigator } from "@react-navigation/bottom-tabs";

import HomeNavigator from "./HomeNavigator.js";
import OrderListNavigator from "./OrderListNavigator.js";
import CartNavigator from "./CartNavigator.js";

import HomeScreen from "../components/Home/HomeScreen.js";
import ContentScreen from "../components/Shop/ContentScreen.js";
import ProfileScreen from "../components/Profile/ProfileScreen.js";
import LoginScreen from "../components/Login/LoginScreen.js";
import CartScreen from "../components/Cart/CartScreen.js";
import OrderListScreen from "../components/Orders/OrderList.js";

import MaterialCommunityIcons from "react-native-vector-icons/MaterialCommunityIcons";

const Tab = createBottomTabNavigator();
const TabNavigation = () => {
  return (
    <Tab.Navigator
      screenOptions={{
        headerTitleAlign: "center",
      }}
    >
      <Tab.Screen
        name="PMS Home"
        component={HomeNavigator}
        options={{
          tabBarIcon: ({ focused, color, size }) => (
            <MaterialCommunityIcons
              name="home"
              size={40}
              color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"}
            />
          ),
          tabBarLabel: () => null,
        }}
      />
      <Tab.Screen
        name="Orders"
        component={OrderListNavigator}
        options={{
          tabBarIcon: ({ focused, color, size }) => (
            <MaterialCommunityIcons
              name="format-list-bulleted"
              size={40}
              color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"}
            />
          ),
          tabBarLabel: () => null,
        }}
      />
      <Tab.Screen
        name="Notificatons"
        component={HomeScreen}
        options={{
          tabBarIcon: ({ focused, color, size }) => (
            <MaterialCommunityIcons
              name="bell"
              size={40}
              color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"}
            />
          ),
          tabBarLabel: () => null,
        }}
      />
      <Tab.Screen
        name="Cart"
        component={CartNavigator}
        options={{
          tabBarIcon: ({ focused, color, size }) => (
            <MaterialCommunityIcons
              name="storefront"
              size={40}
              color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"}
            />
          ),
          tabBarLabel: () => null,
        }}
      />
      <Tab.Screen
        name="Profile"
        component={ProfileScreen}
        options={{
          tabBarIcon: ({ focused, color, size }) => (
            <MaterialCommunityIcons
              name="account"
              size={40}
              color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"}
            />
          ),
          tabBarLabel: () => null,
        }}
      />
    </Tab.Navigator>
  );
};

export default TabNavigation;

const styles = StyleSheet.create({});
