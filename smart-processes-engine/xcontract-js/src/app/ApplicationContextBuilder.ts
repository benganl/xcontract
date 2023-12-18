import { Context } from "../Common";
import { StateMachineConfig } from "../config/ApplicationConfig";
import { StateMachineDatabase } from "../database/StateMachineDatabase";
import { StateMachine } from "../services/StateMachine";
import { ApplicationContext } from "./ApplicationContext";

export class ApplicationContextBuilder {
  private context: Context;

  private config: StateMachineConfig;

  constructor(config: StateMachineConfig) {
    console.log("Creating an application context builder");

    this.config = config;
    const database = this.initializeDatabase(this.config);
    const stateMachine = this.initializeStateMachine(database);

    this.context = {
      database: database,
      stateMachine: stateMachine,
    };
  }

  private initializeDatabase = (config: StateMachineConfig): StateMachineDatabase => {
    console.log("Initializing the database");
    return new StateMachineDatabase(
      config.databaseConfig.host,
      parseInt(config.databaseConfig.port),
      config.databaseConfig.user,
      config.databaseConfig.password,
      config.databaseConfig.database
    );
  };

  private initializeStateMachine = (database: StateMachineDatabase): StateMachine => {
    return new StateMachine(database);
  };

  public build = (): ApplicationContext => {
    return new ApplicationContext(this.context);
  };
}
