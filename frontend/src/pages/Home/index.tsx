import { ReactComponent as Desenho } from 'assets/images/Desenho.svg';
import Navbar from 'components/Navbar';

import './styles.css';

const Home = () => {
  return (
    <>
      <Navbar />
      <div className="home-container">
        <div className=" base-card home-card">
          <div className="home-content-container">
            <h1>Conheça o melhor catálogo de roupas</h1>
          </div>
          <div className="home-image-container">
            <Desenho />
          </div>
          
        </div>
        
      </div>
    </>
  );
};

export default Home;
