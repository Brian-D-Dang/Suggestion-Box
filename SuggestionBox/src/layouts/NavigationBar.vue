<template>
  <q-layout view="hHh LpR fFf">

    <q-header reveal elevated class="bg-primary text-white">
      <q-toolbar>

        <q-toolbar-title>
          <img src="statics/icons/logo.png">
        </q-toolbar-title>
      </q-toolbar>

      <q-tabs align="left">
        <q-route-tab to="/dashboard" label="Dashboard" />
        <q-route-tab to="/" label="LOGOUT" />
      </q-tabs>
    </q-header>
    <q-page-container>
      <router-view/>
    </q-page-container>
  </q-layout>
</template>

<script>

export default {
  name: 'NavigationBar',
  data() {
    return {
      left: true,
    };
  },

};
</script>

<style>
</style>
