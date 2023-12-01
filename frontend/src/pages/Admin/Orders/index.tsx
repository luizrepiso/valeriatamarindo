import { Route, Switch } from 'react-router-dom';
import OrderList from './OrderList';
import OrderForm from './OrderForm';

const orders = () => {
  return (
    <Switch>
      <Route path="/admin/orders" exact>
        <OrderList />
      </Route>
      <Route path="/admin/orders/:orderId" exact>
        <OrderForm />
      </Route>
    </Switch>
  );
};
export default orders;
