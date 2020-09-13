import React from 'react';
import { Route, BrowserRouter } from 'react-router-dom';

import Home from './pages/Home';
import HistoryPage from './pages/HistoryPage';

const Routes = () => {
  return (
    <BrowserRouter>
      <Route component={Home} path="/" exact />
      <Route component={HistoryPage} path="/history" />
    </BrowserRouter>
  )
};

export default Routes;