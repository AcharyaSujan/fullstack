import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  {
    path: '/',
    name: 'login',
    component: () => import('../views/LoginView.vue')
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../layout/Layout.vue'),
    redirect: '/dashboard',
    children:[
      {
        path: '/category',
        name: 'category',
        component: ()=>import("../views/CategoryView.vue")
      },
      {
        path: '/dashboard',
        name: 'Dashboard',
        component: () => import('../views/DashboardView.vue')
      },
      {
        path: '/course',
        name: 'course',
        component: () => import('../views/CourseView.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
