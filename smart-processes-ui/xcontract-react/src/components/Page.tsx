import { Link, Outlet } from "react-router-dom";

const Page = ({ appState, setAppState }) => {
  return (
    <>
      <div>
        <h1>Page</h1>
        <Link to="/">Home</Link>
        <Link to="/login">Login</Link>
        <Link to="/dashboard">Dashboard</Link>
      </div>
      <div>
        Out here
        <Outlet />
      </div>
    </>
  );
};

export default Page;
