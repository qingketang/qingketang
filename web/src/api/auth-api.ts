export interface AppUser {
  id: number;
  username: string;
  avatar: string;
  token: string;
}

const exampleUser = {
  id: 1,
  username: '南京B哥',
  avatar: '/boy-avatar.png',
  token: 'a jwt token',
} as AppUser;

export const authApi = {
  login: (/* args */): Promise<AppUser> => {
    return new Promise((resolve) => {
      return resolve(exampleUser);
    });
  },

  getUser: (token: string): Promise<AppUser> =>  {
    return new Promise((resolve) => {
      console.log('getUser', token);
      return resolve(exampleUser);
    });
  }
};
