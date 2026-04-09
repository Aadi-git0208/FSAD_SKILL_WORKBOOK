import React from "react";

<button onClick={() => {
  localStorage.removeItem("userId");
  window.location.href = "/login";
}}>
  Logout
</button>
function Home() {
  return <h2>Welcome to Home Page</h2>;
  
}

export default Home;