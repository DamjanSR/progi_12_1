import NavBar from '../Components/NavBar';
import React, {useContext} from 'react';
import Profile from "./Profile";

import NewMap from "../Components/Map";
import {UserContext} from "../Helper/Context";
import {useNavigate } from 'react-router-dom';

export default function Home()
{
    const navigate=useNavigate();
    const {user} = useContext(UserContext);

    return (
      <>
        <NavBar />


        {user.username!="" ? <h3>Welcome {user.username}</h3> :console.log(user)}
       	<NewMap />
        <div className="home-container">
        <section className="home-map-section">
        </section>


       <section className="main">
         
       </section>
     </div>
     </>
        
  
    );
};