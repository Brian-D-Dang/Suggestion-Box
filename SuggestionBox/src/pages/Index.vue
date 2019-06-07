<template>
  <div>
    <div>
      <q-btn @click = "save" color="primary" v-bind:disabled="enable" label="Primary"/>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PageIndex',
  data() {
    return {
      enable: true,
      message: 'Hello',
    };
  },
};
</script>

<style scoped>
  [v-cloak] {
    display: none;
  }
</style>
