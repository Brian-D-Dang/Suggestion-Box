<template>
  <div>
    <q-input v-model="text" label="Standard" />
    <q-layout view="lHh Lpr lFf">
      <q-page-container>
        <router-view />
      </q-page-container>
    </q-layout>
  </div>

</template>

<script>
export default {
  name: 'MyLayout',
  data() {
    return {
      text: '',
    };
  },
};
</script>

<style>
</style>
