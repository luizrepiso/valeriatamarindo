import ColectionsCard from 'components/ColectionsCard/index';
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
    <div className="container my-4">
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard colection={colection} />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard colection={colection} />
        </div>
      </div>
      <ButtonIcon text="Ver mais" />
    </div>
  );
};

export default Home;
