<template>
  <div>
    <p v-for="suggestion in suggestionForms" :key="suggestion.id">{{ suggestion }}</p>
    <q-btn to="/suggestion" color="primary" label="SuggestionForm"/>
  </div>
</template>

<script>
import DataService from 'src/service/data-service.js';

export default {
  name: 'Dashboard',
  data() {
    return {
      suggestionForms: null,
    };
  },
  created() {
    (async () => {
      this.suggestionForms = await DataService.getSuggestionForms();
      console.log(this.suggestionForms);
    })();
  },
};
</script>

<style scoped>

</style>
