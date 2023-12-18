import React from "react";
import ReactDOM from "react-dom/client";
import ApplicationProvider from "./services/ApplicationContext.tsx";
import App from "./App.tsx";

ReactDOM.createRoot(document.getElementById("root")!).render(
  <React.StrictMode>
    <ApplicationProvider>
      <App />
    </ApplicationProvider>
  </React.StrictMode>
);
