<template>
  <div>
    <q-table
         style="max-width: 300px; display:block; min-width:300px;"
         title="Suggestions"
         :data="sortedDate"
         :columns="columns"
         row-key="name"
         grid
         class="column items-center"
        >
    <template #item="props">
        <q-card>
          <div class="row justify-end"><q-btn round unelevated icon="more_vert"></q-btn></div>
          <q-list dense style="min-width:1000px" class="col">
            <q-item
v-for="col in props.cols.filter(col => col.name !== 'desc')" :key="col.name">
              <q-item-section>
                <q-item-label caption>{{ col.name}}</q-item-label>
                <q-item-label>{{ col.value}}</q-item-label>
              </q-item-section>
            </q-item>
          </q-list>
        </q-card>
    </template>
       </q-table>
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
