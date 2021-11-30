import Koa from "koa";
import {router as webRouter} from "./api/web/router";

const app = new Koa();

app.use(webRouter.routes()).use(webRouter.allowedMethods());

console.log(`Listen port ${process.env.PORT}`);

app.listen(process.env.PORT);
