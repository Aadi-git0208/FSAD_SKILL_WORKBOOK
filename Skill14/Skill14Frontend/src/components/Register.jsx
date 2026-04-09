import React, { useState } from "react";
import axios from "axios";

function Register({ navigate }) {
  const [user, setUser] = useState({ username: "", password: "", email: "" });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    await axios.post("http://localhost:8080/register", user);
    alert("Registered!");
    navigate("/login");
  };

  return (
    <div>
      <h2>Register</h2>
      <input name="username" onChange={handleChange} placeholder="Username" />
      <input name="password" onChange={handleChange} placeholder="Password" />
      <input name="email" onChange={handleChange} placeholder="Email" />
      <button onClick={handleSubmit}>Register</button>
    </div>
  );
}

export default Register;