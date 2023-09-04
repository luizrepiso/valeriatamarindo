import ColectionCard from 'components/ColectionCard/index';
import Pagination from 'components/Pagination';
import { Colection } from 'types/colection';
import { Link } from 'react-router-dom';

import './styles.css';

const Catalog = () => {
  const colection: Colection = {
    id: 2,
    name: 'The Lord of the Rings',
    description: 'fdfdfdfdfdfdf',
    price: 90.5,
    imgUrl:
      'https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/16-big.jpg',
    date: '2020-07-13T20:50:07.123450Z',
    categories: [
      {
        id: 1,
        name: 'Livros',
      },
      {
        id: 3,
        name: 'Computadores',
      },
    ],
  };

  return (
    <div className="container my-4 catalog-container">
      <div className="row catalog-title-container">
        <h1>Catálogo de Roupas</h1>
      </div>
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/colections/1">
            <ColectionCard colection={colection} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/colections/1">
            <ColectionCard colection={colection} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/colections/1">
            <ColectionCard colection={colection} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/colections/1">
            <ColectionCard colection={colection} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/colections/1">
            <ColectionCard colection={colection} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/colections/1">
            <ColectionCard colection={colection} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/colections/1">
            <ColectionCard colection={colection} />
          </Link>
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <Link to="/colections/1">
            <ColectionCard colection={colection} />
          </Link>
        </div>
        <div className="row"><Pagination/>

        </div>
      </div>      
    </div>
  );
};

export default Catalog;
