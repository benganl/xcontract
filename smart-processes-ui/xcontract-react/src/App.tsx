import { BrowserRouter, Route, Routes } from "react-router-dom";
import Login from "./components/Login";
import Dashboard from "./components/Dashboard";
import Page from "./components/Page";
import { useState } from "react";

export default function App() {
  const [appState, setAppState] = useState({});

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Page appState={appState} setAppState={setAppState} />}>
          <Route index path="login" element={<Login appState={appState} setAppState={setAppState} />} />
          <Route path="dashboard" element={<Dashboard appState={appState} setAppState={setAppState} />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
