
import './App.css';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Absence from './react_pages/Absence';
import Login from './react_pages/login'
import All from './react_pages/ALL'
import Navbar from './react_pages/Navbar'
import Formation from './react_pages/Formation';
import InfoPerso from './react_pages/InfoPerso';
import InfoADM from './react_pages/infoADM';
import RHNavbar from './react_pages/RH_Navbar';
import AddFonctionnaire from './react_pages/add_fonctionnaire';


function App() {
  return (
    
        <Router>
        <Routes>
          <Route path='/absence' element={<Absence />} />
          <Route path='/login' element={<Login />}/>
          <Route path='/all' element={<All />}/>
          <Route path='/navbar' element={<Navbar />}/>
          <Route path='/formations' element={<Formation />}/>
          <Route path='/infospersonelles' element={<InfoPerso />}/>
          <Route path='/infosadministratives' element={<InfoADM />}/>
          <Route path='/rhnavbar' element={<RHNavbar />}/>
          <Route path='/ajoute' element={<AddFonctionnaire />}/>
        </Routes>
        </Router>
  );
}

export default App;
