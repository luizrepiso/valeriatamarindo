import './styles.css';
import ProductPrice from 'components/ProductPrice';
import { Order } from 'types/order';
import { Link } from 'react-router-dom';
import { AxiosRequestConfig } from 'axios';
import { requestBackend } from 'util/requests';

type Props = {
  order: Order;
  onDelete: Function;
};

const OrderCrudCard = ({ order, onDelete }: Props) => {
  const handleDelete = (orderId: number) => {
    if (!window.confirm('Tem certeza que deseja deletar?')) {
      return;
    }

    const config: AxiosRequestConfig = {
      method: 'DELETE',
      url: `/orders/${orderId}`,
      withCredentials: true,
    };

    requestBackend(config).then(() => {
      onDelete();
    });
  };

  return (
    <div className="base-card order-crud-card">
      
      <div className="order-crud-card-description">
        {/* <div className="order-crud-card-buttom-container">
          <h6>{order.name}</h6>
          <ProductPrice price={order.price} />
        </div> */}
        
      </div>
      <div className="order-crud-card-buttons-container">
        <button
          onClick={() => handleDelete(order.id)}
          className="btn btn-outline-danger order-crud-button-first"
        >
          EXCLUIR
        </button>
        <Link to={`/admin/orders/${order.id}`}>
          <button className="btn btn-outline-secondary order-crud-button">
           
            EDITAR
          </button>
        </Link>
      </div>
    </div>
  );
};
export default OrderCrudCard;
