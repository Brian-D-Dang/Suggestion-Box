<template>
  <div>
    <p>Username:</p>
    <q-input square outlined v-model="cred.username" label="Username" autofocus />
    <p>Password:</p>
    <form @submit.prevent.stop="checkCred">
      <q-input
      type="password" square outlined v-model="cred.password" label="Password"
      ></q-input>
    </form>
    <q-btn
      color="primary"
      :disable="!activateButton" @click="checkCred" label="LOGIN"
    />
  </div>
</template>

<script>
import LoginInfo from 'src/service/data-service.js';

export default {
  name: 'PageIndex',
  routePath: '',
  data() {
    return {
      cred: {},
    };
  },
  methods: {
    async checkCred() {
      try {
        const checkLogin = await LoginInfo.getUser(this.cred);
        if (checkLogin) {
          this.$router.push('/home');
        }
      } catch (error) {
        alert(error);
      }
    },
  },
  computed: {
    activateButton() {
      const { username, password } = this.cred;
      return username && password;
    },
  },
};
</script>

<style scoped>
</style>
