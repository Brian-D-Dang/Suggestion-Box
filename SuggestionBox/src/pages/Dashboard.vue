<template>
  <div>
    <p v-for="suggestion in suggestionRows" :key="suggestion.id">{{ suggestion }}</p>
    <q-btn to="/suggestion" color="primary" label="SuggestionForm"/>
  </div>
</template>

<script>
import dataService from 'src/service/data-service.js';

export default {
  name: 'Dashboard',
  data() {
    return {
      suggestionRows: null,
    };
  },
  created() {
    (async () => {
      this.suggestionRows = dataService.savedForms;
      console.log(this.suggestionRows);
    })();
  },
};
// use this import to display the array from data-service
</script>

<style scoped>

</style>
