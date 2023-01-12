import {useNavigate, Link} from "react-router-dom";
import React, {useState, useContext} from "react";
import axios from "axios";
import {UserContext} from "../Helper/Context";
import "./login.css";
import image1 from "../Images/globeLogin.jpg";



export default function Login()
{
    const navigate = useNavigate();

    const {login} = useContext(UserContext);
    const [data, setData] = useState(
        {
            username:"Jadranka",
            password: "123456789"
        });


    const handleChange = (e:any)=>
    {
        setData({...data, [e.target.name] : e.target.value} )
    }  
    const handleDoReg = (e:any) => {
        navigate("/Register");
    }

    const handleBack = (e:any)=>
    {
        e.preventDefault();
        navigate("/");
    }
    const handleSubmit = (e:any)=>
    {

        e.preventDefault();
        console.log("Submited");

        const userData = {
            username: data.username,
            password: data.password
        }

        axios.post(`https://globerunner9.onrender.com/api/v1/allUsers`, userData)
        .then(
        res => {
            if(res.status == 200)
            { 
                login(userData.username)
                console.log("Ispis> " + res + " ==>" + res.data);
                navigate("/Home");
            }
            else alert("Greška, pogrešan username ili password");

        }).catch( error => {
          console.log("Error captured", error);
          alert("Greška u konekciji s bazom");
             });

    }
    return (
        <div style={{height: "100vh", width: "10wh", margin: "auto", backgroundImage:`url(${image1})` }}>
        <div>
                <form className="login-form-container" onSubmit={handleSubmit}>
                    <div className="avatar">
                        <div className="user-icon"><span></span>
                        </div>
                    </div>
                    <span className="form-title">Login</span>
                    <div className="input-data-countainer">
                        <input className="input-data" type="name" onChange={(e) => handleChange(e)} name="username" value={data.username} placeholder="Upiši username" />
                    </div>
                    <div>
                        <input className="input-data" type="password" onChange={(e) => handleChange(e)} name="password" value={data.password} placeholder="Upiši password" />
                    </div>
                    <div>

                    </div>
                    <div>
                        <div className="button_base b03_skewed_slide_in">
                            <div>Submit</div>
                            <div></div>
                            <div>Submit</div>
                        </div>
                    </div>
                    <div>
                        <span className="registerText">Don't have an account? </span> <br />
                        <Link className="registerText" to="/Register"> Register as Player! </Link> <br />
                        <Link className="registerText" to="/RegisterK"> Register as Cartographer! </Link>
                    </div>
                </form>


            </div>
            </div>
        
    );
};