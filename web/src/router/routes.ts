import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    name: 'Home',
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [{ path: '', component: () => import('pages/Index.vue') }],
  },
  {
    path: '/teacher',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      {
        path: '',
        redirect: {name: 'TeacherCourseList'}
      },
      {
        name: 'TeacherCourseList',
        path: 'courses',
        meta: { requiresAuth: true },
        component: () => import('pages/TeacherCourseList.vue'),
      },
      {name: 'TeacherResourceList',
        path: 'resources',
        meta: { requiresAuth: true },
        component: () => import('pages/TeacherResourceList.vue'),
      }
    ],
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/Error404.vue'),
  },
];

export default routes;
