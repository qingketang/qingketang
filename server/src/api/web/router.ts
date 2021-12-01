import Router from "@koa/router";
import { Container} from 'typedi';

import {WebDefaultController} from "./controller/WebDefaultController";

const defaultCtrl = Container.get(WebDefaultController);

const router = new Router({
    prefix: '/web',
});

router.get('/', defaultCtrl.index);

export  {router };
