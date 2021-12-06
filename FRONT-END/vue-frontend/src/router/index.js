import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Producto from '@/views/producto/Producto.vue'
import Categoria from '@/views/categoria/Categoria.vue'
import Usuario from '@/views/usuario/Usuario.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/producto',
    name: 'Producto',
    component: Producto
  },
  {
    path: '/categoria',
    name: 'Categoria',
    component: Categoria
  },
  {
    path: '/usuario',
    name: 'Usuario',
    component: Usuario
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
