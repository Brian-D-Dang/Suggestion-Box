<template>
  <div>
    <p class="title-size">Email:</p>
    <q-input square outlined v-model="cred.username" label="Email" />
    <p class="title-size">Password:</p>
    <q-input
      type="password" square outlined v-model="cred.password" label="Password"
    ></q-input>
    <q-btn
      color="primary"
      :disable="!activateButton" @click="checkCred" label="LOGIN"
    />
  </div>
</template>

<script>
import loginInfo from 'src/service/data-service.js';

export default {
  name: 'PageIndex',
  routePath: '',
  data() {
    return {
      cred: {},
      test: null,
    };
  },
  methods: {
    checkCred() {
      (async () => {
        console.log(this.cred);
        const checkLogin = await loginInfo.getUser(this.cred);
        console.log(checkLogin);
        if (checkLogin) {
          this.$router.push('/home');
        } else {
          alert('Incorrect username or password');
        }
      })();
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
  .title-size {
    font-size: 20px;
  }
</style>
