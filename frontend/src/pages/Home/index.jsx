import React from 'react';
import { Link } from 'react-router-dom';

import './styles.css';
// TODO: create and import logo
//<img src={logo} alt="Factorial!"/>

const Home = () => {
  return (
    <div id="page-home">
      <div className="content">
        <header>
        </header>

        <main>
          <h1>
            Insira um número para calcular seu fatorial
          </h1>

          <Link to="/history">
            <strong>
              Acessar Histórico
            </strong>
          </Link>
        </main>
      </div>
    </div>
  )
};

export default Home;