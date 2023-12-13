import express, { Request, Response, Router } from "express";
import { StateMachineController } from "../controllers/StateMachineConstroller";
import { StateMachineConfig } from "../config/ApplicationConfig";
import { StateMachineEvent } from "../Common";

const router: Router = express.Router();

const config: StateMachineConfig = new StateMachineConfig();
const stateMachineController: StateMachineController = new StateMachineController(config);

router.get("/:appId/:itemRef", stateMachineController.get);

router.post("/", stateMachineController.process);

export default router;
