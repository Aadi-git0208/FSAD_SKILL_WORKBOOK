import React, { useEffect, useState } from "react";
import { Link } from "react-router-dom";

function UserList() {
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/users")
      .then((res) => res.json())
      .then((data) => {
        setUsers(data);
        setLoading(false);
      })
      .catch(() => {
        setError("Failed to load API users.");
        setLoading(false);
      });
  }, []);

  if (loading) {
    return (
      <main className="app-shell">
        <section className="panel page-frame center-state">Loading API users...</section>
      </main>
    );
  }

  if (error) {
    return (
      <main className="app-shell">
        <section className="panel page-frame center-state">{error}</section>
      </main>
    );
  }

  return (
    <main className="app-shell">
      <section className="panel page-frame">
        <div className="page-header">
          <div>
            <p className="eyebrow">Remote dataset</p>
            <h2>API Users</h2>
          </div>
          <Link to="/" className="back-link">
            Back to dashboard
          </Link>
        </div>

        <div className="list-grid">
          {users.map((user) => (
            <article key={user.id} className="data-card">
              <h3>{user.name}</h3>
              <p>{user.email}</p>
              <span>{user.phone}</span>
            </article>
          ))}
        </div>
      </section>
    </main>
  );
}

export default UserList;