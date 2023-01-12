import React, {useState} from 'react';
import {UserContext} from './Context';



  export const UserProvider = ({ children} : any) => {
    
    const [user, setUser] = useState({
        username: '',
        auth: true 
        });
  
    // Login updates the user data with a name parameter
    const login = (name : string) => {
      setUser((user) => ({
        username: name,
        auth: true,
      }));
    };
  
    // Logout updates the user data to default
    const logout = () => {
      setUser((user) => ({
        username: '',
        auth: false,
      }));
    };
  
    return (
      <UserContext.Provider value={{user, login, logout}} >
        {children}
      </UserContext.Provider>
    );
  }
