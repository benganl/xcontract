import { Context, StateMachineEvent } from "../Common";
import { StateMachine } from "../services/StateMachine";
import { StateMachineExecutionContext } from "./StateMachineExecutionContext";

export class ApplicationContext {
  private stateMachine: StateMachine;
  constructor(ctx: Context) {
    console.log("Creating an application context");
    this.stateMachine = ctx.stateMachine;
  }

  public create = (event: StateMachineEvent) => {
    return new StateMachineExecutionContext(this.stateMachine, event);
  };
}
