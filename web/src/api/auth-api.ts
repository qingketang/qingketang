/**
 * 登录鉴权API
 */

import {AuthUser} from './api-models';

const exampleUser = {
  id: 1,
  username: '南京B哥',
  avatar: '/boy-avatar.png',
  token: 'a jwt token',
} as AuthUser;

export const authApi = {
  /**
   * 登录
   */
  login: (/* args */): Promise<AuthUser> => {
    return new Promise((resolve) => {
      return resolve(exampleUser);
    });
  },

  /**
   * 通过 Token 获取用户信息
   * @param token
   */
  getUser: (token: string): Promise<AuthUser> =>  {
    return new Promise((resolve) => {
      console.log('getUser', token);
      return resolve(exampleUser);
    });
  }
};
