import ColectionCard from 'components/ColectionCard/index';
import './styles.css';
import ButtonIcon from 'components/ButtonIcon';
import { Colection } from 'types/colection';


const Home = () => {
  const colection: Colection = {
    id: 2,
    name: 'The Lord of the Rings',
    description: 'fdfdfdfdfdfdf',
    price: 90.5,
    imgUrl:
      'https://static.ecosweb.com.br/public/produtos/moda-feminina/blusa-manga-curta/blusa-barrado-color-alongada_358530_1000_1.webp',
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
    <div className="container my-4">
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionCard colection={colection} />
        </div>
      </div>
      
    </div>
  );
};

export default Home;

