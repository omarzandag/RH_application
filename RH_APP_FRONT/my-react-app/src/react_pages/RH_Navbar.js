import React from "react";
import '../CSS/navbar.css'


function RHNavbar(){
    return(
<nav className="navbar">
          <ul>
             <li>
              <a href="/ajoute">Fonctionnaires</a>
            </li>
            <li>
              <a href="#">Demandes D'absences</a>
            </li>
            <li>
              <a href="#">Formations</a>
            </li>
            <li>
              <a href="#">Affectations</a>
            </li>
            <li>
              <a href="#">Mouvements</a>
            </li>
            <li>
              <a href="/login">Déconnexion</a>
            </li>
          </ul>
        </nav>
    );

}
export default RHNavbar;