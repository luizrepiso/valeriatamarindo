import './styles.css';

const Form = () => {
  return (
    <div className="product-crud-container">
      <div className="base-card product-crud-form-card">
        <h1 className="product-crud-form-title">DADOS DO PRODUTO</h1>

        <form action="">
          <div className="row product-crud-inputs-container">
            <div className="col-lg-6 product-crud-inputs-left-container">
                <div className="margin-buttom-30">
              <input type="text" className="form-control base-input" />
              </div>
              <div className="margin-buttom-30">
              <input type="text" className="form-control base-input" />
              </div>
              <div>
              <input type="text" className="form-control base-input" />
              </div>
            </div>
            <div className="col-lg-6">
                <div>
              <textarea name="" rows={10} className="form-control base-input h-auto"></textarea>
              </div>
            </div>
          </div>
        </form>
<div className= "product-crud-buttons-container">
    <button className=" btn btn-outline-danger form-crud-button">CANCELAR</button>
    <button className=" btn btn-danger text-#961417  form-crud-button">SALVAR</button>

</div>


      </div>
    </div>
  );
};
export default Form;
