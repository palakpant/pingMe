import React from 'react'
import App from '../App.jsx'
import {Routes, Route} from "react-router";
import ChatPage from '../components/ChatPage.jsx';

const AppRoutes = () => {
  return (
     <Routes>
      <Route path="/" element = {<App/>}/>
      <Route path="/about" element = {<h1>Hi, you're in</h1>}/>
      <Route path="/chat" element = {<ChatPage/>}/>
    </Routes>
  )
}

export default AppRoutes;