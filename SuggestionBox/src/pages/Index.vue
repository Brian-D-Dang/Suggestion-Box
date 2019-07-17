<template>
  <q-layout class="bg-grey-10 text-white">
    <div class="
    absolute-center
    column
    items-center"
    style="min-width:600px"
    >
      <img src="../statics/icons/logo.png">
      <p class="text">Suggestion Box</p>
      <q-form
        @submit="checkCred"
      >
        <q-input dark
        color="white"
        class="col q-py-lg" style="min-width:500px"
        square outlined v-model="cred.username" label="Username" autofocus
                 lazy-rules
                 :rules="[ val => val && val.length > 0 || 'Missing Username']"
      />
        <q-input dark
          color="white"
          class="col q-pb-lg" style="min-width:500px"
        type="password" square outlined v-model="cred.password" label="Password"
                 lazy-rules
                 :rules="[ val => val && val.length > 0 || 'Missing Password']"
        />
      <q-btn
        unelevated
        type="submit"
        size="17px"
        class ="col q-py-md" style="min-width:500px"
        color="brand"
        :disable="!activateButton" @click="checkCred" label="LOGIN"
      />
      </q-form>
    </div>
  </q-layout>
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
        this.cred.username = this.cred.username.toLowerCase();
        const checkLogin = await LoginInfo.getUser(this.cred);
        if (checkLogin.data.userAccountId >= 1) {
          this.$router.push('/home');
          LoginInfo.setUserAccountId(checkLogin.data.userAccountId);
          LoginInfo.setUserFirstName(checkLogin.data.firstName);
          LoginInfo.setUserLastName(checkLogin.data.lastName);
          LoginInfo.setUsername(checkLogin.data.username);
          LoginInfo.setEmail(checkLogin.data.email);
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
  .text {
    font-size:20px;
  }
  .text-brand {
    color: #41709C;
  }
  .bg-brand {
    background: #41709C;
  }
</style>
