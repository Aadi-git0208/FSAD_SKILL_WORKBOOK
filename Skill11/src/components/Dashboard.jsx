import React from "react";
import { Link } from "react-router-dom";

function Dashboard() {
  const tiles = [
    {
      to: "/local",
      title: "Local Users",
      description: "Load users from the local JSON file and view the cached dataset.",
    },
    {
      to: "/users",
      title: "Users API",
      description: "Fetch live user data from JSONPlaceholder with a clean layout.",
    },
    {
      to: "/posts",
      title: "Fake API Posts",
      description: "Browse dummy JSON posts, refresh data, and filter by user.",
    },
  ];

  return (
    <main className="app-shell">
      <section className="panel hero-panel page-frame">
        <p className="eyebrow">Skill 11 dashboard</p>
        <h1>Dashboard</h1>
        <p className="hero-copy">
          Explore local data, public API data, and fake posts from one polished landing page.
        </p>

        <div className="dashboard-grid">
          {tiles.map((tile) => (
            <Link key={tile.to} to={tile.to} className="nav-card">
              <span className="nav-card__title">{tile.title}</span>
              <span className="nav-card__description">{tile.description}</span>
              <span className="nav-card__action">Open view</span>
            </Link>
          ))}
        </div>
      </section>
    </main>
  );
}

export default Dashboard;