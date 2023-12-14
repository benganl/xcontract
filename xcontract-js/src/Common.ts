import { StateMachineDatabase } from "./database/StateMachineDatabase";
import { StateMachine } from "./services/StateMachine";

export type StateMachineEvent = {
  appId: string;
  itemRef: string;
  action: string;
};

export type StateMachineResult = {
  message: string;
  code: number;
  data: any;
};

export type Context = {
  stateMachine: StateMachine;
  database: StateMachineDatabase;
};
