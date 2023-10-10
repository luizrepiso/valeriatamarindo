import { Route, Switch } from 'react-router-dom';
import List from './List';
import Form from './Form';

const products = () => {
  return (
    <Switch>
      <Route path="/admin/products" exact>
        <List />
      </Route>
      <Route path="/admin/products/:productsId" exact>
        <Form />
      </Route>
    </Switch>
  );
};
export default products;
