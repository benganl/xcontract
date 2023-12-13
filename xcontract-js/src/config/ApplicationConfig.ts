export class StateMachineConfig {
  public databaseConfig = {
    host: process.env.DB_HOSTNAME || "localhost",
    port: process.env.DB_PORT || "5432",
    user: process.env.DB_USER_NAME || "dev",
    password: process.env.DB_PASSWORD || "dev",
    database: process.env.DB_NAME || "wyzecmsdb",
    schema: process.env.DB_SCHEMA || "wyzecmsdb",
  };
}
