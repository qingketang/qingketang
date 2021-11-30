import "reflect-metadata";
import {createConnection, Connection} from "typeorm";
import Koa from "koa";
import {router as webRouter} from "./api/web/router";

async function main() {
    await createConnection({
        type: "mysql",
        host: process.env.DB_HOST,
        port: process.env.DB_PORT as unknown as number,
        username: process.env.DB_USER,
        password: process.env.DB_PWD,
        database: process.env.DB_NAME,
        charset: "utf8mb4",
        entities: ["src/biz/**/entity/*.ts"]
    });

    const app = new Koa();

    app.use(webRouter.routes()).use(webRouter.allowedMethods());

    console.log(`Listen port ${process.env.PORT}`);

    app.listen(process.env.PORT);
}

main().then();




