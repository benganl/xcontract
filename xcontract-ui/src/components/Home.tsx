import { useContext } from "react";
import { ApplicationContext } from "../services/ApplicationContext";

const Home = () => {
  const { state, setState, updateState } = useContext(ApplicationContext);

  const handleUpdate = (e) => {
    setState((prev) => ({ ...prev, name: "LantonUpdate", data: "12345", loggedIn: true }));
  };

  return (
    <>
      <div>Home</div>
      <div>
        {/* <form name="login"> */}
        {/* <p>Data: {state.data === null ? "Nothing" : state.data.name}</p> */}
        <button onClick={(e) => handleUpdate(e)}>Update state data</button>
        {/* </form> */}
      </div>
    </>
  );
};

export default Home;
