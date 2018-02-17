import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import Login from './user/components/login.js';

export default class App extends React.Component {
  render() {
    return (
      <View style={styles.container}>
        <Login/>
      </View>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
