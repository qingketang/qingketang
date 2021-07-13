import { defineStore } from 'pinia';

export const useAppStore = defineStore({
  id: 'appStore',
  state() {
    return {
      user: {
        id: 1,
        username: '南京B哥',
        avatar: '',
      }

    };
  },
})
