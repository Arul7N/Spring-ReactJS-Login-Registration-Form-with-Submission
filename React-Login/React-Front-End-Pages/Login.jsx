import React, { useState } from "react"
import { Register } from "./Register"
import axios from "axios";

import {Router, Route, Routes, useNavigate, BrowserRouter} from 'react-router-dom';



export const Login = (props) => {

    const [email, setEmail] = useState('');
    const [password, setPassword] = useState("");




    async function login(e){
        e.preventDefault();
        
        try {
            await axios.post("http://localhost:8080/login-user",
            {
                email : email,
                password : password,
            }).then((res) => {
                console.log(res.data);
                if(res.data.message == "Invalid Email...!"){
                    alert("Invalid Email...!");
                }
                else if(res.data.message == "Login Successfull...!"){
                   alert("Login Successfull...!");
                }
                else {
                    alert("Incorrect Email and Password not match");
                }   
            }, fail => {
                console.error(fail);
            });
        }
        catch(err) {
            alert(err);
        }
    }

    return(
        <div className="body-container">
        <form className="log-container">
            <h2>Login</h2>


            <label htmlFor="email">Email</label><br />
            <input type="text" placeholder="@gmail.com" className="email" id="email" name="email"
            
            value={email} onChange={(e) => {
                setEmail (e.target.value);
            }}
            /><br />
            <label htmlFor="password">Password</label><br />
            <input type="password" placeholder="********" id="pass" name="pass"
            
            value={password} onChange={(e) => {
                setPassword (e.target.value);
            }}
            /><br />
            <input type="submit" className="log-btn" value="Submit" onClick={login}/><br />
        </form>


        <button onClick={() => props.onFormSwitch('Register')}  className="link-btn">Don't have an account? Register here!</button>
        </div>
    )
}