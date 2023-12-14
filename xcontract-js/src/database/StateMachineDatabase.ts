import { Pool, QueryConfig } from "pg";

export class StateMachineDatabase {
  pool: Pool;

  constructor(hostname: string, port: number, user: string, password: string, database: string) {
    console.log("Creating db pool...");

    this.pool = new Pool({
      host: hostname,
      port: port,
      user: user,
      password: password,
      database: database,
      min: 10,
      max: 50,
      idleTimeoutMillis: 30000,
      connectionTimeoutMillis: 10000,
    });
  }

  public execute = async (sql: string | QueryConfig) => {
    try {
      const client = await this.pool.connect();
      try {
        return client.query(sql);
      } catch (err) {
        console.log("Error querying the database: ", err);
      } finally {
        client?.release();
      }
    } catch (err) {
      console.log("Boo boo: ", err);
    }
  };
}

module.exports = { StateMachineDatabase };
