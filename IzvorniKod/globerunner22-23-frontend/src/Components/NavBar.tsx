import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import React, {useContext} from "react";
import { UserContext } from "../Helper/Context";

export default function NavBar()
{
    const {user, logout} = useContext(UserContext);
    //maknut logout, login, uredenje

    return(

    <nav className="navbar-parent">
        <div id="navbarNav" className="navbar">

            <div className="navbar-items">
                <Link to="/" onClick={logout}>Logout</Link>
            </div>



        </div>
    </nav>
    );
}