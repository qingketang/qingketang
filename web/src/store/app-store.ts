import { defineStore } from 'pinia';
import { AuthUser } from 'src/api/api-models';

export const useAppStore = defineStore({
  id: 'appStore',
  state() {
    return {
      isLoggedIn: false,
      user: {
        id: 0,
        username: '',
        avatar: '',
        token: '',
      },
      notificationUnread: 3,
    };
  },
  getters: {
    authToken(state: {user: AuthUser}): string {
      if (state.user.token && state.user.token.length > 0) {
        return state.user.token;
      }
      const token = localStorage.getItem('AuthToken');
      if (token && token.length > 0) {
        return token;
      }
      return '';
    }
  },
  actions: {
    login(user: AuthUser) {
      this.isLoggedIn = true;
      this.user = user;
      localStorage.setItem('AuthToken', this.user.token);
    },

    logout() {
      localStorage.removeItem('AuthToken');
      this.isLoggedIn = false;
      this.user = {
        id: 0,
        username: '',
        avatar: '',
        token: '',
      }
    }
  }
})
