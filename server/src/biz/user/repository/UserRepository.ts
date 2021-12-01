import {EntityRepository, Repository} from "typeorm";
import {User} from "../entity/User";
import {Service} from "typedi";

@Service()
export class UserRepository extends Repository<User> {

    findByName(name: string) {
        return this.findOne({ name });
    }

}
