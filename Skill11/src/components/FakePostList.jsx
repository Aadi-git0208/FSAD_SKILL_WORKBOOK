import React, { useEffect, useState } from "react";
import axios from "axios";
import { Link } from "react-router-dom";

function FakePostList() {
  const [posts, setPosts] = useState([]);
  const [filtered, setFiltered] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  const fetchData = async () => {
    try {
      setLoading(true);
      setError("");
      const res = await axios.get("https://dummyjson.com/posts");
      setPosts(res.data.posts);
      setFiltered(res.data.posts);
    } catch {
      setError("Failed to load posts.");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  const filterData = (userId) => {
    if (userId === "all") {
      setFiltered(posts);
    } else {
      setFiltered(posts.filter((p) => p.userId == userId));
    }
  };

  const userOptions = [...new Set(posts.map((post) => post.userId))].sort((a, b) => a - b);

  if (loading) {
    return (
      <main className="app-shell">
        <section className="panel page-frame center-state">Loading fake posts...</section>
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
            <p className="eyebrow">Fake API</p>
            <h2>Fake Posts</h2>
          </div>
          <Link to="/" className="back-link">
            Back to dashboard
          </Link>
        </div>

        <div className="toolbar">
          <button onClick={fetchData}>Refresh</button>

          <select defaultValue="all" onChange={(e) => filterData(e.target.value)}>
            <option value="all">All users</option>
            {userOptions.map((userId) => (
              <option key={userId} value={userId}>
                User {userId}
              </option>
            ))}
          </select>
        </div>

        <div className="list-grid posts-grid">
          {filtered.map((post) => (
            <article key={post.id} className="data-card post-card">
              <span className="post-badge">User {post.userId}</span>
              <h3>{post.title}</h3>
              <p>{post.body}</p>
            </article>
          ))}
        </div>
      </section>
    </main>
  );
}

export default FakePostList;