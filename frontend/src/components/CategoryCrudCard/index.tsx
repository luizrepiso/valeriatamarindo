import './styles.css';
import { Category } from 'types/category';
import { Link } from 'react-router-dom';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';

type Props = {
  category: Category;
  onDelete: Function;
};

const CategoryCrudCard = ({ category, onDelete }: Props) => {
  const handleDelete = (categoryId: number) => {
    if (!window.confirm('Tem certeza que deseja deletar?')) {
      return;
    }

    const config: AxiosRequestConfig = {
      method: 'DELETE',
      url: `/categories/${categoryId}`,
      withCredentials: true,
    };

    requestBackend(config).then(() => {
      onDelete();
    });
  };

  return (
    <div className="base-card category-crud-card">
      <div className="category-crud-card-buttom-container">
        <h6>{category.name}</h6>
      </div>
      <div className="category-crud-card-buttons-container">
        <button
          onClick={() => handleDelete(category.id)}
          className="btn btn-outline-danger category-crud-button-first"
        >
          EXCLUIR
        </button>
        <Link to={`/admin/categories/${category.id}`}>
          <button className="btn btn-outline-secondary category-crud-button">
            EDITAR
          </button>
        </Link>
      </div>
    </div>
  );
};
export default CategoryCrudCard;
