<template>
  <div>
    <p>Username:</p>
    <q-input
      square outlined v-model="cred.username" label="Username" autofocus
    />
    <p>Password:</p>
    <form @submit.prevent.stop="checkCred">
      <q-input
      type="password" square outlined v-model="cred.password" label="Password"
      />
    </form>
    <q-btn
      color="primary"
      :disable="!activateButton" @click="checkCred" label="LOGIN"
    />
  </div>
</template>

<script>
import LoginInfo from 'src/services/data-service.js';

export default {
  name: 'PageIndex',
  routePath: '',
  data() {
    return {
      cred: {},
      // testing
    };
  },
  methods: {
    async checkCred() {
      try {
        const checkLogin = await LoginInfo.getUser(this.cred);
        if (checkLogin.data >= 1) {
          this.$router.push('/home');
          LoginInfo.setUserAccountId(checkLogin.data);
        } else {
          throw new Error();
        }
      } catch (error) {
        this.$q.notify({
          message: 'Username or password is incorrect',
          color: 'red',
        });
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
