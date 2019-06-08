<template>
  <div>
    <p class = "title-size">Email:</p>
    <div>
      <q-input square outlined v-model="cred.username" label="Email" />
    </div>
    <p class = "title-size">Password:</p>
    <div>
      <q-input square outlined v-model="cred.password" label="Password" />
    </div>
    <q-btn color="primary" :disabled="!activate" label="LOGIN"/>
    <!-- to="/suggestion" -->
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
    activate() {
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
