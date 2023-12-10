import { useContext, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { ApplicationContext } from "../services/ApplicationContext";
import { isLoggedIn } from "../services/SecurityService";

const Work = () => {
  const { state, setState, updateState } = useContext(ApplicationContext);
  const navigator = useNavigate();

  const authenticated: boolean = isLoggedIn(localStorage.getItem("token"));

  useEffect(() => {
    if (!authenticated) {
      navigator("/login");
    }
  }, [navigator, state, updateState]);

  return <h1>Work</h1>;
};

export default Work;
