import { BrowserRouter, Route, Routes } from "react-router-dom";
import About from "./components/About";
import Dashboard from "./components/Dashboard";
import Help from "./components/Help";
import Home from "./components/Home";
import Login from "./components/Login";
import Work from "./components/Work";
import Page from "./web/Page";

export default function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Page />}>
          <Route index element={<Home />} />
          <Route path="login" element={<Login />} />
          <Route path="dashboard" element={<Dashboard />} />
          <Route path="work" element={<Work />} />
          <Route path="help" element={<Help />} />
          <Route path="about" element={<About />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}
