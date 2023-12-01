import CategoryCrudCard from 'components/CategoryCrudCard';
import { Link } from 'react-router-dom';
import { useCallback, useEffect, useState } from 'react';
import { SpringPage } from 'types/vendor/spring';
import { Category } from 'types/category';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';
import Pagination from 'components/Pagination';
import CategoryFilter, { CategoryFilterData } from 'components/CategoryFilter';

import './styles.css';

type ControlComponentsData = {
  activePage: number;
  filterData: CategoryFilterData;
};

const CategoryList = () => {
  const [page, setPage] = useState<SpringPage<Category>>();

  const [controlComponentsData, setControlComponentsData] =
    useState<ControlComponentsData>({
      activePage: 0,
      filterData: { name: ''},
    });

  const handlePageChange = (pageNumber: number) => {
    setControlComponentsData({
      activePage: pageNumber,
      filterData: controlComponentsData.filterData,
    });
  };

  const handleSubmitFilter = (data: CategoryFilterData) => {
    setControlComponentsData({
      activePage: 0,
      filterData: data,
    });
  };

  const getCategories = useCallback(() => {
    const config: AxiosRequestConfig = {
      method: 'GET',
      url: '/categories',
      params: {
        page: controlComponentsData.activePage,
        size: 12,
        name: controlComponentsData.filterData.name,      
        
      },
    };
    requestBackend(config).then((response) => {
      setPage(response.data);
    });
  }, [controlComponentsData]);

  useEffect(() => {
    getCategories();
  }, [getCategories]);


  return (
    <div className="category-crud-container">
      <div className="category-crud-bar-container">
        <Link to="/admin/categories/create">
          <button className="btn btn-danger text-#961417 btn-category-crud-add">
            ADICIONAR
          </button>
        </Link>
        <CategoryFilter onSubmitFilter={handleSubmitFilter} />
      </div>

      <div className="row-category" >
        {page?.content.map((category) => (
          <div key={category.id} className="col-sm-6 col-md-12">
            <CategoryCrudCard category={category} onDelete={getCategories} />
          </div>
        ))}
      </div>
      <Pagination
        forcePage={page?.number}
        pageCount={(page) ? page.totalPages : 0}
        range={3}
        onChange={handlePageChange}
      />
    </div>
  );
};
export default CategoryList;
