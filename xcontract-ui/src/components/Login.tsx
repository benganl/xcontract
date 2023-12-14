import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AuthRequest, handleLogin, isLoggedIn } from "../services/SecurityService";

const Login = () => {
  const navigator = useNavigate();
  const [formState, setFormState] = useState({ username: "", password: "" });
  const [auth, setAuth] = useState(false);

  const handleInput = (e) => {
    const name = e.target.name;
    const value = e.target.value;
    setFormState((values) => ({ ...values, [name]: value }));
  };

  useEffect(() => {
    if (authenticated) {
      navigator("/dashboard");
    }
  }, []);

  const login = (e) => {
    e.preventDefault();
    const loginDetails: AuthRequest = { username: formState.username, password: formState.password };
    handleLogin(loginDetails).then((data) => {
      if (isLoggedIn()) {
        console.log("successfully authenticated!!!");
        setAuth(true);
      }
    });
  };

  return (
    <main className="form-signin w-50 m-auto">
      <form method="POST">
        <img className="mb-4" src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57" />
        <h1 className="h3 mb-3 fw-normal">Please sign in</h1>

        <div className="form-floating">
          <input type="text" name="username" className="form-control" id="floatingInput" placeholder="name@example.com" onChange={handleInput} />
          <label htmlFor="floatingInput">Username</label>
        </div>
        <div className="form-floating">
          <input type="password" name="password" className="form-control" id="floatingPassword" placeholder="Password" onChange={handleInput} />
          <label htmlFor="floatingPassword">Password</label>
        </div>
        <button className="btn btn-primary w-100 py-2" type="submit" onClick={(e) => login(e)}>
          Sign in
        </button>
        <p className="mt-5 mb-3 text-body-secondary">&copy; 2017–2023</p>
      </form>
    </main>
  );
};

export default Login;
