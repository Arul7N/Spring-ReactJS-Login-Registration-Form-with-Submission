import React, { useState} from "react"
import { Login } from "./Login"
import axios from "axios";


export const Register = (props) => {

    const [username, setUsername] = useState("");
    const [department, setDepartment] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");


    async function save(e){
        e.preventDefault();
        try{
            await axios.post("http://localhost:8080/add-user", {
                username: username,
                department: department,
                email: email,
                password: password,
            });
            alert("User Registration Successfull...!");
        }
        catch (err){
            alert(err);
        }
    }

    return(
        <div className="body-container">
            <form className="reg-container">
                <h2>Register</h2>
                <label htmlFor="Username">Username</label><br />
                <input type="text" placeholder="Ex. John" id="uname" name="uname"
                
                value={username} onChange={(e) => {setUsername(e.target.value);}}
                /><br />


                <label htmlFor="Department">Department</label><br />
                <input type="text" placeholder="Ex. Mechanical" id="dept" name="dept"
                
                value={department} onChange={(e) => {setDepartment(e.target.value);}}
                /><br />


                <label htmlFor="email">Email</label><br />
                <input type="text" placeholder="@gmail.com" id="email" name="email"
                
                value={email} onChange={(e) => {setEmail(e.target.value);}}
                /><br />


                <label htmlFor="password">Password</label><br />
                <input type="password" placeholder="********" id="pass" name="pass"
                
                value={password} onChange={(e) => {setPassword(e.target.value);}}
                /><br />


                <input type="submit" value="Register" className="reg-btn" onClick={save}/><br />
                </form>
            <button onClick={() => props.onFormSwitch('Login')} className="link-btn">Already have an account!</button>
        </div>  

    )
}