<template>
  <div>
       <q-table
         style="width: 1000px; display:block;"
          class="col"
          grid
          title="Suggestions"
          :data="sortedDate"
          :columns="columns"
          row-key="name"
        />
<!--    <template v-slot:item="props">-->
<!--      <div-->
<!--        class="q-pa-xs col-xs-12 col-sm-6 col-md-4 col-lg-3 grid-style-transition"-->
<!--        :style="props.selected ? 'transform: scale(0.95);' : ''"-->
<!--      >-->
<!--        <q-card :class="props.selected ? 'bg-grey-2' : ''">-->
<!--          <q-card-section>-->
<!--            <q-checkbox dense v-model="props.selected" :label="props.row.name" />-->
<!--          </q-card-section>-->
<!--          <q-separator />-->
<!--          <q-list dense>-->
<!--            <q-item
v-for="col in props.cols.filter(col => col.name !== 'desc')" :key="col.name">-->
<!--              <q-item-section>-->
<!--                <q-item-label>{{ col.label }}</q-item-label>-->
<!--              </q-item-section>-->
<!--              <q-item-section side>-->
<!--                <q-item-label caption>{{ col.value }}</q-item-label>-->
<!--              </q-item-section>-->
<!--            </q-item>-->
<!--          </q-list>-->
<!--        </q-card>-->
<!--      </div>-->
<!--    </template>-->
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
          name: 'Category',
          required: true,
          label: 'Testing',
          align: 'left',
          field: 'subject',
          sortable: true,
        },
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
