import { Client } from 'types/client';
import { Link } from 'react-router-dom';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';

import './styles.css';

type Props = {
  client: Client;
  onDelete: Function;
};

const ClientCrudCard = ({ client, onDelete }: Props) => {

  const handleDelete = (clientId: number) => {
    if (!window.confirm('Tem certeza que deseja deletar?')) {
      return;
    }

    const config: AxiosRequestConfig = {
      method: 'DELETE',
      url: `/clients/${clientId}`,
      withCredentials: true,
    };

    requestBackend(config).then(() => {
      onDelete();
    });
  };

  return (
    <div className="base-card client-crud-card">
      <div className="client-crud-card-container">
        <div className="client-crud-card-buttom-container">
          <h6> Nome: {client.name}</h6>
        </div>
        <div className="client-crud-card-buttom-container">
          <h6> CPF:{client.cpf}</h6>
        </div>
        <div className="client-crud-card-buttom-container">
          <h6> Telefone: {client.phone}</h6>
        </div>
        <div className="client-crud-card-buttom-container">
          <h6> Email: {client.email}</h6>
        </div>

        <div className="client-crud-addresses-container">
          {client.addresses.map((address) => (
            <dl key={address.id}>
              <h6 className="addrees-h6">Endereço:</h6>
              <div className="client-crud-address">
                <dt>Rua:</dt> <dd> {address.street}</dd>
              </div>
              <div className="client-crud-address">
                <dt>Número:</dt> <dd>{address.number}</dd>
              </div>
              <div className="client-crud-address">
                <dt>Bairro:</dt> <dd>{address.district}</dd>
              </div>
              <div className="client-crud-address">
                <dt> Cidade: </dt> <dd>{address.city}</dd>
              </div>
              <div className="client-crud-address">
                <dt>Complemento:</dt> <dd> {address.complement}</dd>
              </div>
              <div className="client-crud-address">
                <dt>Código Postal:</dt> <dd> {address.postalCode}</dd>
              </div>
            </dl>
          ))}
        </div>
      </div>

      <div className="client-crud-card-buttons-container">
        <button
          onClick={() => handleDelete(client.id)}
          className="btn btn-outline-danger client-crud-button-first"
        >
          EXCLUIR
        </button>
        <Link to={`/admin/clients/${client.id}`}>
          <button className="btn btn-outline-secondary client-crud-button">
            EDITAR
          </button>
        </Link>
      </div>
    </div>
  );
};
export default ClientCrudCard;
