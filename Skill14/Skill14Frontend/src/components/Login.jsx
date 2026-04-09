import React, { useState } from "react";
import axios from "axios";

function Login({ navigate }) {
  const [user, setUser] = useState({ username: "", password: "" });

  const handleChange = (e) => {
    setUser({ ...user, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    const res = await axios.post("http://localhost:8080/login", user);

    if (res.data) {
      localStorage.setItem("userId", res.data.id);
      navigate("/");
    } else {
      alert("Invalid credentials");
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <input name="username" onChange={handleChange} placeholder="Username" />
      <input name="password" onChange={handleChange} placeholder="Password" />
      <button onClick={handleSubmit}>Login</button>
    </div>
  );
}

export default Login;