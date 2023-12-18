import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { AuthRequest, SecurityManager } from "../services/SecurityService";

const Login = ({ appState, setAppState }) => {
  const securityManager = new SecurityManager();

  const [formData, setFormData] = useState({ username: "", password: "" });

  const navigator = useNavigate();

  useEffect(() => {
    console.log(appState);
    if (securityManager.isLoggedIn()) {
      navigator("/dashboard");
    } else {
      navigator("/login");
    }
  }, []);

  const handleInput = (e) => {
    const name: string = e.target.name;
    const value: string = e.target.value;
    // console.log(`${name} = ${value}`);
    setFormData((v) => ({ ...v, [name]: value }));
  };

  const handleLogin = (e) => {
    e.preventDefault();
    const { username, password } = formData;

    console.log(`${username} ${password}`);

    if (securityManager.isLoggedIn()) {
      setAppState((p) => ({ ...p, loggedIn: true }));
      return;
    }

    const authDetails: AuthRequest = {
      username: username,
      password: password,
    };

    securityManager
      .handleLogin(authDetails)
      .then(() => {
        setAppState((p) => ({ ...p, loggedIn: true }));
      })
      .catch(() => {
        console.log("there was a problem login in!!!");
      });
  };

  return (
    <div>
      <h1>Login</h1>
      <form>
        <div>
          <label htmlFor="username">Username</label>
          <input name="username" type="text" placeholder="username@mail.co.za" onChange={handleInput} />
          <br />
          <label htmlFor="password">Password</label>
          <input name="password" type="password" placeholder="password" onChange={handleInput} />
          <br />
          <button onClick={handleLogin} name="_login">
            Login
          </button>
        </div>
      </form>
    </div>
  );
};

export default Login;
