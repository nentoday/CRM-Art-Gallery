<script setup>
import { RouterLink } from 'vue-router'
</script>

<template>
  <header>
    <nav class="navbar navbar-expand-lg navbar-light">
      <img src="@/assets/logo.png" alt="Логотип" class="logo">
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target=".navbar-collapse">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="container header-container">
        <div class="collapse navbar-collapse">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <router-link to="/" class="nav-link">Головна</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/contacts" class="nav-link">Контакти</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/q-a" class="nav-link">Q&A</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/artworks" class="nav-link">Усі роботи</router-link>
            </li>
            <li class="nav-item">
              <router-link to="/exhibition" class="nav-link">Виставки</router-link>
            </li>

            <li class="nav-item">
              <router-link to="/login" class="nav-link btn login-button">Увійти</router-link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  </header>
</template>
<style>
@media screen and (max-width: 768px) {
  .navbar-expand-lg .navbar-nav {
    flex-direction: column;
  }

  .navbar-collapse.show {
    display: block;
  }

  .navbar-nav .nav-link {
    padding: 10px 0;
    text-align: center;
  }

  .header-container {
    background-color: #9a9697 !important;
    box-shadow: 0 0 0 !important;
  }
}

header {
  background-color: #9b9797;
}

.container {
  background-color: #ffffff;
  padding: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  flex: 1;
}

.header-container {
  background-color: #817779;
}

.logo {
  width: 250px;
}

@media screen and (max-width: 768px) {
  .logo {
    width: 200px;
    margin: auto;
    display: block;
  }
}

.nav-item a.nav-link {
  font-size: 18px;
}

.nav-item {
  margin-left: 20px;
}

.login-button {
  background-color: #6b5258 !important;
  color: #f1f1f1 !important;
  border-radius: 20px !important;
}

.login-button:hover {
  background-color: rgba(241, 241, 241, 0.42);
}
</style>