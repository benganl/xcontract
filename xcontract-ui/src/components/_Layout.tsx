import { Link, Outlet } from "react-router-dom";

const Layout = () => {
  return (
    <>
      <div className="container">
        <div className="header">Header</div>
        <div>
          <div className="nav-container">
            <nav>
              <ul>
                <li>
                  <Link to="/">Home</Link>
                </li>
                <li>
                  <Link to="/work">Work</Link>
                </li>
                <li>
                  <Link to="/dashboard">Dashboard</Link>
                </li>
                <li>
                  <Link to="/help">Help</Link>
                </li>
                <li>
                  <Link to="/about">About</Link>
                </li>
              </ul>
            </nav>
          </div>
          <div className="content">
            <Outlet />
          </div>
        </div>
        <div className="footer">Footer</div>
      </div>
    </>
  );
};

export default Layout;
