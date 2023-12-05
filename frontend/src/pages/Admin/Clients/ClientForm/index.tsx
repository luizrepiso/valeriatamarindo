import { useForm } from 'react-hook-form';
import { Client } from 'types/client';
import { requestBackend } from 'util/requests';
import { AxiosRequestConfig } from 'axios';
import { useHistory } from 'react-router-dom';

import './styles.css';

const ClientForm = () => {
  const history = useHistory();

  const {
    register,
    handleSubmit,
    formState: { errors },
  } = useForm<Client>();

  const onSubmit = (formData: Client) => {
    const data = { ...formData, addresses: [{ id: 18, street: '' }] };

    const config: AxiosRequestConfig = {
      method: 'POST',
      url: '/clients',
      data,
      withCredentials: true,
    };

    requestBackend(config).then(() => {
      history.push('/admin/clients');
    });
  };

  const handleCancel = () => {
    history.push('/admin/clients');
  };

  return (
    <div className="client-crud-container">
      <div className="base-card client-crud-form-card">
        <h1 className="client-crud-form-title">DADOS DOS CLIENTES</h1>
        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="row client-crud-inputs-container">
            <div className="col-lg-6 client-crud-inputs-left-container">
              <div className="margin-bottom-30">
                <input
                  {...register('name', {
                    required: 'Campo Obrigatório',
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? 'is-invalid' : ''
                  }`}
                  placeholder="Nome do Cliente"
                  name="name"
                />
                <div className="invalid-feedback d-block">
                  {errors.name?.message}
                </div>
              </div>
              <div className="margin-bottom-30">
                <input
                  {...register('cpf', {
                    required: 'Campo Obrigatório',
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? 'is-invalid' : ''
                  }`}
                  placeholder="CPF"
                  name="cpf"
                />
                <div className="invalid-feedback d-block">
                  {errors.cpf?.message}
                </div>
              </div>
              <div className="margin-bottom-30">
                <input
                  {...register('email', {
                    required: 'Campo Obrigatório',
                    pattern: {
                      value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                      message: 'Email Inválido',
                    },
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? 'is-invalid' : ''
                  }`}
                  placeholder="Email"
                  name="email"
                />
                <div className="invalid-feedback d-block">
                  {errors.email?.message}
                </div>
              </div>
              <div className="margin-bottom-30">
                <input
                  {...register('phone', {
                    required: 'Campo Obrigatório',
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? 'is-invalid' : ''
                  }`}
                  placeholder="Telefone"
                  name="phone"
                />
                <div className="invalid-feedback d-block">
                  {errors.phone?.message}
                </div>
              </div>
              {/* <div className="margin-bottom-30">
                <input
                  {...register('addresses', {
                    required: 'Campo Obrigatório',
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? 'is-invalid' : ''
                  }`}
                  placeholder="Telefone"
                  name="phone"
                />
                <div className="invalid-feedback d-block">
                  {errors.addresses?.message}
                </div>
              </div> */}
            </div>
          </div>
          <div className="client-crud-buttons-container">
            <button
              className="btn btn-outline-danger client-crud-button"
              onClick={handleCancel}
            >
              CANCELAR
            </button>
            <button className="btn btn-primary client-crud-button text-white">
              SALVAR
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};

export default ClientForm;
