<template>
  <div>
    <q-btn @click="save" color="primary" :disabled="enable" label="Primary"/>
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

</style>
