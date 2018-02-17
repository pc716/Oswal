import React from 'react';
import { StyleSheet, Text, View } from 'react-native';
import { NativeRouter, Link, Route } from 'react-router-native';
import Login from './user/components/login.js';
/*
*            <Route path="/about" component={About}/>
            <Route path="/topics" component={Topics}/>
*/
export default class App extends React.Component {
  render() {
    return (
        <NativeRouter>
          <View style={styles.container}>
            <View style={styles.nav}>
              <Link
                to="/login"
                underlayColor='#f0f4f7'
                style={styles.navItem}>
                  <Login/>
              </Link>
            </View>

            <Route exact path="/login" component={Login}/>

          </View>
        </NativeRouter>
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
