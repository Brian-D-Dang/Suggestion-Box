<template>
  <q-layout view="hHh LpR fFf" class="bg-grey-10">
    <q-header reveal elevated class="bg-grey-10 text-white">
      <q-toolbar>

        <q-toolbar-title>
          <q-btn dense flat round icon="menu" @click="left = !left" />
          <img
            src="../statics/icons/logo.png"
            style="height:50px; max-width:150px;" class="vertical-middle q-ma-sm">
        </q-toolbar-title>
      </q-toolbar>
    </q-header>
    <!--Top Nav bar with button to access tabs-->
    <q-drawer content-style="background-color:#212121;"
              v-model="left" side="left" elevated >
        <q-list dark>
          <q-item style="border-bottom: 1px solid gray">
            <q-item-section caption>
              <q-item-label caption>Signed In As</q-item-label>
              <q-item-label header class="q-pa-sm">{{ username }}</q-item-label>
              <q-item-label header class="q-pa-sm">{{ email }}</q-item-label>
            </q-item-section>
          </q-item>
          <q-item clickable v-ripple @click="Dashboard">
            <q-item-section>
              <q-item-label>Dashboard</q-item-label>
            </q-item-section>
          </q-item>
          <q-item clickable v-ripple @click="createUserAccount" v-if="checkManagerId === true">
          <q-item-section>
            <q-item-label>
              <q-item-label>Create Account</q-item-label>
            </q-item-label>
          </q-item-section>
        </q-item>
          <q-item clickable v-ripple @click="logout" >
            <q-item-section>
              <q-item-label>
                <q-item-label>Logout</q-item-label>
              </q-item-label>
            </q-item-section>
          </q-item>

        </q-list>
    </q-drawer>
    <q-page-container>
      <router-view/>
    </q-page-container>
  </q-layout>
</template>

<script>
import DataService from 'src/services/data-service.js';

export default {
  name: 'NavigationBar',
  data() {
    return {
      left: true,
      ManagerId: 0,
    };
  },
  methods: {
    Dashboard() {
      this.$router.push('/dashboard');
    },
    logout() {
      this.$router.push('/');
      DataService.resetUserInfo();
    },
    createUserAccount() {
      this.$router.push('/create-user-account');
    },
  },
  computed: {
    username() {
      return DataService.userUsername;
    },
    email() {
      return DataService.userEmail;
    },
    checkManagerId() {
      // eslint-disable-next-line vue/no-side-effects-in-computed-properties
      this.ManagerId = DataService.userManagerId;
      return this.ManagerId;
    },
  },
};
</script>

<style>
</style>
