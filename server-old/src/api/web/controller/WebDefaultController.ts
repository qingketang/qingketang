import {Context} from "koa";
import {Inject, Service} from "typedi";
import {UserService} from "../../../biz/user/service/UserService";

@Service()
export class WebDefaultController {
    constructor(
        @Inject()
        private readonly userService: UserService
    ) {}

    async index(ctx: Context) {
        ctx.body = "hello web api";
        const user = await this.userService.findByName("lilei");
        console.log(user);
    }

}
