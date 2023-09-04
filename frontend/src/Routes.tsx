import Navbar from 'components/Navbar';
import Admin from 'pages/Admin';
import Catalog from 'pages/Catalog';
import ProductDetails from 'pages/ColectionDetails';
import Home from 'pages/Home';
import { BrowserRouter, Switch, Route, Redirect } from 'react-router-dom';

const Routes = () => (
  <BrowserRouter>
    <Navbar />
    <Switch>
      <Route path="/" exact>
        <Home />
      </Route>
      <Route path="/colections" exact>
        <Catalog />
      </Route>
      <Route path="/colections/:colectionId">
        <ProductDetails />
      </Route>
      <Redirect from="/admin" to="/admin/colections" exact />
      <Route path="/admin">
        <Admin />
      </Route>
    </Switch>
  </BrowserRouter>
);
export default Routes;
