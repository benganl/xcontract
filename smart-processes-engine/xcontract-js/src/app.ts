import express from "express";
import router from "./routes/StateMachineRoutes";
import bodyParser from "body-parser";

const app = express();
const port = process.env.PORT || 3000;

app.use(bodyParser.json());

app.use("/api/sm", router);

app.listen(port, () => {
  console.log(`Server is running at http://localhost:${port}`);
});
