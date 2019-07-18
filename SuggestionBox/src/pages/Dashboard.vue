<template>
  <div>
    <q-table
         style="max-width: 1020px; display:block; min-width:1020px; font-size:50px;"
         :data="sortedDate"
         :columns="columns"
         row-key="name"
         grid
         class="column"
        >
    <template #item="props">
        <q-card class="q-ma-sm">
          <div class="row float-right">
            <q-btn round unelevated icon="more_vert"></q-btn>
          </div>
          <q-list style="min-width:1000px" class="col">
            <q-item>
              <q-item-section>
                <q-item-label style="font-size:25px;" class="float-left">
                  {{ props.row.name }}</q-item-label>
                <q-item-label style="font-size:25px;">
                  {{ props.row.category }}</q-item-label>
                <q-item-label caption style="font-size:20px;">{{ props.row.subject }}</q-item-label>
                <q-item-label style="font-size:15px">{{ props.row.suggestion }}</q-item-label>
                <q-item-label caption style="font-size:12px">{{ props.row.date }}</q-item-label>

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
          name: 'Suggestion', label: 'Suggestion', field: 'suggestion', sortable: true,
        },
        {
          name: 'Date', align: 'center', label: 'Date', field: 'date', sortable: true,
        },
      ],
      suggestionForms: [],
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
