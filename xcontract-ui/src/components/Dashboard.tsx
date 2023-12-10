import { ChangeEvent, useContext, useEffect, useState } from "react";
import { isLoggedIn } from "../services/SecurityService";
import { ApplicationContext } from "../services/ApplicationContext";
import { useNavigate } from "react-router-dom";

const Dashboard = () => {
  const [form, setForm] = useState({});
  const { state, setState, updateState } = useContext(ApplicationContext);
  const navigator = useNavigate();

  const authenticated: boolean = isLoggedIn(localStorage.getItem("token"));

  useEffect(() => {
    if (!authenticated) {
      navigator("/login");
    }
  }, [navigator, state, updateState]);

  const handleClick = (e) => {
    const il = isLoggedIn(localStorage.getItem("token"));
    setState((p) => ({ ...p, name: "Livhu", age: 100 }));
    console.log("Is logged in: ", il);
  };

  const handleChange = (e) => {
    const name: string = e.target.name;
    const value: string = e.target.value;
    setForm((p) => ({ ...p, [name]: value }));
  };

  return (
    <>
      <h1>Dashboard</h1>
      <p>
        App state: Name : {state.name && state.name}, Age: {state.age}
      </p>
      <label htmlFor="name">Enter name</label>
      <input type="text" name="name" onChange={(e) => handleChange(e)} />
      <button onClick={(e) => handleClick(e)}>Check auth</button>
    </>
  );
};

export default Dashboard;
