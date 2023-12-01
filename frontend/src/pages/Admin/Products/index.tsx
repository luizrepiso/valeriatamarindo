import { Route, Switch } from 'react-router-dom';
import ProductList from './ProductList';
import ProductForm from './ProductForm';

const products = () => {
  return (
    <Switch>
      <Route path="/admin/products" exact>
        <ProductList />
      </Route>
      <Route path="/admin/products/:productId" exact>
        <ProductForm />
      </Route>
    </Switch>
  );
};
export default products;
