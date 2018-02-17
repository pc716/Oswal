import React from 'react';
import { Input } from 'react-native-elements';
import { StyleSheet, Text, View } from 'react-native';

class Main extends React.Component {
  render() {
    return (
        <Input placeholder='button'/>
    );
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#123',
    alignItems: 'center',
    justifyContent: 'center',
  },
});

export default Main;
