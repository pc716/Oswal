import React from 'react';
import { Input, Button } from 'react-native-elements';
import Icon from 'react-native-vector-icons/FontAwesome';
import {
    StyleSheet,
    ScrollView,
    Text,
    TextInput,
    View,
    
} from 'react-native';


class Login extends React.Component {
  constructor(props) {
    super(props);
    this.state = {email: '',
                  u_error: false,
                  password: '',
                  p_error: false
                  };
  }

  // Handles login click (validates email and password)
  handlePress = () => {
    // Email = empty
    if(this.state.email === '') {
      this.setState({u_error: true});
    }
    // Password = empty
    if(this.state.password === '') {
      this.setState({p_error: true})
    }
  }

  render() {
    return (

      <View>
          <Input
            placeholder='Email'
            displayError={this.state.u_error}
            errorStyle={{ color: 'red' }}
            errorMessage='Please enter a valid email'
            containerStyle={ styles.oval }
            onChangeText={(email) => this.setState({email: email, u_error: false})}
          />
          <Input
            placeholder='Password'
            displayError={this.state.p_error}
            errorStyle={{ color: 'red' }}
            errorMessage='Please enter a password'
            containerStyle={ styles.oval }
            secureTextEntry={true}
            onChangeText={(password) => this.setState({password : password, p_error: false})}
          />

        <Button
            text='Login'
            buttonStyle={ styles.buttonOval }
            onPress={this.handlePress}
        />
        <Button
            text='Create an Account'
            textStyle={{color : "#2089dc"}}
            buttonStyle={ styles.buttonCreate }
            onPress={this.handlePress}
        />
    </View>);
  }
}


const styles = StyleSheet.create({
  buttonCreate: {
    borderColor: "transparent",
    backgroundColor: "white"
  },
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
