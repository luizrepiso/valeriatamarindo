import { AxiosRequestConfig } from 'axios';
import ClientCrudCard from 'components/ClientCrudCard';
import { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { Client } from 'types/client';
import { SpringPage } from 'types/vendor/spring';
import { requestBackend } from 'util/requests';

import './styles.css';

const ClientList = () => {
  const [page, setPage] = useState<SpringPage<Client>>();

  useEffect(() => {
    getClients();
  }, []);

  const getClients = () => {
    const config: AxiosRequestConfig = {
      method: 'GET',
      url: '/clients',
      withCredentials: true,
      params: {
        page: 0,
        size: 50,
      },
    };

    requestBackend(config).then((response) => {
      setPage(response.data);
    });
  };

  return (
    <div className="client-crud-container">
      <div className="client-crud-bar-container">
        <Link to="/admin/clients/create">
          <button className="btn btn-primary text-white">ADICIONAR</button>
        </Link>
        <div className="base-card client-filter-container">Search bar</div>
      </div>
      <div className="row">
        {page?.content.map((client) => (
          <div key={client.id}>
            <ClientCrudCard client={client} onDelete={()=> getClients()} />
          </div>
        ))}
      </div>
    </div>
  );
};
export default ClientList;
