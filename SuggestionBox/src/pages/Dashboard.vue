<template>
  <div>
    <q-card class="row justify-start">
      <q-card-section class="bg-cyan" style="min-width:1000px">
        "hello"
      </q-card-section>
      <q-card-section>
       <q-table
         style="width: 1000px; display:block;"
          class="col"
          grid
          title="Suggestions"
          :data="sortedDate"
          :columns="columns"
          row-key="name"
        />
        </q-card-section>
    </q-card>
    <q-btn to="/suggestion" color="primary" label="Suggestion Form"/>

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
</style>
