import LogoImg from 'assets/images/logo.png';
import { Route, Switch } from 'react-router-dom';

import './styles.css';

const Auth = () => {
  return (
    <div className="auth-container">
      <div className="auth-banner-container">
        <h1>Loja Valeria Tamarindo</h1>
        <p>A melhor loja de roupas de Mirassolândia</p>
        <div className="image-container">
          <img className="main-image" src={LogoImg} alt="Modelo" />
        </div>
      </div>
      <div className="auth-form-container">
        <Switch>
          <Route path="/admin/auth/login">
            <h1>Card de login</h1>
          </Route>
          <Route path="/admin/auth/signup">
            <h1>Card de signup</h1>
          </Route>
          <Route path="/admin/auth/recover">
            <h1>Card de recover</h1>
          </Route>
        </Switch>
      </div>
    </div>
  );
};
export default Auth;
