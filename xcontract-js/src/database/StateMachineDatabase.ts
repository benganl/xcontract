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
      min: 5,
      max: 10,
      idleTimeoutMillis: 30000,
      connectionTimeoutMillis: 20000,
    });
  }

  public execute = async (sql: string | QueryConfig) => {
    const client = await this.pool.connect();
    try {
      const result = await client.query(sql);
      return result;
    } catch (err) {
      console.log("Error", err);
    } finally {
      client.release();
    }
  };
}

module.exports = { StateMachineDatabase };
