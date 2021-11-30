import Router from "@koa/router";

import * as dft from "./controller/default-controller";

const router = new Router({
    prefix: '/web',
});

router.get('/', dft.index);

export  {router };
