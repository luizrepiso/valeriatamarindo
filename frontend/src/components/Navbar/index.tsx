import '@popperjs/core';
import 'bootstrap/js/dist/collapse';
import LogoImg from 'assets/images/logo.png';
import { Link, NavLink } from 'react-router-dom';
import history from 'util/history';
import './styles.css';
import { useContext, useEffect } from 'react';
import { AuthContext } from 'AuthContext';
import { getTokenData, isAuthenticated } from 'util/auth';
import { removeAuthData } from 'util/storage';

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
    <nav className="navbar navbar-expand-md bg-light main-nav">
      <div className="image-container">
        <img className="main-image" src={LogoImg} alt="Modelo" />
      </div>
      <div className="container-fluid">
        <Link to="/" className="nav-logo-text">
          <h6>Loja Valeria Tamarindo</h6>
        </Link>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#valeriatamarindo-navbar"
          aria-controls="valeriatamarindo-navbar"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="valeriatamarindo-navbar">
          <ul className="navbar-nav offset-md-3 main-menu">
            <li>
              <NavLink to="/" activeClassName="active" exact>
                HOME
              </NavLink>
            </li>
            <li>
              <NavLink to="/products" activeClassName="active">
                CATÁLOGO
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin" activeClassName="active">
                ADMIN
              </NavLink>
            </li>
            <li className="nav-logout">
              {authContextData.authenticated ? (
                <a href="#logout" onClick={handleLogoutClick}>
                  SAIR
                </a>
              ) : (
                <Link to="/admin/auth">LOGIN</Link>
              )}
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};
export default Navbar;
