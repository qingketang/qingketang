import { RouteRecordRaw } from 'vue-router';

const routes: RouteRecordRaw[] = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [{ path: '', component: () => import('pages/Index.vue') }],
  },
  {
    path: '/teacher',
    component: () => import('layouts/NavLayout.vue'),
    children: [
      { path: '', redirect: {name: 'TeacherCourseList'}},
      { path: 'courses', component: () => import('pages/TeacherCourseList.vue'), name: 'TeacherCourseList' },
      { path: 'resources', component: () => import('pages/TeacherResourceList.vue'), name: 'TeacherResourceList' }
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
