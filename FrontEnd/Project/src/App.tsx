import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import Activities from './pages/Activities';
import CreateActivity from './pages/CreateActivity';
import Login from './pages/Login';
import Register from './pages/Register';
import JoinActivity from './pages/JoinActivity';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/activities" element={<Activities />} />
        <Route path="/create" element={<CreateActivity />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/join/:id" element={<JoinActivity />} />
      </Routes>
    </Router>
  );
}

export default App;