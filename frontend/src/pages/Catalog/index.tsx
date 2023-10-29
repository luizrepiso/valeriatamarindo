import ProductCard from 'components/ProductCard/index';
import Pagination from 'components/Pagination';
import { Product } from 'types/product';
import { Link } from 'react-router-dom';
import { SpringPage } from 'types/vendor/spring';
import { useEffect, useState } from 'react';
import { BASE_URL, requestBackend } from 'util/requests';
import { AxiosRequestConfig } from 'axios';

import './styles.css';

const Catalog = () => {
  const [page, setPage] = useState<SpringPage<Product>>();
  const [isLoading, setIsLoading] = useState(false);

  const getProducts = (pageNumber: number) => {
    const params: AxiosRequestConfig = {
      method: 'GET',
      url: "/products",
      baseURL: BASE_URL,
      params: {
        page: pageNumber,
        size: 4,
      },
    };

    setIsLoading(true);
    requestBackend(params)
      .then((response) => {
        setPage(response.data);
        
      })
      .finally(() => {
        setIsLoading(false);
      });
  };

  useEffect(() => {
    getProducts(0);
  }, []);

  return (
    <div className="container my-4 catalog-container">
      <div className="row catalog-title-container">
        <h1>Catálogo de Roupas</h1>
      </div>
      <div className="row">
        {isLoading ? (
          <h4>Carregando</h4>
        ) : (
          page?.content.map((product) => (
            <div className="col-sm-6 col-lg-4 col-xl-3" key={product.id}>
              <Link to="/products/5">
                <ProductCard product={product} />
              </Link>
            </div>
          ))
        )}

        <div className="row">
          <Pagination
            pageCount={page ? page.totalPages : 0}
            range={3}
            onChange={getProducts}
          />
        </div>
      </div>
    </div>
  );
};

export default Catalog;
