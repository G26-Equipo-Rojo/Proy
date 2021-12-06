<template>
    <div id="dashboard">
            <!-- Barra superior -->
            <!-- Header - barra superior-->
        <header class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
            <router-link to="/" class="navbar-brand col-md-3 col-lg-2 me-0 px-3">EQUIPO ROJO</router-link>
            <button class="navbar-toggler position-absolute d-md-none collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu" 
                aria-controls="sidebarMenu" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="navbar-nav form-control-dark w-100">
                <div class="nav-item text-nowrap">
                    <a class="nav-link px-3">
                        <fa icon="calendar" /> 
                        Fecha del sistema : 10:46 p.m
                    </a>
                </div>
            </div>
        </header>

        <!-- Navbar y parte dinámica de la página -->
        <div class="container-fluid">
            <div class="row">
                <!-- Barra lateral izquierda (NAVBAR) -->
                <nav id="sidebarMenu" class="col-md-3 col-lg-2 d-md-block bg-light sidebar collapse">
                    <div class="position-sticky pt-3">
                        <!-- ITEMS DE DEL NAVBAR -->
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <router-link to="/" class="nav-link"> <fa icon="home" /> Inicio</router-link>
                            </li>
                            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                            <span>P R O D U C T O S</span>
                            </h6>
                            <li class="nav-item">
                                <router-link to="/producto" class="nav-link"> <fa icon="poll-h" /> Gestionar productos</router-link>
                            </li>
                            <li class="nav-item">
                                <router-link to="/categoria" class="nav-link"> <fa icon="tags" /> Gestionar categorias</router-link>
                            </li>
                            <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                            <span>U S U A R I O S</span>
                            </h6>
                            <li class="nav-item">
                                <router-link to="/usuario" class="nav-link"> <fa icon="users" /> Gestionar usuarios</router-link>
                            </li>
                        </ul>
                    </div>
                </nav>
                <!-- Parte dinámica de la página (CAMPO DE TRABAJO) -->
                <div class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
                    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                        <h1 class="h2">MAR ABIERTO</h1>
                        <div class="btn-toolbar mb-2 mb-md-0">
                            <div class="dropdown">
                                <a class="btn btn-danger dropdown-toggle" href="#" role="button" id="dropdownMenuLink" 
                                    data-bs-toggle="dropdown" aria-expanded="false">
                                    Bienvenid@ 
                                    <fa icon="laugh" /> 
                                </a>

                                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                    <li>
                                        <a class="dropdown-item"><fa icon="user" /> User:</a>
                                    </li>
                                    <li>
                                        <a class="dropdown-item" ><fa icon="award" /> Rol:</a>
                                    </li>
                                    <li>
                                        <hr class="dropdown-divider">
                                    </li>
                                    <li>
                                        <router-link to="/" class="dropdown-item"> <fa icon="sign-out-alt" /> Cerrar sesión</router-link>
                                        <!-- <a class="dropdown-item" href="../index.html"> <fa icon="sign-out-alt" /> Cerrar sesión</a> -->
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!-- PARTE DINÁMICA - DONDE SE INSERTAN LOS TEMPLATE -->
                    <div id="router">
                        <router-view />
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>

export default {
    name: 'dashboard'
}
</script>
<style>

  #dashboard {
      text-align: left;
  }
  #router {
    position: relative;
    width: 100%;
    height: 900px;
    
  }

  body {
    font-size: 0.875rem;
  }

  /*
 * Sidebar
 */

  .sidebar {
    position: fixed;
    top: 0;
    /* rtl:raw:
  right: 0;
  */
    bottom: 0;
    /* rtl:remove */
    left: 0;
    z-index: 100;
    /* Behind the navbar */
    padding: 48px 0 0;
    /* Height of navbar */
    box-shadow: inset -1px 0 0 rgba(0, 0, 0, 0.1);
  }

  @media (max-width: 767.98px) {
    .sidebar {
      top: 1rem;
    }
  }

  .sidebar-sticky {
    position: relative;
    top: 0;
    height: calc(100vh - 48px);
    padding-top: 0.5rem;
    overflow-x: hidden;
    overflow-y: auto;
    /* Scrollable contents if viewport is shorter than content. */
  }

  .sidebar .nav-link {
    font-weight: 500;
    color: darkmagenta;
  }

  .sidebar .nav-link .feather {
    margin-right: 4px;
    color: #727272;
  }

  .sidebar .nav-link.active {
    color: #2470dc;
  }

  .sidebar .nav-link:hover .feather,
  .sidebar .nav-link.active .feather {
    color: red;
    /*color de los link de la barra lateral izquierda*/
  }

  .sidebar-heading {
    font-size: 0.75rem;
    text-transform: uppercase;
  }

  /*
 * Navbar
 */

  .navbar-brand {
    padding-top: 0.75rem;
    padding-bottom: 0.75rem;
    font-size: 1rem;
    background-color: red;
    /* color de la barra superior izquierda */
    box-shadow: inset -1px 0 0 rgba(0, 0, 0, 0.25);
  }

  .navbar .navbar-toggler {
    top: 0.25rem;
    right: 1rem;
  }

  .navbar .form-control {
    padding: 0.75rem 1rem;
    border-width: 0;
    border-radius: 0;
  }

  .form-control-dark {
    color: #fff;
    background-color: rgba(255,
        255,
        255,
        0.1);
    /*color de la parte central de la barra*/
    border-color: #2470dc;
  }

  .form-control-dark:focus {
    border-color: transparent;
    box-shadow: 0 0 0 3px rgba(255, 255, 255, 0.25);
  }
  
  .bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
  }
  
  @media (min-width: 768px) {
    .bd-placeholder-img-lg {
      font-size: 3.5rem;
    }
  }
</style>