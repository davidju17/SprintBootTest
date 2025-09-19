import React from 'react';
import './App.css';
import { Navbar } from './layouts/NavbarAndFooter/Navbar';
import { Footer } from './layouts/NavbarAndFooter/Footer';
import { HomePage } from './layouts/HomePage/HomePage';
import { SearchBooksPage } from './layouts/SearchBooksPage/SearchBooksPage';
import { Routes, Route, Navigate } from 'react-router-dom';
import { BookCheckoutPage } from './layouts/BookCheckoutPage/BookCheckoutPage';


import { auth0Config } from './lib/auth0Config';
import LoginPage from './Auth/LoginPage';
import { Auth0Provider, withAuthenticationRequired} from '@auth0/auth0-react';

import { useNavigate } from 'react-router-dom';
import { ReviewListPage } from './layouts/BookCheckoutPage/ReviewListPage/ReviewListPage';

const Auth0ProviderWithHistory = ({ children }: { children: React.ReactNode }) => {
  const navigate = useNavigate();

  const onRedirectCallback = (appState: any) => {
    navigate(appState?.returnTo || "/home");
  };

  return (
    <Auth0Provider
      domain={auth0Config.issuer}
      clientId={auth0Config.clientId}
      authorizationParams={{
        redirect_uri: auth0Config.redirectUri,
        audience: auth0Config.audience,
        scope: auth0Config.scope,
      }} 
      onRedirectCallback={onRedirectCallback}
    >
      {children}
    </Auth0Provider>
  );
};

const SecureRoute = ({ component, path, ...args }: { component: React.ComponentType<any>, path: string }) => (
  // <Route path={path} component={withAuthenticationRequired(component)} {...args} />
  <Route path={path} element={React.createElement(withAuthenticationRequired(component))} {...args} />
);


export const App = () => {
  return (
    <div className="d-flex flex-column min-vh-100">
      <Auth0ProviderWithHistory>
      <Navbar />
      <div className="flex-grow-1">
        <Routes>
          <Route path="/" element={<Navigate to="/home" replace />} />
          <Route path="/home" element={<HomePage />} />
          <Route path="/search" element={<SearchBooksPage />} />
          <Route path="/reviewlist/:bookId" element={<ReviewListPage />} />
          <Route path="/checkout/:bookId" element={<BookCheckoutPage />} />
          <Route path='/login' element={<LoginPage />} />
          {/* <SecureRoute path='/shelf' component={ShelfPage} />
          <SecureRoute path='/messages' component={MessagesPage} />
          <SecureRoute path='/admin' component={ManageLibraryPage} /> */}
        </Routes>
      </div>
      <Footer />
      </Auth0ProviderWithHistory>
    </div>
  );
}
