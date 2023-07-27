import ColectionsCard from 'components/ColectionsCard/index';
import './styles.css';
import ButtonIcon from 'components/ButtonIcon';

const Home = () => {
  return (
    <div className="container my-4">
      <div className="row">
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard />
        </div>
        <div className="col-sm-6 col-lg-4 col-xl-3">
          <ColectionsCard />
        </div>
      </div>
      <ButtonIcon text="Ver mais" />
    </div>
  );
};

export default Home;
