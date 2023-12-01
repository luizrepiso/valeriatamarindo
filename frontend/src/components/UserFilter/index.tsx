import { ReactComponent as SearchIcon } from 'assets/images/search-icon.svg';
import { useForm } from 'react-hook-form';
import { useEffect, useState } from 'react';
import { requestBackend } from 'util/requests';

import './styles.css';
import { Role } from 'types/role';
import { User } from 'types/user';

export type UserFilterData = {
  name: string;
  role: Role | null;
};

type Props = {
  onSubmitFilter: (data: UserFilterData) => void;
};

const UserFilter = ({ onSubmitFilter }: Props) => {
  const [setSelectUsers] = useState<User[]>([]);

  const { register, handleSubmit, setValue, getValues, control } =
    useForm<UserFilterData>();

  const onSubmit = (formData: UserFilterData) => {
    onSubmitFilter(formData);
  };

  const handleFormClear = () => {
    setValue('name', '');
  };

  useEffect(() => {
    requestBackend({
      withCredentials: true,
      url: '/users',
    }).then((response) => {});
  }, []);

  return (
    <div className="base-card user-filter-container">
      <form onSubmit={handleSubmit(onSubmit)} className="user-filter-form">
        <div className="user-filter-name-container">
          <input
            {...register('name')}
            type="text"
            className="form-control"
            placeholder="Nome do usuário"
            name="name"
          />
          <button className="user-filter-search-icon">
            <SearchIcon />
          </button>
        </div>
        <div className="user-filter-bottom-container">
          <button
            onClick={handleFormClear}
            className="btn btn-outline-secondary btn-user-filter-clear"
          >
            LIMPAR
          </button>
        </div>
      </form>
    </div>
  );
};
export default UserFilter;
