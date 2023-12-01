import { Switch } from 'react-router-dom';
import Navbar from './Navbar';
import Users from './Users';
import PrivateRoute from 'components/PrivateRoute';
import Products from './Products';
import Categories from './Categories';
import Clients from './Clients';


import './styles.css';
import Orders from './Orders';



const Admin = () => {
  return (
    <div className="admin-container">
      <Navbar />
      <div className="admin-content">
        <Switch>
          <PrivateRoute path="/admin/products">
            <Products />
          </PrivateRoute>
          <PrivateRoute path="/admin/categories">
            <Categories />
          </PrivateRoute>
          <PrivateRoute path="/admin/users" roles={['ROLE_ADMIN']}>
            <Users />
          </PrivateRoute>
          <PrivateRoute path="/admin/clients">
            <Clients />
          </PrivateRoute>
          <PrivateRoute path="/admin/orders">
            <Orders />
          </PrivateRoute>
        </Switch>
      </div>
    </div>
  );
};
export default Admin;
