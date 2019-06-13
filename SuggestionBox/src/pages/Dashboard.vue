<template>
  <div>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model='nothing' :options="options" label="Sort"/>
    </div>
    <p v-for="(i, suggestion) in suggestionForms" :key="suggestion.id">
      {{ i }}  {{ suggestion }}
    </p>
    <q-btn to="/suggestion" color="primary" label="SuggestionForm"/>
    {{ sortedArray }}
  </div>
</template>

<script>
import DataService from 'src/service/data-service.js';

export default {
  name: 'Dashboard',
  data() {
    return {
      test: [
        3,
        1,
        2,
      ],
      suggestionForms: null,
      nothing: null,
      options: [
        'Date Ascending', 'Date Descending',
      ],
    };
  },
  computed: {
    sortedArray() {
      function hello(a, b) {
        if (a.name < b.name) {
          return -1;
        }
        if (a.name > b.name) {
          return 1;
        }
        return 0;
      }
      return this.arrays.sort(compare);
    },
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
