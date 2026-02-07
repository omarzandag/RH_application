import React, { useState } from "react";
import "../CSS/add_fonctionnaire.css"
import RHNavbar from "./RH_Navbar";


function AddFonctionnaire() {
  const [formData, setFormData] = useState({});

  const handleChange = (e, section, key) => {
    const value = e.target.value;
    setFormData((prevData) => ({
      ...prevData,
      [section]: {
        ...(prevData[section] || {}),
        [key]: value,
      },
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log("Form Data Submitted:", formData);
  };

  return (
    <div>
        <RHNavbar/>
    <div className="container">
      <h1>Ajouter Un Fonctionnaire</h1>
      <form onSubmit={handleSubmit}>
        {/* Fonctionnaire Section */}
        <div className="section-row">
          <div className="section">
            <h2>Fonctionnaire</h2>
            <input
              type="text"
              placeholder="CIN"
              onChange={(e) => handleChange(e, "Fonctionnaire", "CIN")}
            />
            <input
              type="text"
              placeholder="Nom"
              onChange={(e) => handleChange(e, "Fonctionnaire", "Nom")}
            />
            <input
              type="text"
              placeholder="Prenom"
              onChange={(e) => handleChange(e, "Fonctionnaire", "Prenom")}
            />
            <input
              type="text"
              placeholder="Sexe"
              onChange={(e) => handleChange(e, "Fonctionnaire", "Sexe")}
            />
            <input
              type="date"
              placeholder="DateNaissance"
              onChange={(e) =>
                handleChange(e, "Fonctionnaire", "DateNaissance")
              }
            />
            <input
              type="text"
              placeholder="LieuNaissance"
              onChange={(e) =>
                handleChange(e, "Fonctionnaire", "LieuNaissance")
              }
            />
            <input
              type="text"
              placeholder="Tel"
              onChange={(e) => handleChange(e, "Fonctionnaire", "Tel")}
            />
            <input
              type="email"
              placeholder="Email"
              onChange={(e) => handleChange(e, "Fonctionnaire", "Email")}
            />
            <input type="file" />
          </div>

          {/* Adresse Section */}
          <div className="section">
            <h2>Adresse</h2>
            <input
              type="text"
              placeholder="Ville"
              onChange={(e) => handleChange(e, "Adresse", "Ville")}
            />
            <input
              type="text"
              placeholder="Commune"
              onChange={(e) => handleChange(e, "Adresse", "Commune")}
            />
            <input
              type="text"
              placeholder="Quartier"
              onChange={(e) => handleChange(e, "Adresse", "Quartier")}
            />
            <input
              type="text"
              placeholder="Rue"
              onChange={(e) => handleChange(e, "Adresse", "Rue")}
            />
            <input
              type="text"
              placeholder="Numero"
              onChange={(e) => handleChange(e, "Adresse", "Numero")}
            />
            <input
              type="text"
              placeholder="CodePostal"
              onChange={(e) => handleChange(e, "Adresse", "CodePostal")}
            />
            <input type="file" />
          </div>
        </div>

        {/* InformationFamiliale Section */}
        <div className="section-row">
          <div className="section">
            <h2>Information Familiale</h2>
            <input
              type="text"
              placeholder="NomPere"
              onChange={(e) =>
                handleChange(e, "InformationFamiliale", "NomPere")
              }
            />
            <input
              type="text"
              placeholder="NomMere"
              onChange={(e) =>
                handleChange(e, "InformationFamiliale", "NomMere")
              }
            />
            <input
              type="text"
              placeholder="SituationFamiliale"
              onChange={(e) =>
                handleChange(e, "InformationFamiliale", "SituationFamiliale")
              }
            />
            <input
              type="date"
              placeholder="DateMariage"
              onChange={(e) =>
                handleChange(e, "InformationFamiliale", "DateMariage")
              }
            />
            <input
              type="number"
              placeholder="Nombre_Cojoints"
              onChange={(e) =>
                handleChange(e, "InformationFamiliale", "Nombre_Cojoints")
              }
            />
            <input
              type="number"
              placeholder="Nombre_enfants"
              onChange={(e) =>
                handleChange(e, "InformationFamiliale", "Nombre_enfants")
              }
            />
            <input type="file" />
          </div>

          {/* Conjoint Section */}
          <div className="section">
            <h2>Conjoint</h2>
            <input
              type="text"
              placeholder="Nom"
              onChange={(e) => handleChange(e, "Conjoint", "Nom")}
            />
            <input
              type="text"
              placeholder="Cin"
              onChange={(e) => handleChange(e, "Conjoint", "Cin")}
            />
            <input
              type="date"
              placeholder="DateNaissance"
              onChange={(e) => handleChange(e, "Conjoint", "DateNaissance")}
            />
            <input
              type="text"
              placeholder="Fonction"
              onChange={(e) => handleChange(e, "Conjoint", "Fonction")}
            />
            <input type="file" />
          </div>
        </div>

        {/* Enfant Section */}
        <div className="section-row">
          <div className="section">
            <h2>Enfant</h2>
            <input
              type="text"
              placeholder="Prenom"
              onChange={(e) => handleChange(e, "Enfant", "Prenom")}
            />
            <input
              type="text"
              placeholder="NomMere"
              onChange={(e) => handleChange(e, "Enfant", "NomMere")}
            />
            <input
              type="date"
              placeholder="DateNaissance"
              onChange={(e) => handleChange(e, "Enfant", "DateNaissance")}
            />
            <input type="file" />
          </div>

          {/* InformationAdministrative Section */}
          <div className="section">
            <h2>Information Administrative</h2>
            <input
              type="text"
              placeholder="PPR"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "PPR")
              }
            />
            <input
              type="text"
              placeholder="PosteBudgetaire"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "PosteBudgetaire")
              }
            />
            <input
              type="date"
              placeholder="DateRecrutement"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "DateRecrutement")
              }
            />
            <input
              type="text"
              placeholder="DiplomeRecrutement"
              onChange={(e) =>
                handleChange(
                  e,
                  "InformationAdministrative",
                  "DiplomeRecrutement"
                )
              }
            />
            <input
              type="text"
              placeholder="AdministrationRecrutement"
              onChange={(e) =>
                handleChange(
                  e,
                  "InformationAdministrative",
                  "AdministrationRecrutement"
                )
              }
            />
            <input
              type="date"
              placeholder="Datetitularisation"
              onChange={(e) =>
                handleChange(
                  e,
                  "InformationAdministrative",
                  "Datetitularisation"
                )
              }
            />
            <input
              type="text"
              placeholder="Grade"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "Grade")
              }
            />
            <input
              type="text"
              placeholder="Echelle"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "Echelle")
              }
            />
            <input
              type="text"
              placeholder="Echelon"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "Echelon")
              }
            />
            <input
              type="text"
              placeholder="Indice"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "Indice")
              }
            />
            <input
              type="text"
              placeholder="StatutAdministratif"
              onChange={(e) =>
                handleChange(
                  e,
                  "InformationAdministrative",
                  "StatutAdministratif"
                )
              }
            />
            <input
              type="text"
              placeholder="Affectation"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "Affectation")
              }
            />
            <input
              type="text"
              placeholder="Fonction"
              onChange={(e) =>
                handleChange(e, "InformationAdministrative", "Fonction")
              }
            />
            <input type="file" />
          </div>
        </div>

        {/* PrevoyanceSociale Section */}
        <div className="section-row">
          <div className="section">
            <h2>Prevoyance Sociale</h2>
            <input
              type="text"
              placeholder="OrganismeRetraite"
              onChange={(e) =>
                handleChange(e, "PrevoyanceSociale", "OrganismeRetraite")
              }
            />
            <input
              type="text"
              placeholder="NumeroAffiliationRetraite"
              onChange={(e) =>
                handleChange(
                  e,
                  "PrevoyanceSociale",
                  "NumeroAffiliationRetraite"
                )
              }
            />
            <input
              type="date"
              placeholder="DateAffiliationRetraite"
              onChange={(e) =>
                handleChange(
                  e,
                  "PrevoyanceSociale",
                  "DateAffiliationRetraite"
                )
              }
            />
            <input
              type="text"
              placeholder="OrganismePrevoyance"
              onChange={(e) =>
                handleChange(e, "PrevoyanceSociale", "OrganismePrevoyance")
              }
            />
            <input
              type="text"
              placeholder="NumeroCNOPS"
              onChange={(e) =>
                handleChange(e, "PrevoyanceSociale", "NumeroCNOPS")
              }
            />
            <input
              type="text"
              placeholder="NumeroImmatriculationCNOPS"
              onChange={(e) =>
                handleChange(
                  e,
                  "PrevoyanceSociale",
                  "NumeroImmatriculationCNOPS"
                )
              }
            />
            <input
              type="date"
              placeholder="DateAffiliationCNOPS"
              onChange={(e) =>
                handleChange(
                  e,
                  "PrevoyanceSociale",
                  "DateAffiliationCNOPS"
                )
              }
            />
            <input
              type="number"
              placeholder="NaffiliationFHassanII"
              onChange={(e) =>
                handleChange(e, "PrevoyanceSociale", "NaffiliationFHassanII")
              }
            />
            <input
              type="text"
              placeholder="OrganisationAssurance"
              onChange={(e) =>
                handleChange(
                  e,
                  "PrevoyanceSociale",
                  "OrganisationAssurance"
                )
              }
            />
            <input
              type="number"
              placeholder="NAffiliationAssurance"
              onChange={(e) =>
                handleChange(e, "PrevoyanceSociale", "NAffiliationAssurance")
              }
            />
            <input type="file" />
          </div>

          {/* Diplome Section */}
          <div className="section">
            <h2>Diplome</h2>
            <input
              type="text"
              placeholder="Intitule"
              onChange={(e) => handleChange(e, "Diplome", "Intitule")}
            />
            <input
              type="text"
              placeholder="Specialite"
              onChange={(e) => handleChange(e, "Diplome", "Specialite")}
            />
            <input
              type="date"
              placeholder="DateObtention"
              onChange={(e) => handleChange(e, "Diplome", "DateObtention")}
            />
            <input
              type="text"
              placeholder="Etablissement"
              onChange={(e) => handleChange(e, "Diplome", "Etablissement")}
            />
            <input type="file" />
          </div>
        </div>

        <button type="submit">Submit</button>
      </form>
    </div>
    </div>
  );
}

export default AddFonctionnaire;