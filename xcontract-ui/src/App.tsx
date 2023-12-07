import { BrowserRouter, Route, Routes } from "react-router-dom";
import "./App.css";
import Home from "./components/Home";
import Layout from "./components/_Layout";
import Dashboard from "./components/Dashboard";
import Work from "./components/Work";
import Help from "./components/Help";
import About from "./components/About";
import { createContext, useState } from "react";

export interface StateObject {
  loggedIn: boolean;
  username: string;
}

export const ApplicationContext = createContext({});

function App() {
  const [state, setState] = useState({ name: "", data: {} });

  return (
    <>
      <ApplicationContext.Provider value={{ state, setState }}>
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Layout />}>
              <Route index element={<Home />} />
              <Route path="dashboard" element={<Dashboard />} />
              <Route path="work" element={<Work />} />
              <Route path="help" element={<Help />} />
              <Route path="about" element={<About />} />
            </Route>
          </Routes>
        </BrowserRouter>
      </ApplicationContext.Provider>
    </>
  );
}

export default App;
