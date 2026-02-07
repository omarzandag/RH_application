import React from "react";
import "../CSS/navbar.css"

function Navbar(){
    return (
        <nav className="navbar">
          <ul>
            <li>
              <a href="/infosadministratives">Informations Administratives</a>
            </li>
            <li>
              <a href="/absence">Absence</a>
            </li>
            <li>
              <a href="/formations">Formations</a>
            </li>
            <li>
              <a href="/infospersonelles">Informations Personnelles</a>
            </li>
            <li>
              <a href="/login">Déconnexion</a>
            </li>
          </ul>
        </nav>
      );
}
export default Navbar;