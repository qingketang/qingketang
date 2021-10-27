import { FastifyPluginAsync } from 'fastify';
import {Classroom} from "../entity/Classroom";

const root: FastifyPluginAsync = async (fastify, opts): Promise<void> => {
  fastify.get('/', async function (request, reply) {
    const repo = this.orm.getRepository(Classroom);
    const classrooms = await repo.find();
    return { classrooms }
  })
}

export default root;
