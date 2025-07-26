import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { App } from './App';
import  { BrowserRouter } from 'react-router-dom';

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
//It means that the app will be rendered inside the BrowserRouter component ]
// and it will be able to use the routing features provided by react-router-dom.
root.render(
  <BrowserRouter>
    <App />
  </BrowserRouter>
);
