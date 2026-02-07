import React, { useState } from "react";
import "../CSS/Absence.css"; // Importing the CSS file
import Navbar from "./Navbar";

const Absence = () => {
  // State variables to manage input values
  const [textInput1, setTextInput1] = useState("");
  const [dateInput, setDateInput] = useState("");
  const [intInput, setIntInput] = useState("");
  const [textInput2, setTextInput2] = useState("");

  // Function to handle form submission
  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Text Input 1:", textInput1);
    console.log("Date Input:", dateInput);
    console.log("Integer Input:", intInput);
    console.log("Text Input 2:", textInput2);
  };

  return (
    <div>
      <Navbar/>
    <div className="container">
      <h1>Demande D'absence</h1>
      <form onSubmit={handleSubmit} className="form">
        {/* Text Input 1 */}
        <input
          type="text"
          placeholder="Type D'absence"
          value={textInput1}
          onChange={(e) => setTextInput1(e.target.value)}
          className="input-field"
        />

        {/* Date Input */}
        <input
          type="date"
          value={dateInput}
          onChange={(e) => setDateInput(e.target.value)}
          className="input-field"
        />

        {/* Integer Input */}
        <input
          type="number"
          placeholder="Nombre de Jours"
          value={intInput}
          onChange={(e) => setIntInput(e.target.value)}
          className="input-field"
        />

        {/* Text Input 2 */}
        <input
          type="text"
          placeholder="Remplacant"
          value={textInput2}
          onChange={(e) => setTextInput2(e.target.value)}
          className="input-field"
        />

        {/* Submit Button */}
        <button type="submit" className="submit-button">
          Envoyer
        </button>
      </form>
    </div>
    </div>
  );
};

export default Absence;