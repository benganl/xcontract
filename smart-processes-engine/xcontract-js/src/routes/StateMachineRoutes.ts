import express, { Router } from "express";
import { StateMachineConfig } from "../config/ApplicationConfig";
import { StateMachineController } from "../controllers/StateMachineConstroller";

const router: Router = express.Router();

const config: StateMachineConfig = new StateMachineConfig();
const stateMachineController: StateMachineController = new StateMachineController(config);

router.get("/:appId/:itemRef", stateMachineController.get);

router.post("/", stateMachineController.process);

export default router;
