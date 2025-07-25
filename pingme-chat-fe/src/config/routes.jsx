import React from 'react'
import App from '../App.jsx'
import {Routes, Route} from "react-router";

const AppRoutes = () => {
  return (
     <Routes>
      <Route path="/" element = {<App/>}/>
      <Route path="/about" element = {<h1>Hi, you're in</h1>}/>
      <Route path="/chat" element = {<h1>Hi, this is chat</h1>}/>
    </Routes>
  )
}

export default AppRoutes;