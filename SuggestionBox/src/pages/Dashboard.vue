<template>
  <div>
    <p v-for="suggestion in suggestionDisplay" :key="suggestion.id">{{ suggestion }}</p>
    <q-btn to="/suggestion" color="primary" label="SuggestionForm"/>
  </div>
</template>

<script>
import DataService from 'src/service/data-service.js';

export default {
  name: 'Dashboard',
  data() {
    return {
      suggestionDisplay: null,
      suggestionForms: null,
    };
  },
  created() {
    (async () => {
      this.suggestionForms = DataService.getSuggestionForms();
      this.suggestionDisplay = DataService.savedForms;
      console.log(this.suggestionForms);
    })();
  },
};
// use this import to display the array from data-service
</script>

<style scoped>

</style>
