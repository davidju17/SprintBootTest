import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { App } from './App';
import  { BrowserRouter } from 'react-router-dom';
import { loadStripe } from '@stripe/stripe-js'
import { Elements } from '@stripe/react-stripe-js';

const stripePromise = loadStripe(process.env.REACT_APP_STRIPE_PUBLIC_KEY!);

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
//It means that the app will be rendered inside the BrowserRouter component ]
// and it will be able to use the routing features provided by react-router-dom.
root.render(
  <BrowserRouter>
    <Elements stripe={stripePromise}>
      <App />
    </Elements>
  </BrowserRouter>
);
