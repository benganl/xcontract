import { Request, Response } from "express";
import { StateMachineEvent } from "../Common";
import { StateMachineConfig } from "../config/ApplicationConfig";
import { ApplicationContext } from "../app/ApplicationContext";
import { ApplicationContextBuilder } from "../app/ApplicationContextBuilder";

export class StateMachineController {
  private config: StateMachineConfig;
  private ctx: ApplicationContext;

  constructor(config: StateMachineConfig) {
    console.log("Creating controller!!!");
    this.config = config;
    this.ctx = new ApplicationContextBuilder(this.config).build();
  }

  public get = async (req: Request, res: Response) => {
    const {
      params: { appId, itemRef },
    } = req;

    console.log("ItemRef:::: %s, %s", appId, itemRef);

    const event: StateMachineEvent = {
      appId: appId,
      itemRef: itemRef,
      action: "CREATE",
    };

    return this.ctx.create(event).process();
  };

  public process = async (req: Request, res: Response) => {
    const { body } = req;

    console.log(body);

    const event: StateMachineEvent = {
      appId: body.appId,
      itemRef: body.itemRef,
      action: body.action,
    };

    return this.ctx.create(event).process();
  };
}

export default StateMachineController;
