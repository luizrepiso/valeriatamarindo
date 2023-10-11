import './styles.css';

const Form = () => {
  return (
    <div className="product-crud-container">
      <div className="base-card product-crud-form-card">
        <h1 className="product-crud-form-title">DADOS DO PRODUTO</h1>

        <form action="">
          <div className="row">
            <div className="col-lg-6">
              <input type="text" className="form-control base-input" />
              <input type="text" className="form-control base-input" />
              <input type="text" className="form-control base-input" />
            </div>
            <div className="col-lg-6">
              <textarea name="" rows={10} className="form-control base-input"></textarea>
            </div>
          </div>
        </form>
<div >
    <button className=" btn btn-outline-danger">CANCELAR</button>
    <button className=" btn btn-danger text-#961417">SALVAR</button>

</div>


      </div>
    </div>
  );
};
export default Form;
