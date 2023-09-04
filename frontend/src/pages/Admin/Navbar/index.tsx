import './styles.css';

const Navbar = () => {
  return (
    <nav className="admin-nav-container">
      <ul>
        <li>
          <a href="link" className="admin-nav-item active">
            <p>coleções</p>
          </a>
        </li>
        <li>
          <a href="link"  className="admin-nav-item">
            <p>categorias</p>
          </a>
        </li>
        <li>
          <a href="link"  className="admin-nav-item">
            <p>usuários</p>
          </a>
        </li>
      </ul>
    </nav>
  );
};
export default Navbar;
