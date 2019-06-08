<template>
  <div>
    <p class="title-size">Email:</p>
    <q-input square outlined v-model="cred.username" label="Email" />
    <p class="title-size">Password:</p>
    <q-input
      type="password" square outlined v-model="cred.password" label="Password"
    ></q-input>
    <q-btn color="primary" :disabled="!activateButton" label="LOGIN" to="/suggestion" />
  </div>
</template>

<script>
export default {
  name: 'PageIndex',
  data() {
    return {
      cred: {},
    };
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
