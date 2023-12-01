import { useForm } from 'react-hook-form';
import { Category } from 'types/category';
import { requestBackend } from 'util/requests';
import { AxiosRequestConfig } from 'axios';
import { useHistory, useParams } from 'react-router-dom';
import { useEffect, useState } from 'react';
import { toast } from 'react-toastify';

import './styles.css';

type UrlParams = {
  categoryId: string;
};

const CategoryForm = () => {
    const { categoryId } = useParams<UrlParams>();

  const isEditing = categoryId !== 'create';

  const history = useHistory();

  const [selectCategories, setSelectCategories] = useState<Category[]>([]);

  const {
    register,
    handleSubmit,
    formState: { errors },
    setValue,
    } = useForm<Category>();

  useEffect(() => {
    requestBackend({
      url: '/categories',
    }).then((response) => {
      setSelectCategories(response.data.content);
    });
  }, []);

  useEffect(() => {
    if (isEditing) {
      requestBackend({ url: `/categories/${categoryId}` }).then((response) => {
        const category = response.data as Category;

        setValue('name', category.name);
      });
    }
  }, [isEditing, categoryId, setValue]);

  const onSubmit = (formData: Category) => {
    const data = {
      ...formData,
    };

    const config: AxiosRequestConfig = {
      method: isEditing ? 'PUT' : 'POST',
      url: isEditing ? `/categories/${categoryId}` : '/categories',
      data,
      withCredentials: true,
    };

    console.log(config);
    requestBackend(config)
      .then(() => {
        toast.info('Categoria cadastrada com sucesso');
        history.push('/admin/categories');
      })
      .catch(() => {
        toast.error('Erro ao cadastrar a categoria');
      });
  };

  const handleCancel = () => {
    history.push('/admin/categories');
  };

  return (
    <div className="category-crud-container">
      <div className="category-crud-form-card">
        <h1 className="category-crud-form-title">DADOS DA CATEGORIA</h1>

        <form onSubmit={handleSubmit(onSubmit)}>
          <div className="row category-crud-inputs-container">
            <div className="col-lg-6 category-crud-inputs-left-container">
              <div className="category-margin-buttom-30">
                <input
                  {...register('name', {
                    required: 'Campo Obrigatório',
                  })}
                  type="text"
                  className={`form-control base-input ${
                    errors.name ? 'is-invalid' : ''
                  }`}
                  placeholder="Nome da categoria"
                  name="name"
                />
                <div className="invalid-feedback d-block">
                  {errors.name?.message}
                </div>
              </div>
            </div>
          </div>
          <div className="category-crud-buttons-container">
            <button
              className=" btn btn-outline-danger category-form-crud-button"
              onClick={handleCancel}
            >
              CANCELAR
            </button>
            <button className=" btn btn-danger text-#961417  category-form-crud-button">
              SALVAR
            </button>
          </div>
        </form>
      </div>
    </div>
  );
};
export default CategoryForm;
