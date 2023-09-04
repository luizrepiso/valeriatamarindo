import { NavLink } from 'react-router-dom';
import './styles.css';

const Navbar = () => {
  return (
    <nav className="admin-nav-container">
      <ul>
        <li>
          <NavLink to="/admin/colections" className="admin-nav-item ">
            <p>coleções</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/categories" className="admin-nav-item">
            <p>categorias</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/users" className="admin-nav-item">
            <p>usuários</p>
          </NavLink>
        </li>
      </ul>
    </nav>
  );
};
export default Navbar;
