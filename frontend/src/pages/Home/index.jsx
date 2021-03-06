import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import api from '../../services/factorial-api';

import './styles.css';

const Home = () => {

  const [factorialNumber, setFactorialNumber] = useState('');
  const [result, setResult] = useState('');

  async function handleSubmit(event) {
    event.preventDefault();
    
    const number = parseInt(factorialNumber);
    if (isNaN(number) || number < 0) {
      setResult('Insira um número válido');
    }
    else if (number > 12) {
      setResult('Nosso servidor não é capaz de calcular o fatorial desse número :(')
    }
    else {
      const response = await api.post('/factorial', { number });
      const { numberFactorial } = response.data;
      setResult(numberFactorial);
    }

  }

  return (
    <div id="page-home">
      <div className="content">
        <div className="box"></div>
        <main>
          <h2>
            Insira um número para calcular seu fatorial
          </h2>

          <form onSubmit={handleSubmit}>
            <input
                type="text"
                name="number"
                id="numer"
                onChange={event => setFactorialNumber(event.target.value)}
              />

            <button type="submit">
              Calcular
            </button> 
          </form>

          <p>{result}</p>

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