import React from "react";
import { Login }  from './Login.jsx';
import { Register } from './Register.jsx';
import './App.css';
import { useState } from 'react';
import { BrowserRouter as Routes,Route, Router, Link, BrowserRouter } from "react-router-dom";


function App() {

  const [currentForm, setCurrrentForm] = useState('login');

  const toggleForm = (forName) => {
    setCurrrentForm(forName);
  }

  
  return (
    <div className="App">
     
     {
       currentForm === "Login" ? <Login onFormSwitch = {toggleForm} /> : <Register onFormSwitch = {toggleForm} />
     }
     
     
    
        {/* <Router>
          <Link to='/register'>Don't have an account? Register here!</Link>
          <Link to='/login' >Already have an account!</Link>
          <Routes>
            <Route path="/login" element={<Login />} />
            <Route path="/register" element={<Register />} />
          </Routes>
        </Router> */}
      
        {/* <Routes>
          <Route path="/home" element = {<Home />} />
          <Route path="/register" element = {<Register />} />
          <Route path="/login" element = {<Login />} />
        </Routes> */}
      
    </div>

    
  );
}

export default App;
