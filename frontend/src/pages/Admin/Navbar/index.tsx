import { NavLink } from 'react-router-dom';
import { hasAnyRoles } from 'util/auth';
import './styles.css';

const Navbar = () => {
  return (
    <nav className="admin-nav-container">
      <ul className="admin-nav-items-container">
        <li>
          <NavLink to="/admin/categories" className="admin-nav-item">
            <p>categorias</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/clients" className="admin-nav-item ">
            <p>clientes</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/orders" className="admin-nav-item ">
            <p>vendas</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/products" className="admin-nav-item ">
            <p>produtos</p>
          </NavLink>
        </li>

        {hasAnyRoles(['ROLE_ADMIN']) && (
          <li>
            <NavLink to="/admin/users" className="admin-nav-item">
              <p>usuários</p>
            </NavLink>
          </li>
        )}
      </ul>
    </nav>
  );
};
export default Navbar;
