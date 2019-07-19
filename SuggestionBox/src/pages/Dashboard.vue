<template>
  <div class="column items-center">
    <q-table
      class="q-ma-md col"
      style="min-width:1550px"
      dark
      color="red"
      title="Suggestions"
      :data="sortedDate"
      :columns="columns"
      row-key="name"
    />
    <q-btn
      class="q-ma-md col"
      to="/suggestion"
      color="brand"
      label="Create Suggestion"/>
  </div>

</template>

<script>
import DataService from 'src/services/data-service.js';

export default {
  name: 'Dashboard',
  data() {
    return {
      data: [],
      columns: [
        {
          name: 'Category', align: 'center', label: 'Category', field: 'category', sortable: true,
        },
        {
          name: 'Subject', align: 'center', label: 'Subject', field: 'subject', sortable: true,
        },
        {
          name: 'Suggestion', align: 'center', label: 'Suggestion', field: 'suggestion', sortable: true,
        },
      ],
      suggestionForms: [],
      options: [
        'Date Ascending', 'Date Descending',
      ],
      Category: [
        'All', 'Company Improvement', 'Employee Happiness', 'Other',
      ],
    };
  },
  methods: {
  },
  computed: {
    sortedDate() {
      return this.suggestionForms;
    },
  },
  created() {
    (async () => {
      const displaySuggestion = await DataService.getSuggestionForms();
      this.suggestionForms = displaySuggestion.data;
    })();
  },
};
</script>

<style scoped>
  .bg-brand {
    background: #41709C;
  }
</style>
