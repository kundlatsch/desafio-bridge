import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { FiArrowLeft } from 'react-icons/fi';

import api from '../../services/factorial-api';

import './styles.css';

const HistoryPage = () => {

  const [history, setHistory] = useState([]);

  useEffect(() => {
    async function loadHistory() {
      const response = await api.get('/history/12');
      setHistory(response.data);
    }

    loadHistory();

  }, []);


  return (
    <div id="page-history">
      <div className="content">
        <div className="box"></div>
        <header>
          <Link to='/'>
            <FiArrowLeft />
            Voltar
          </Link>
        </header>

        <main>
          <h2>
            Histórico de Requisições
          </h2>
          <ul className="history">
            {history.map(factorial => (
              <li key={factorial._ROWID_}>
                <p>
                  <strong>Número</strong> <br /> {factorial.number} <br />
                  <strong>Fatorial</strong> <br /> {factorial.numberFactorial} <br />
                </p>
              </li>
            ))}
          </ul>
        </main>
      </div>
    </div>
  )
}

export default HistoryPage;