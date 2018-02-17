import React from 'react';
import { Input, Button } from 'react-native-elements';
import Icon from 'react-native-vector-icons/FontAwesome';
import {
    StyleSheet,
    ScrollView,
    Text,
    TextInput,
    View
} from 'react-native';

class Login extends React.Component {
  render() {
    return (
      <View>
      <Input
        placeholder='Username'
        displayError={false}
        errorStyle={{ color: 'red' }}
        errorMessage='ENTER A VALID ERROR HERE'
        containerStyle={ styles.oval }
      />
      <Input
        placeholder='Password'
        displayError={false}
        errorStyle={{ color: 'red' }}
        errorMessage='ENTER A VALID ERROR HERE'
        containerStyle={ styles.oval }
      />
    <Button
      text='Login'
      buttonStyle={ styles.buttonOval }
    />
    </View>
        );
  }
}


const styles = StyleSheet.create({
  buttonOval: {
    borderRadius: 25,
    borderWidth: 1,
    borderColor: '#d6d7da',
    width: 300,
    height: 50,
    margin: 7
  },
  oval: {
    borderRadius: 25,
    borderWidth: 1,
    borderColor: '#d6d7da',
    width: 300,
    height: 50,
    margin: 7
  },
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  }
});

export default Login;
