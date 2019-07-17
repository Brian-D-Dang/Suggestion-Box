<template>
  <q-layout class="bg-grey-10" view="hHh LpR fFf">

    <q-header reveal elevated class="bg-grey-10 text-white">
      <q-toolbar>

        <q-toolbar-title>
          <q-btn dense flat round icon="menu" @click="left = !left" />
          <img src="../statics/icons/logo.png" style="height:50px; max-width:150px;">
        </q-toolbar-title>
      </q-toolbar>
    </q-header>
    <!--Top Nav bar with button to access tabs-->
    <q-drawer content-style="background-color:#212121;"
              v-model="left" side="left" bordered>
      <q-tabs align="left" class="text-white">
        <q-route-tab to="/dashboard" label="Dashboard" />
        <q-route-tab to="/" label="LOGOUT" />
      </q-tabs>
      <!--drawer content and tabs -->
    </q-drawer>
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
