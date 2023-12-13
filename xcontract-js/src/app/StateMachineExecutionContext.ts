import { StateMachineEvent, StateMachineResult } from "../Common";
import { StateMachine } from "../services/StateMachine";

export class StateMachineExecutionContext {
  private stateMachine: StateMachine;
  private event: StateMachineEvent;

  constructor(stateMachine: StateMachine, event: StateMachineEvent) {
    this.stateMachine = stateMachine;
    this.event = event;
  }

  public process = async (): Promise<StateMachineResult> => {
    this.stateMachine;
    return await this.stateMachine.process(this.event);
  };
}
