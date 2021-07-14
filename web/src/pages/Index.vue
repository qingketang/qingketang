<template>
  <q-page class="row items-center justify-evenly">
    <q-btn color="primary" label="模拟登录" @click='login' />
  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import {authApi} from 'src/api/auth-api';
import {useAppStore} from 'src/store/app-store';

export default defineComponent({
  name: 'PageIndex',
  components: { },
  setup() {
    const store = useAppStore();
    return {
      store,
    };
  },
  methods: {
    login: async function() {
      const user = await authApi.login();
      this.store.login(user);
      await this.$router.push({name: 'TeacherCourseList'});
    }
  }
});
</script>
