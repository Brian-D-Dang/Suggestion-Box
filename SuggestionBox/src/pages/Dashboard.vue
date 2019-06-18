<template>
  <div>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model='sortingList' :options="options" label="Sort" />
    </div>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model='sortingCategory' :options="Category" label="Category" />
    </div>
    <p v-for="(suggestion) in sortedDate" :key="suggestion.id">
      {{ suggestion }}
    </p>
    <q-btn to="/suggestion" color="primary" label="SuggestionForm"/>
  </div>

</template>

<script>
import DataService from 'src/services/data-service.js';

export default {
  name: 'Dashboard',
  data() {
    return {
      suggestionForms: null,
      sortingList: null,
      sortingCategory: 'All',
      options: [
        'Date Ascending', 'Date Descending',
      ],
      Category: [
        'All', 'Company Improvement', 'Employee Happiness', 'Other',
      ],
    };
  },
  computed: {
    sortedDate() {
      if (!this.suggestionForms) {
        return this.suggestionForms;
      }
      if (this.sortingList === 'Date Ascending') {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.suggestionForms.sort((a, b) => a.date - b.date);
      } else if (this.sortingList === 'Date Descending') {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.suggestionForms.sort((a, b) => b.date - a.date);
      }
      if (this.sortingCategory === 'All') {
        return this.suggestionForms;
      }
      return this.suggestionForms.filter(topic => topic.dropDown === this.sortingCategory);
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
