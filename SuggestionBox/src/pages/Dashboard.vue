<template>
  <div>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model='nothing' :options="options" label="Sort"/>
    </div>
    <p v-for="( suggestion) in suggestionForms" :key="suggestion.id">
      {{ suggestion }}
    </p>
    <q-btn to="/suggestion" color="primary" label="SuggestionForm"/>
    <p v-show="hidden">{{ sortedArray }}</p>
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
      if (this.nothing === 'Date Ascending') {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.suggestionForms.sort((a, b) => a.date - b.date);
      } else if (this.nothing === 'Date Descending') {
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
