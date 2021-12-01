import {Service} from "typedi";
import {UserRepository} from "../repository/UserRepository";
import {InjectRepository} from "typeorm-typedi-extensions";
import {getCustomRepository} from "typeorm";

@Service()
export class UserService {

    findByName(name: string) {
        const repo = getCustomRepository(UserRepository);
        return repo.findByName(name);
    }
}
