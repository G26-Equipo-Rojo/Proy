import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// Boostrap
import "bootstrap/dist/css/bootstrap.min.css";
import "bootstrap/dist/js/bootstrap.bundle.js";

//SweetAert2
import VueSweetalert2 from 'vue-sweetalert2';
import 'sweetalert2/dist/sweetalert2.min.css';

//Iconos - fontawesome
import { library } from '@fortawesome/fontawesome-svg-core';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
library.add(fas);


createApp(App)
    .component('fa', FontAwesomeIcon)
    .use(VueSweetalert2)
    .use(router)
    .mount('#app')

    