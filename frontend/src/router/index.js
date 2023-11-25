import { createRouter, createWebHistory } from 'vue-router'
import ArtTable from "@/pages/arts-table/ArtTable.vue";
import ExhibitionPage from "@/pages/ExhibitionPage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'MainPage',
      component: () => import('../pages/MainPage.vue'),
    },
    {
      path: '/artworks',
      name: 'home',
      component: ArtTable
    },
    {
      path: '/artwork/add',
      name: 'add',
      component: () => import('@/pages/arts-table/AddArtwork.vue')
    },
    {
      path: '/contacts',
      name: 'Contacts',
        component: () => import('../pages/ContactsPage.vue')
    },
    {
      path: '/q-a',
      name: 'QA',
      component:  () => import('../pages/QuestionsAndAnswers.vue')
    },
    {
      path: '/edit/:id',
      name: 'edit',
      component: () => import('@/pages/arts-table/EditArtwork.vue')
    },
    {
      path: '/exhibition',
      name: 'Exhibitions',
      component: ExhibitionPage,

    }
  ]
})
export default router
