<template>
  <q-layout class="bg-grey-10 text-white">
    <div class="column justify-center items-center">
      <img src="../statics/icons/logo.png" class="q-pa-md">
        <q-card class="bg-grey-9 q-pa-lg column items-center">
          <q-card-section
            style="font-size:20px " class="q-mb-sm">Create User Account</q-card-section>
        <q-separator color="white" style="min-height: 1px"></q-separator>
          <q-card-section class="column justify-center">
            <q-form style="max-width: 500px;" class="row justify-center" >
            <q-input
              square
              outlined
              v-model="userAccount.username"
              lazy-rules
              :rules="[ val => val && val.length > 0 || 'Missing Username']"
              class="col-12 q-pa-md" label="Username" autofocus dark />
            <q-input
              square
              outlined
              v-model="userAccount.firstName"
              lazy-rules
              :rules="[ val => val && val.length > 0 || 'Missing First Name']"
              class="col-6 q-pa-md" label="First Name" dark />
            <q-input
              square
              outlined
              v-model="userAccount.lastName"
              lazy-rules
              :rules="[ val => val && val.length > 0 || 'Missing Last Name']"
              class="col-6 q-pa-md" label="Last Name" dark />
            <q-input
              square
              outlined
              v-model="userAccount.email"
              lazy-rules
              :rules="[ val => val && val.length > 0 || 'Missing Email']"
              class="col-12 q-pa-md" label="Email" dark />
              <q-input
                square
                outlined
                v-model="userAccount.password"
                type="password"
                lazy-rules
                :rules="[ val => val && val.length > 0 || 'Missing Password']"
                class="col-6 q-pa-md" label="Password" dark />
              <q-input
                square
                outlined
                v-model="userAccount.confirmPassword"
                type="password"
                lazy-rules
                :rules="[ val => val && val.length > 0 || 'Missing Confirm Password']"
                class="col-6 q-pa-md"
                label="Confirm Password" dark />
              <div class="col-12 q-pa-md">
                <q-checkbox
                  class="q-pb-lg"
                  color="brand" v-model="userAccount.manager" label="Manager" dark>
                </q-checkbox>
              <q-btn
                color="brand"
                @click="createUserAccount"
                type="submit"
                class="q-pa-md full-width"
                size="20px"
                label="SIGN UP"></q-btn>
            </div>
              <q-btn
                flat
                to="/home"
                size="10px"
                style="min-width:100px"
                class="q-pa-xs q-mt-xs" label="cancel" color="red" />
          </q-form>

         </q-card-section>
        </q-card>
      </div>
  </q-layout>
</template>

<script>
import DataService from 'src/services/data-service.js';

export default {
  name: 'CreateUserAccount',
  data() {
    return {
      // eslint-disable-next-line no-useless-escape
      mailformat: /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/,
      userAccount: {
        username: '',
        password: '',
        confirmPassword: '',
        firstName: '',
        lastName: '',
        email: '',
        manager: false,
      },
    };
  },
  methods: {
    async createUserAccount() {
      try {
        if ((this.userAccount.password === this.userAccount.confirmPassword)
          && (this.userAccount.email.match(this.mailformat))) {
          console.log(this.userAccount.manager);
          await DataService.createUser(this.userAccount);
          this.$router.push('/home');
          this.$q.notify({
            message: 'Account was created successfully',
            color: 'green',
          });
        } else {
          throw new Error();
        }
      } catch (error) {
        this.$q.notify({
          message: 'Account was not created successfully',
          color: 'red',
        });
      }
    },
  },
};
</script>

<style scoped>

</style>
