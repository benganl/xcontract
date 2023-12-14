import { createContext, useState } from "react";

export const ApplicationContext = createContext({});

const ApplicationProvider = ({ children }) => {
  const [state, setState] = useState({});

  const updateState = (data) => {
    console.log("Updating state.....", data);
    setState((values) => ({ ...values, [data.name]: data.value }));
  };

  return <ApplicationContext.Provider value={{ updateState, state, setState }}>{children}</ApplicationContext.Provider>;
};

export default ApplicationProvider;
