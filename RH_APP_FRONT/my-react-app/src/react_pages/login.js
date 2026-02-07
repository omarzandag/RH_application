import React from 'react';
import '../CSS/login.css'; // Import CSS for styling

function Login() {
  return (
    <div className="App">
      {/* Centered Box */}
      <div className="login-box">
        {/* Title */}
        <h2>CONNEXION</h2>

        {/* Email Input */}
        <div className="input-container">
          <input type="text" placeholder="CIN" />
        </div>

        {/* Password Input */}
        <div className="input-container">
          <input type="password" placeholder="Mot de passe" />
        </div>

        {/* Login Button */}
        <button className="login-button">CONNEXION</button>

      </div>
    </div>
  );
}

export default Login;