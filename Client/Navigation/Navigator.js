import React from 'react'
import TabNavigation from './TabNavigation'
import {NavigationContainer} from '@react-navigation/native';

export const Navigator = () => {
  return (
    <NavigationContainer>
    <TabNavigation/>
    </NavigationContainer>
  )
}