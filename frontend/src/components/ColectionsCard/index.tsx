import ColectionsImg from 'assets/images/cats.jpg';

import './styles.css';
import ColectionPrice from 'components/ColectionPrice';

const ColectionsCard = () => {
  return (
    <div className="base-card colection-card">
      <div className="card-top-container">
        <img className="image-container" src={ColectionsImg} alt="Modelo" />
      </div>
      <div className="card-bottom-container">
        <>Modelos</>
        <ColectionPrice />
      </div>
    </div>
  );
};
export default ColectionsCard;
