import { Link } from "react-router-dom";

const Menu = () => {
  return (
    <>
      <nav className="nav flex-column">
        <Link className="nav-link" to="/">
          Home
        </Link>
        <Link className="nav-link" to="/login">
          Login
        </Link>
        <Link className="nav-link" to="/work">
          Work
        </Link>
        <Link className="nav-link" to="/dashboard">
          Dashboard
        </Link>
        <Link className="nav-link" to="/help">
          Help
        </Link>
        <Link className="nav-link" to="/about">
          About
        </Link>
      </nav>
    </>
  );
};

export default Menu;
