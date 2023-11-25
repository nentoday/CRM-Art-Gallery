<template>
  <div id="app">
    <HeaderTemp/>
    <main>
      <router-view/>
    </main>
    <FooterTemp/>
  </div>
</template>
<script>
import HeaderTemp from '@/layout/HeaderTemp.vue';
import FooterTemp from '@/layout/FooterTemp.vue';

export default {
  components: {
    HeaderTemp,
    FooterTemp,
  },
};
</script>

<style>
main {
  min-height: calc(80vh - 80px);
}
</style>