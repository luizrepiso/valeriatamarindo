import { ReactComponent as SearchIcon } from 'assets/images/search-icon.svg';
import { Category } from 'types/category';
import { Controller, useForm } from 'react-hook-form';
import Select from 'react-select';
import { useEffect, useState } from 'react';
import { requestBackend } from 'util/requests';

import './style.css';

export type CategoryFilterData = {
  name: string;
  category: Category | null;
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

  const handleChangeCategory = (value: Category) => {
    setValue('category', value);

    const obj : CategoryFilterData = {
      name: getValues('name'),
      category: getValues('category'),
    };
    onSubmitFilter(obj);
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
            placeholder="Nome do produto"
            name="name"
          />
          <button className="category-filter-search-icon">
            <SearchIcon />
          </button>
        </div>
        <div className="category-filter-bottom-container">
          <div className="category-filter-category-container">
            <Controller
              name="category"
              control={control}
              render={({ field }) => (
                <Select
                  {...field}
                  options={selectCategories}
                  isClearable
                  placeholder="Categoria"
                  classNamePrefix="category-filter-select"
                  onChange={(value) => handleChangeCategory(value as Category)}
                  getOptionLabel={(category: Category) => category.name}
                  getOptionValue={(category: Category) => String(category.id)}
                />
              )}
            />
          </div>
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
