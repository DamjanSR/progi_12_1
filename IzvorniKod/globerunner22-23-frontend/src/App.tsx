import React , {useState} from 'react';

import './App.css';
import './Components/NavBar';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Register from './Pages/Register';
import Login from './Pages/Login'
import Home from './Pages/Home'
import { UserProvider } from "./Helper/UserProvider";
import RegisterK from './Pages/RegisterK';

function App() {

  return (
    <div className='App-container'>
        <UserProvider>
        <BrowserRouter>
         <div className="App">
            <Routes>
              <Route path="/" element={<Login/>}></Route>
              <Route path="/Login" element={<Login/>}></Route>
              <Route path="/Home" element={<Home/>}></Route>
              <Route path="/Register" element={<Register/>}></Route>
              <Route path="/RegisterK" element={<RegisterK/>}></Route>
            </Routes>
          </div>
          </BrowserRouter>
          </UserProvider>
        </div>
  );
}

export default App;
