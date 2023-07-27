import './styles.css';
import '@popperjs/core';
import 'bootstrap/js/dist/collapse';

import LogoImg from 'assets/images/logo.png';
import { Link, NavLink } from 'react-router-dom';

const Navbar = () => {
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
          <ul className="navbar-nav offset-md-2 main-menu">
            <li>
              <NavLink to="/" activeClassName="active" exact>
                HOME
              </NavLink>
            </li>
            <li>
              <NavLink to="colections" activeClassName="active">
                CATÁLOGO
              </NavLink>
            </li>
            <li>
              <NavLink to="/admin" activeClassName="active">
                ADMIN
              </NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};
export default Navbar;
