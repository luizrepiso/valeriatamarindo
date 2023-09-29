import ProductCard from 'components/ProductCard/index';
import Pagination from 'components/Pagination';
import { Product } from 'types/product';
import { Link } from 'react-router-dom';
import { SpringPage } from 'types/vendor/spring';
import { useEffect, useState } from 'react';
import { requestBackend } from 'util/requests';
import { AxiosRequestConfig } from 'axios';

import './styles.css';

const Catalog = () => {
  const [page, setPage] = useState<SpringPage<Product>>();
  const [isLoading, setIsLoading] = useState(false);

  useEffect(() => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: '/products',
      params: {
        page: 0,
        size: 12,
      },
    };

    setIsLoading(true);
    requestBackend(params)
      .then((response) => {
        setPage(response.data);
        console.log(page);
      })
      .finally(() => {
        setIsLoading(false);
      });
  }, []);

  return (
    <div className="container my-4 catalog-container">
      <div className="row catalog-title-container">
        <h1>Catálogo de Roupas</h1>
      </div>
      <div className="row">
        {isLoading ? (
          <h1>Carregando</h1>
        ) : (
          page?.content.map((product) => (
            <div className="col-sm-6 col-lg-4 col-xl-3" key={product.id}>
              <Link to="/products/2">
                <ProductCard product={product} />
              </Link>
            </div>
          ))
        )}

        <div className="row">
          <Pagination />
        </div>
      </div>
    </div>
  );
};

export default Catalog;
