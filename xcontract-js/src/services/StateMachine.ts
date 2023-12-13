import { StateMachineEvent, StateMachineResult } from "../Common";
import { StateMachineDatabase } from "../database/StateMachineDatabase";

class StateMachine {
  private database: StateMachineDatabase;

  constructor(database: StateMachineDatabase) {
    console.log("Creating database!!!");
    this.database = database;
  }

  public process = async (event: StateMachineEvent) => {
    return new Promise<StateMachineResult>((resolve, reject) => {
      resolve({
        code: 200,
        data: "process data response",
        message: "done",
      });
      // reject({});
    });
  };

  public getApplication = async (applicationId: string) => {
    const query = {
      text: "select * from wyzecms.application where applicationId = $1",
      values: [applicationId],
    };

    const application = await this.database.execute(query);

    application?.rows;
  };
}

export { StateMachine };
module.exports = { StateMachine };
