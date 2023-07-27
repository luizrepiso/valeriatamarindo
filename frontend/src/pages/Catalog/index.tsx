import { ReactComponent as Desenho } from 'assets/images/Desenho.svg';

const Catalog = () => {
  return (   <>
    <div className="home-container">
      <h1>Conheça o melhor catálogo de roupas</h1>
      <div className="home-image-container">
        <Desenho />
      </div>
    </div>
  </>
);
};
   
export default Catalog;
