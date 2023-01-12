import {Link, useNavigate} from "react-router-dom";
import React, {useState, useEffect} from "react";
import axios from "axios";
import "./RegisterCartographer.css";
import image1 from "../Images/globeLogin.jpg";


const API_URL = `https://globerunner9.onrender.com/api/v1/addNewCartographer`;


export default function RegisterK(props :any)
{

    const [submitDisabled, setSubmitDisabled] = useState(true);
    const[terms, setTerms] = useState(false);
    const [data, setData] = useState(
    {
        username:"Ivooo", 
        email:"sanader@gmail.com", 
        password:"123456789", 
        confirmPassword:"123456789",
        iban : "HR32200042688"

    })
    const [file, setFile] = useState(null);
    const [fileDataURL, setFileDataURL] = useState(null);
    const [file1, setFile1] = useState(null);
    const [fileDataURL1, setFileDataURL1] = useState(null);
    const navigate = useNavigate();


//---------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------//


const handleCheckButton = ()=>
{
    setTerms(!terms);
}
const handleChange=(e : any)=>
{
    setData({...data, [e.target.name] : e.target.value});
}

const changeImageHandler= (e : any)=>
{

    if( e.target.files[0] !==undefined && e.target.files[0] !==null)
    {
        
        const image = e.target.files[0];
        if(image.type !== "image/jpeg" && image.type !==  "image/jpg" && image.type !==  "image/png")
        {
            alert("Image type is not valid");
            return;
        }
        else{
            setFile(image);
            dataCheck();
            console.log("Podaci o slici : " + image);
        }
    }
}

const changeImageHandler1= (e : any)=>
{

    if( e.target.files[0] !==undefined && e.target.files[0] !==null)
    {
        
        const image = e.target.files[0];
        if(image.type !== "image/jpeg" && image.type !==  "image/jpg" && image.type !==  "image/png")
        {
            alert("Image type is not valid");
            return;
        }
        else{
            setFile1(image);
            dataCheck();
            console.log("Podaci o slici : " + image);
        }
    }
}


const dataCheck=()=>
{
    if(data.email.length >= 3 &&
        data.password.length >= 3 &&
        data.username.length>=2  &&
        data.password === data.confirmPassword &&
        terms === true
        )
     {
         setSubmitDisabled(false);
     }
     else
     {
         setSubmitDisabled(true);
     }
}


const registerSubmited = (e : any)=>
{
    e.preventDefault();
    const sendData ={
        username : data.username,
        email : data.email,
        password : data.password,
        iban: data.iban,
        photo : fileDataURL,
        idPhoto : fileDataURL1
    } ;
    console.log(file);

    axios.post(API_URL, sendData)
      .then( res =>
        {   
            if(res.status == 200) {
                console.log("Ispis> " + res + " ==>" + res.data);
                navigate("/");
            } else alert("Ime ili email vec koristen");
        }
        ).catch( error => {
          console.log("Error captured", error);
          alert("Ime ili username vec koristen.");
        });

}


//---------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------//
//---------------------------------------------------------------------------------------------------------------------------------------------------------------//



useEffect(() => 
{

    let fileReader : FileReader, isCancel = false;

    console.log(terms);

    if (file) 
    {
        dataCheck();
        fileReader = new FileReader();
        fileReader.onload = (e) => 
        {
            const {result} : React.SetStateAction<any> = e.target;
            if (result && !isCancel) 
            {
                setFileDataURL(result);
            }
        }
        fileReader.readAsDataURL(file);     
    }

    return () => 
    {
        isCancel = true;
        if (fileReader && fileReader.readyState === 1) 
        {
            fileReader.abort();
        }
    }
}, [data, file, terms]);

useEffect(() => 
{

    let fileReader : FileReader, isCancel = false;


    if (file1) 
    {
        fileReader = new FileReader();
        fileReader.onload = (e) => 
        {
            const {result} : React.SetStateAction<any> = e.target;
            if (result && !isCancel) 
            {
                setFileDataURL1(result);
            }
        }
        fileReader.readAsDataURL(file1);     
    }

    return () => 
    {
        isCancel = true;
        if (fileReader && fileReader.readyState === 1) 
        {
            fileReader.abort();
        }
    }
}, [file1]);




    return (
        <div style={{height: "100vh", width: "10wh", margin: "auto", backgroundImage:`url(${image1})`}}>
            <form onSubmit={registerSubmited} className="register-form" >
            <span className="form-title" style={{paddingLeft: "120px"}}>Register</span>
            <div className= "input-data-countainer">


                <div className='formRow'>
                    <label className='' htmlFor="Username" style={{padding: "20px", color: "white"}}>Korisničko ime: </label>
                    <input onChange={handleChange} value={data.username} className= "input-data" type="text" name="username" placeholder="Username"/>
                </div>


                <div className='formRow'>
                    <label className='' htmlFor="Email" style={{padding: "52px", color: "white"}}>Email: </label>
                    <input onChange={handleChange} value={data.email} className= "input-data" type="email" name ="email" placeholder="Email"/>
                </div>


                <div className='formRow'>
                    <label className='' htmlFor="Password" style={{padding: "45px", color: "white"}}>Lozinka: </label>
                    <input onChange={handleChange} value={data.password}   className= "input-data" type="password" name="password" placeholder="Password"/>
                </div>


                <div className='formRow'>
                    <label className='' htmlFor="PasswordCheck" style={{padding: "16px", color: "white"}}>Ponovite lozinku: </label>
                    <input onChange={handleChange} value={data.confirmPassword} className= "input-data" type="password" name="confirmPassword" placeholder="Confirm password"/>    
                </div>


                <div className="input-image">
                    <input   type="file"  accept=' .png, .jpg, .jpeg' name ="file" onChange={changeImageHandler} />
                    {fileDataURL ? <span><img src={fileDataURL} alt="preview"  height={180}/></span>:null }
                </div>


                <div className='formRow'>
                    <label className='' htmlFor="Username" style={{padding: "55px", color: "white"}}>IBAN: </label>
                    <input onChange={handleChange} value={data.iban} className= "input-data" type="text" name="iban" placeholder="IBAN"/>
                </div>

                <div className="input-image">
                    <input   type="file"  accept=' .png, .jpg, .jpeg' name ="file1" onChange={changeImageHandler1} />
                    {fileDataURL1 ? <span><img src={fileDataURL1} alt="preview"  height={180}/></span>:null }
                </div>

                <div className='formRow'>
                    <label htmlFor="terms" style={{color: "white"}}> Pročitao/la sam i prihvaćam uvjete korištenja  </label>
                    <input type="checkbox" id="terms" name="terms" required checked={terms} onChange={handleCheckButton}/>
                </div>


                <div style={{marginTop: "10px"}}>
                        <div className="button_base b03_skewed_slide_in">
                            <div>Submit</div>
                            <div></div>
                            <div>Submit</div>
                        </div>
                </div>


                <div>
                    <p className="registerText" style={{paddingTop: "10px"}}>Already have an account? <Link to="/Login" style={{color: "red"}}>Login!</Link></p>
                    <p className="registerText">Want to register as a Player? <Link to="/Register" style={{color: "red"}}>Click here!</Link></p>
                </div>

            </div>
            </form>
            </div>
    );
};