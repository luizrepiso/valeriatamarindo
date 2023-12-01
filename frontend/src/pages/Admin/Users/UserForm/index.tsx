import { useForm, Controller } from 'react-hook-form';
import { User } from 'types/user';
import { requestBackend } from 'util/requests';
import { AxiosRequestConfig } from 'axios';
import { useHistory, useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import Select from 'react-select';
import { toast } from 'react-toastify';
import { Role } from 'types/role';

import './styles.css';

type UrlParams = {
  userId: string;
};

const UserForm = () => {
  const options = [];

  const { userId } = useParams<UrlParams>();

  const isEditing = userId !== 'create';

  const history = useHistory();

  const [selectRoles, setSelectRoles] = useState<Role[]>([]);

  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
    control,
  } = useForm<User>();

  useEffect(() => {
    requestBackend({      
      url: '/roles',
      withCredentials: true,
    }).then((response) => {
      setSelectRoles(response.data.content);
    });
  }, []);

  useEffect(() => {
    if (isEditing) {
      requestBackend({ url: `/users/${userId}` }).then((response) => {

        const user = response.data as User;

        setValue('name', user.name);
        setValue('email', user.email);
        setValue('password', user.password);
        setValue('roles', user.roles);                
        
      });
    }
  }, [isEditing, userId, setValue, ]);
 
  const onSubmit = (formData: User) => {
    const data = {
      ...formData,
    };

    const config: AxiosRequestConfig = {
      method: isEditing ? 'PUT' : 'POST',
      url: isEditing ? `/users/${userId}` : '/users',
      data,
      withCredentials: true,
    };

    requestBackend(config)
      .then(() => {
        toast.info('Usuário cadastrado com sucesso');
        history.push('/admin/users');
      })
      .catch(() => {
        toast.error('Erro ao cadastrar o usuário');
      });
  };

  const handleCancel = () => {
    history.push('/admin/users');
  };

  return (
    <div className="user-crud-container">
      <div className="base-card user-crud-form-card">
        <h1 className="user-crud-form-title">DADOS DO PRODUTO</h1>

        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="row user-crud-inputs-container">
            <div className="col-lg-6 user-crud-inputs-left-container">
              <div className="margin-buttom-30">
                <input
                  {...register('name', {
                    required: 'Campo Obrigatório',
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? 'is-invalid' : ''
                  }`}
                  placeholder="Nome"
                  name="name"
                />
                <div className="invalid-feedback d-block">
                  {errors.name?.message}
                </div>
              </div>
              <div className="margin-buttom-30">
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
        <div className="margin-buttom-30">
                <input
                  {...register('password', {
                    required: 'Campo Obrigatório',
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? 'is-invalid' : ''
                  }`}
                  placeholder="Senha"
                  name="password"
                />
                <div className="invalid-feedback d-block">
                  {errors.password?.message}
                </div>
              </div>
        <div className="margin-buttom-30">
                <Controller
                  name="roles"
                  rules={{ required: true }}
                  control={control}
                  render={({ field }) => (
                    <Select
                      {...field}
                      options={selectRoles}
                      classNamePrefix="user-crud-select"
                      isMulti
                      getOptionLabel={(role: Role) => role.authority}
                      getOptionValue={(role: Role) =>
                        String(role.id)
                      }
                    />
                  )}
                />
                {errors.roles && (
                  <div className="invalid-feedback d-block">
                    Campo Obrigatório
                  </div>
                )}
              </div>
            </div>
          </div>
          <div className="user-crud-buttons-container">
            <button
              className=" btn btn-outline-danger form-crud-button"
              onClick={handleCancel}
            >
              CANCELAR
            </button>
            <button className=" btn btn-danger text-#961417  form-crud-button">
              SALVAR
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};
export default UserForm;
