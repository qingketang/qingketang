import { Class, ClassCreateParams } from './api-models';

export const classApi = {

  create: (params: ClassCreateParams): Promise<Class> =>  {
    return new Promise((resolve) => {
      console.log('params', params);
      const classCreated = {
        id: 1,
        no: 'CLASS-DEF',
        name: '默认课程',
      } as Class;

      setTimeout(() => {
        resolve(classCreated);
      }, 2000);
    });
  }
};
