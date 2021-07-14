<template>
  <q-layout view="hHh LpR fFf">
    <q-header bordered class="bg-white text-primary">
      <q-toolbar>
        <q-btn dense flat round icon="menu" color="grey-8" @click="toggleLeftDrawer" v-if='store.isLoggedIn' />
        <q-toolbar-title style="line-height: 1;">
          <img src="/static/img/logo.png" srcset="/static/img/logo.png 1x, /static/img/logo@2x.png 2x">
        </q-toolbar-title>

        <div class="q-gutter-sm row items-center no-wrap" v-if='store.isLoggedIn'>
          <q-btn round dense flat icon="notifications">
            <q-badge color="red" text-color="white" floating>{{ store.notificationUnread }}</q-badge>
            <q-tooltip>通知</q-tooltip>
          </q-btn>
          <q-btn round flat>
            <q-avatar size="26px">
              <img :src=store.user.avatar>
            </q-avatar>
            <q-tooltip>账号</q-tooltip>
            <q-menu>
              <q-list style="width: 200px;">
                <q-item v-close-popup="false" :clickable="false">
                  <q-item-section avatar>
                    <q-avatar>
                      <img :src=store.user.avatar>
                    </q-avatar>
                  </q-item-section>
                  <q-item-section><q-item-label :lines="1">{{ store.user.username }}</q-item-label></q-item-section>
                </q-item>
                <q-separator />
                <q-item clickable v-close-popup>
                  <q-item-section>设置</q-item-section>
                </q-item>
                <q-item clickable v-close-popup @click='logout'>
                  <q-item-section>退出</q-item-section>
                </q-item>
              </q-list>
            </q-menu>
          </q-btn>
        </div>
      </q-toolbar>
    </q-header>

    <q-drawer
      show-if-above
      v-model="leftDrawerOpen"
      side="left"
      bordered
      class="grey-1"
      :width="240"
      v-if='store.isLoggedIn'
    >
      <q-scroll-area class="fit">
        <q-list>
          <template v-for="(menuItem, index) in menuList" :key="index">
            <q-item clickable v-ripple :to="menuItem.to">
              <q-item-section avatar>
                <q-icon :name="menuItem.icon" />
              </q-item-section>
              <q-item-section>
                {{ menuItem.label }}
              </q-item-section>
            </q-item>
            <q-separator :key="'sep' + index" v-if="menuItem.separator" />
          </template>
        </q-list>
      </q-scroll-area>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import { useAppStore } from 'src/store/app-store';

export default defineComponent({
  setup() {
    const leftDrawerOpen = ref(false);
    const menuList = [
      {
        icon: 'class',
        label: '课程',
        to: { name: 'TeacherCourseList' },
        separator: false,
      },
      {
        icon: 'video_library',
        label: '课件库',
        to: { name: 'TeacherResourceList' },
        separator: false,
      },
    ];

    const store = useAppStore();

    return {
      store,
      leftDrawerOpen,
      menuList,
      toggleLeftDrawer() {
        leftDrawerOpen.value = !leftDrawerOpen.value;
      },
    };
  },
  methods: {
    logout: async function() {
      this.store.logout();
      await this.$router.push({ name: 'Home' });
    }
  }
});
</script>
