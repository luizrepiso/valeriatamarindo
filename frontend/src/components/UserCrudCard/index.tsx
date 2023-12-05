import { User } from 'types/user';
import { Link } from 'react-router-dom';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';
import RoleBadge from 'pages/Admin/Users/RoleBadge';

import './styles.css';

type Props = {
  user: User;
  onDelete: Function;
};

const UserCrudCard = ({ user, onDelete }: Props) => {
  const handleDelete = (userId: number) => {
    if (!window.confirm('Tem certeza que deseja deletar?')) {
      return;
    }

    const config: AxiosRequestConfig = {
      method: 'DELETE',
      url: `/users/${userId}`,
      withCredentials: true,
    };

    requestBackend(config).then(() => {
      onDelete();
    });
  };

  return (
    <div className="base-card user-crud-card">     
        <div className="user-crud-card-buttom-container">
          <h6>Nome:</h6>
          <p>{user.name}</p>
         </div>
         <div className="user-crud-roles-container">
          {user.roles.map((role) => (
            <RoleBadge authority={role.authority} key={role.id} />
          ))}
        </div>
        
      <div className="user-crud-card-buttons-container">
        <button
          onClick={() => handleDelete(user.id)}
          className="btn btn-outline-danger user-crud-button-first"
        >
          EXCLUIR
        </button>
        <Link to={`/admin/users/${user.id}`}>
          <button className="btn btn-outline-secondary user-crud-button">
           
            EDITAR
          </button>
        </Link>
      </div>
    </div>
  );
};
export default UserCrudCard;
