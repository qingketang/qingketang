import {Context} from "koa";
import {getRepository} from "typeorm";
import {User} from "../../../biz/user/entity/User";

export async function index(ctx: Context) {
    ctx.body = "hello web api";

    const userRepository = getRepository(User);
    const user = await userRepository.findOne(1);

    console.log(user);

}
