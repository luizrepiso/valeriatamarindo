import './styles.css';
import ColectionPrice from 'components/ColectionPrice';
import { Colection } from 'types/colection';

type Props = {
  colection: Colection;
};

const ColectionCard = ({ colection }: Props) => {
  return (
    <div className="base-card colection-card">
      <div className="card-top-container">
        <img
          className="image-container"
          src={colection.imgUrl}
          alt={colection.name}
        />
      </div>
      <div className="card-bottom-container">
        <h6>{colection.name}</h6>
        <ColectionPrice price={colection.price} />
      </div>
    </div>
  );
};
export default ColectionCard;
