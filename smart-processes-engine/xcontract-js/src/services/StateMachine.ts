import { StateMachineEvent, StateMachineResult } from "../Common";
import { StateMachineDatabase } from "../database/StateMachineDatabase";

class StateMachine {
  private database: StateMachineDatabase;

  constructor(database: StateMachineDatabase) {
    console.log("Creating database!!!");
    this.database = database;
  }

  public process = async (event: StateMachineEvent) => {
    const query = {
      text: `SELECT * FROM wyzecms.application`,
    };

    try {
      const result = await this.database.execute(query);
      return {
        code: 200,
        data: result?.rows,
        message: "done",
      };
    } catch (err) {
      return {
        code: 400,
        message: "Error querying",
        data: undefined,
      };
    }
  };

  public getApplication = async (applicationId: string) => {
    const query = {
      text: "select * from wyzecms.application where applicationId = $1",
      values: [applicationId],
    };
    return await this.database.execute(query);
  };
}

export { StateMachine };
module.exports = { StateMachine };
