<template>
  <q-layout class="bg-grey-10 text-white">
    <q-card
      class="
        bg-grey-9
        absolute-center
        column
        justify-center
        items-center"
        style="min-width:600px; height:500px"
    >
      <div>
        <q-card-section
        class="column items-center col-3">
        <img src="../statics/icons/logo.png">
        <p class="text">SUGGESTION BOX</p>

      </q-card-section></div>

      <q-separator color="white" style="max-height: 1px"></q-separator>
      <q-card-section>
      <q-form style="min-width:500px">
        <q-input dark
        color="white"
        class="col q-py-lg full-width"
        square outlined v-model="cred.username" label="Username" autofocus
        lazy-rules
        :rules="[ val => val && val.length > 0 || 'Missing Username']"
      />
        <q-input dark
          color="white"
          class="col q-pb-lg full-width"
          type="password" square outlined v-model="cred.password" label="Password"
          lazy-rules
          :rules="[ val => val && val.length > 0 || 'Missing Password']"
        />

      <q-btn
        unelevated
        type="submit"
        size="17px"
        class ="col q-py-md full-width"
        color="brand"
        :disable="!activateButton" @click="checkCred" label="LOGIN"
      />
      </q-form>
      </q-card-section>
    </q-card>
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
          LoginInfo.setUserInfo(checkLogin.data);
        } else {
          throw new Error();
        }
      } catch (error) {
        this.$q.notify({
          message: 'Username or password is incorrect',
          color: 'red-9',
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
</style>
