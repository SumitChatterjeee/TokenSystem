import { useState } from "react";

export default function TokenForm() {
  const [name, setName] = useState("");
  const [error, setError] = useState("");

  const handleSubmit = (e) => {
  e.preventDefault();

  const trimmedName = name.trim();

  if (!trimmedName) {
    setError("Name is required");
    return;
  }

  if (trimmedName.length < 2) {
    setError("Name must be at least 2 characters");
    return;
  }

  setError("");

  console.log("Name:", trimmedName);

  // Clear the input
  setName("");
};

  const handleNameChange = (e) => {
    setName(e.target.value);

    // Remove error as soon as the user starts correcting the input
    if (error) {
      setError("");
    }
  };

  return (
    <div className="token-page">
      <form className="token-form" onSubmit={handleSubmit}>
        <h1 className="token-title">Get Your Token</h1>

        <input
          type="text"
          placeholder="Enter your name"
          value={name}
          onChange={handleNameChange}
          className="name-input"
        />

        {error && <p className="error">{error}</p>}

        <button type="submit" className="token-btn">Get Token</button>
      </form>
    </div>
  );
}