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
      <Tab.Navigator screenOptions={{
        headerShown:false,
      }}>
        <Tab.Screen
          name="HomeNav"
          component={HomeScreen}
          options={{
            tabBarIcon: ({color, size}) => (
              <MaterialCommunityIcons name="home" size={size} color={color} />
            ),
          }}
        />
        <Tab.Screen
          name="Records"
          component={HomeScreen}
          options={{
            tabBarIcon: ({color, size}) => (
              <MaterialCommunityIcons name="file-document" size={size} color={color} />
            ),
          }}
        />
        <Tab.Screen
          name="Reminders"
          component={HomeScreen}
          options={{
            tabBarIcon: ({color, size}) => (
              <MaterialCommunityIcons name="calendar" size={size} color={color} />
            ),
          }}
        />
        <Tab.Screen
          name="MediShareNav"
          component={HomeScreen}
          options={{
            tabBarIcon: ({color, size}) => (
              <MaterialCommunityIcons name="account-group" size={size} color={color} />
            ),
          }}
        />
        <Tab.Screen
          name="Profile"
          component={HomeScreen}
          options={{
            tabBarIcon: ({color, size}) => (
              <MaterialCommunityIcons name="account" size={size} color={color} />
            ),
          }}
        />
      </Tab.Navigator>
  );
};

export default TabNavigation;

const styles = StyleSheet.create({});

