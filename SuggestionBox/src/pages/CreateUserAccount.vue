<template>
  <q-layout class="bg-grey-10 text-white">
    <div class="column justify-center items-center">
        <q-card class="bg-grey-9 q-ma-lg column items-center" style="width:600px">
          <q-card-section
            style="font-size:20px " class="q-mb-sm">Create User Account</q-card-section>
          <q-separator color="white" style="min-height: 1px"></q-separator>
            <q-card-section class="column justify-center">
              <q-form style="max-width: 500px;" class="row justify-center" >
              <q-input
                dark
                square
                outlined
                v-model="userAccount.username"
                lazy-rules
                color="white"
                :rules="[ val => val && val.length > 0 || 'Missing Username']"
                class="col-12 q-pa-md" label="Username" autofocus />
              <q-input
                dark
                square
                outlined
                v-model="userAccount.firstName"
                lazy-rules
                color="white"
                :rules="[ val => val && val.length > 0 || 'Missing First Name']"
                class="col-6 q-pa-md" label="First Name" />
              <q-input
                dark
                square
                outlined
                v-model="userAccount.lastName"
                lazy-rules
                color="white"
                :rules="[ val => val && val.length > 0 || 'Missing Last Name']"
                class="col-6 q-pa-md" label="Last Name" />
              <q-input
                dark
                square
                outlined
                v-model="userAccount.email"
                type="email"
                lazy-rules
                color="white"
                :rules="[ val => val && val.length > 0 || 'Missing Email']"
                class="col-12 q-pa-md" label="Email" />
                <q-input
                  dark
                  square
                  outlined
                  v-model="userAccount.password"
                  type="password"
                  lazy-rules
                  color="white"
                  :rules="[ val => val && val.length > 0 || 'Missing Password']"
                  class="col-6 q-pa-md" label="Password"/>
                  <q-input
                    dark
                    square
                    outlined
                    v-model="userAccount.confirmPassword"
                    type="password"
                    lazy-rules
                    color="white"
                    :rules="[ val => val && val.length > 0 || 'Missing Confirm Password']"
                    class="col-6 q-pa-md" label="Confirm Password"
                    />

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
                label="SIGN UP"
                :disable="!activateButton"></q-btn>
            </div>
              <q-btn
                flat
                to="/home"
                size="10px"
                style="min-width:100px"
                class="q-pa-xs q-mt-xs"
                label="cancel"
                color="white"
                />
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
      },
    };
  },
  methods: {
    async createUserAccount() {
      try {
        if ((this.userAccount.password === this.userAccount.confirmPassword)
          && (this.userAccount.email.match(this.mailformat))) {
          console.log('work');
          const check = await DataService.createUser(this.userAccount);
          if (check) {
            this.$router.push('/home');
            this.$q.notify({
              message: 'Account was created successfully',
              color: 'green-10',
            });
          }
        } else if (!(this.userAccount.password === this.userAccount.confirmPassword)
          && (!this.userAccount.email.match(this.mailformat))) {
          this.$q.notify({
            message: 'Invalid password and email',
            color: 'red-9',
          });
        } else if (!(this.userAccount.password === this.userAccount.confirmPassword)) {
          this.$q.notify({
            message: 'Invalid password',
            color: 'red-9',
          });
        } else {
          this.$q.notify({
            message: 'Invalid email',
            color: 'red-9',
          });
        }
      } catch (error) {
        this.$q.notify({
          message: error.response.data.message,
          color: 'red-9',
        });
      }
    },
  },
  computed: {
    length() {
      return this.userAccount.confirmPassword.length > 0;
    },
    activateButton() {
      const {
        username,
        password,
        confirmPassword,
        firstName,
        lastName,
        email,
      } = this.userAccount;
      return username && password && confirmPassword && firstName && lastName && email;
    },
  },
};
</script>

<style scoped>
</style>
