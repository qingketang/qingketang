import {Context} from "koa";

export function index(ctx: Context) {
    ctx.body = "hello web api";
}
