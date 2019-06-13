<template>
  <div>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model='sortingList' :options="options" label="Sort"/>
    </div>
    <p v-for="(suggestion) in sortedArray" :key="suggestion.id">
      {{ suggestion }}
    </p>

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
      sortingList: null,
      options: [
        'Date Ascending', 'Date Descending',
      ],
    };
  },
  computed: {
    sortedArray() {
      if (this.sortingList === 'Date Ascending') {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.suggestionForms.sort((a, b) => a.date - b.date);
      } else if (this.sortingList === 'Date Descending') {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.suggestionForms.sort((a, b) => b.date - a.date);
      }
      return this.suggestionForms;
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
