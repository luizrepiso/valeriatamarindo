import { formatPrice } from 'util/formaters';
import './styles.css';

type Props = {
  price: number;
};

const ColectionPrice = ({ price }: Props) => {
  return (
    <div className="colection-price-container">
      <span>R$</span>
      <h3>{formatPrice(price)}</h3>
    </div>
  );
};
export default ColectionPrice;
