import { ReactComponent as SearchIcon } from 'assets/images/search-icon.svg';
import { Category } from 'types/category';
import { useForm } from 'react-hook-form';
import { useEffect, useState } from 'react';
import { requestBackend } from 'util/requests';

import './style.css';

export type CategoryFilterData = {
  name: string;
  
};

type Props = {
  onSubmitFilter: (data: CategoryFilterData) => void;
};

const CategoryFilter = ({ onSubmitFilter }: Props) => {
  const [selectCategories, setSelectCategories] = useState<Category[]>([]);

  const { register, handleSubmit, setValue, getValues, control } =
    useForm<CategoryFilterData>();

  const onSubmit = (formData: CategoryFilterData) => {
    onSubmitFilter(formData);
  };

  const handleFormClear = () => {
    setValue('name', '');    
    
  };  

  useEffect(() => {
    requestBackend({
      url: '/categories',
    }).then((response) => {
      setSelectCategories(response.data.content);
    });
  }, []);

  return (
    <div className="base-card category-filter-container">
      <form onSubmit={handleSubmit(onSubmit)} className="category-filter-form">
        <div className="category-filter-name-container">
          <input
            {...register('name')}
            type="text"
            className="form-control"
            placeholder="Nome da categoria"
            name="name"
          />
          <button className="category-filter-search-icon">
            <SearchIcon />
          </button>
        </div>
        <div className="category-filter-bottom-container">
          
          <button
            onClick={handleFormClear}
            className="btn btn-outline-secondary btn-category-filter-clear"
          >
            LIMPAR
          </button>
        </div>
      </form>
    </div>
  );
};
export default CategoryFilter;
