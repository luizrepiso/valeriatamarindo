import { Link, NavLink } from 'react-router-dom';
import { hasAnyRoles } from 'util/auth';
import { useContext, useEffect } from 'react';
import { getTokenData, isAuthenticated } from 'util/auth';
import { AuthContext } from 'AuthContext';
import { removeAuthData } from 'util/storage';
import history from 'util/history';

import './styles.css';

const Navbar = () => {
  const { authContextData, setAuthContextData } = useContext(AuthContext);

  useEffect(() => {
    if (isAuthenticated()) {
      setAuthContextData({
        authenticated: true,
        tokenData: getTokenData(),
      });
    } else {
      setAuthContextData({
        authenticated: false,
      });
    }
  }, [setAuthContextData]);

  const handleLogoutClick = (event: React.MouseEvent<HTMLAnchorElement>) => {
    event.preventDefault();
    removeAuthData();
    setAuthContextData({
      authenticated: false,
    });
    history.replace('/');
  };

  return (
    <nav className="admin-nav-container">
      <ul className="admin-nav-items-container">
        <li>
          <NavLink to="/admin/products" className="admin-nav-item ">
            <p>produtos</p>
          </NavLink>
        </li>
        <li>
          <NavLink to="/admin/categories" className="admin-nav-item">
            <p>categorias</p>
          </NavLink>
        </li>
        {hasAnyRoles(['ROLE_ADMIN']) && (
          <li>
            <NavLink to="/admin/users" className="admin-nav-item">
              <p>usuários</p>
            </NavLink>
          </li>
        )}
      
      <li className="nav-logout">
        {authContextData.authenticated ? (
          <>
            {/*   <span className="nav-username">
                {authContextData.tokenData?.user_name}
              </span> */}

            <a href="#logout" onClick={handleLogoutClick}>
              Sair
            </a>
          </>
        ) : (
          <Link to="/admin/auth">LOGIN</Link>
        )}
      </li>
      </ul>
    </nav>
  );
};
export default Navbar;
