import { useContext } from "react";
import { ApplicationContext } from "../App";

const Dashboard = () => {
  const { state, setState } = useContext(ApplicationContext);

  const handleUpdate = (e) => {
    // setState(((prev) => { ...prev, name: "Test", loggedIn: true }));
  };

  return (
    <>
      <h1>Dashboard</h1>
      <p>App state: {state.name && state.name}</p>
    </>
  );
};

export default Dashboard;
