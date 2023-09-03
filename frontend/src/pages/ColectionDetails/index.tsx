import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import ColectionPrice from 'components/ColectionPrice';

import './styles.css';
import { Link } from 'react-router-dom';

const ColectionDetails = () => {
  return (
    <div className="colection-details-container">
      <div className="colection-details-card">
        <Link to="/colections">
        <div className="goback-container">
          <ArrowIcon />
          <h2>VOLTAR</h2>
        </div>
        </Link>
        <div className="row">
          <div className="col-xl-6">
            <div className="img-container">
              <img
                src="https://lojamob.vteximg.com.br/arquivos/ids/417241/32203103CRM3602.jpg?v=638119747117400000"
                alt="Nome do Produto"
              />
            </div>
            <div className="name-price-container">
              <h1>Nome do Produto</h1>
              <ColectionPrice price={2345.65} />
            </div>
          </div>
          <div className="col-xl-6">
            <div className="description-container">
              <h2>Descrição do Produto</h2>
              <p>
                Lorem ipsum dolor sit amet consectetur adipisicing elit. Iusto,
                odio.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};
export default ColectionDetails;
