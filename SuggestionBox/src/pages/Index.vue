<template>
  <div>
    <p class="title-size">Email:</p>
    <q-input square outlined v-model="cred.username" label="Email" autofocus />
    <p class="title-size">Password:</p>
    <q-input
      type="password" square outlined v-model="cred.password" label="Password"
      @keyup.enter="checkCred"
    ></q-input>
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
    checkCred() {
      (async () => {
        try {
          const checkLogin = await LoginInfo.getUser(this.cred);
          if (checkLogin) {
            this.$router.push('/home');
          }
        } catch (error) {
          alert(error);
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
