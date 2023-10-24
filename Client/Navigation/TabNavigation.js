import {StyleSheet, Text, View} from 'react-native';
import React from 'react';
import {createBottomTabNavigator} from '@react-navigation/bottom-tabs';

import HomeScreen from '../components/Home/HomeScreen.js';

// import Profile from '../screens/ProfileScreen.js';
// import HomeNavigator from './HomeNavigator.js';
// import RecordNavigator from './RecordNavigator.js';
// import RemindersNavigator from './RemindersNavigator.js';
// import MediShareNavigator from './MediShareNavigator.js';
// import ProfileNavigator from './ProfileNavigator.js';

import MaterialCommunityIcons from 'react-native-vector-icons/MaterialCommunityIcons';

const Tab = createBottomTabNavigator();
const TabNavigation = () => {
  return (
    <Tab.Navigator 
    screenOptions={{ headerShown: false}}
    >
        <Tab.Screen
          name="Home"
          component={HomeScreen}
          options={{
            tabBarIcon: ({focused,color, size}) => (
              <MaterialCommunityIcons name="home" size={40}  color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"} />
            ),
            tabBarLabel: () => null
          }}
        />
        <Tab.Screen
          name="Records"
          component={HomeScreen}
          options={{
            tabBarIcon: ({focused,color, size}) => (
              <MaterialCommunityIcons name="format-list-bulleted" size={40}  color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"} />
            ),
            tabBarLabel: () => null
          }}
        />
        <Tab.Screen
          name="Reminders"
          component={HomeScreen}
          options={{
            tabBarIcon: ({focused,color, size}) => (
              <MaterialCommunityIcons name="bell" size={40}  color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"} />
            ),
            tabBarLabel: () => null
          }}
        />
        <Tab.Screen
          name="MediShareNav"
          component={HomeScreen}
          options={{
            tabBarIcon: ({focused,color, size}) => (
              <MaterialCommunityIcons name="storefront" size={40}  color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"} />
            ),
            tabBarLabel: () => null
          }}
        />
        <Tab.Screen
          name="Profile"
          component={HomeScreen}
          options={{
            tabBarIcon: ({focused, color, size}) => (
              <MaterialCommunityIcons name="account" size={40}  color={focused ? "rgb(13, 145, 48)" : "rgb(35, 222, 85)"}/>
            ),
            tabBarLabel: () => null
          }}
        />
      </Tab.Navigator>
  );
};

export default TabNavigation;

const styles = StyleSheet.create({});

