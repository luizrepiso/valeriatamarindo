import ProductCrudCard from 'pages/Admin/Products/ProductCrudCard';

import './styles.css';
import { Link } from 'react-router-dom';

const List = () => {
  const product = {
    id: 2,
    name: 'Blusa Tricô',
    description: 'Linda Blusa Verde',
    price: 700.0,
    imgUrl: 'https://static.ecosweb.com.br/public/produtos/moda-feminina/blusa-manga-curta/blusa-barrado-color-alongada_358530_1000_1.webp',
    
    date: '2020-07-20T10:00:00Z',
    categories: [
      {
        id: 2,
        name: 'Vestidos',
      },
      {
        id: 1,
        name: 'Saia',
      },
      {
        id: 1,
        name: 'Blusas',
      }
    ],
  };

  return (
    <>
      <div className="product-crud-bar-container">
        <Link to="/admin/products/create">
          <button className="btn btn-danger text-#961417 btn-crud-add">
            ADICIONAR
          </button>
        </Link>
        <div className="base-card product-filter-container">Search bar</div>
      </div>
      <div className="row">
        <div className="col-sm-6 col-md-12">
          <ProductCrudCard product={product} />
        </div>

        <div className="col-sm-6 col-md-12">
          <ProductCrudCard product={product} />
        </div>

        <div className="col-sm-6 col-md-12">
          <ProductCrudCard product={product} />
        </div>
      </div>
    </>
  );
};
export default List;
