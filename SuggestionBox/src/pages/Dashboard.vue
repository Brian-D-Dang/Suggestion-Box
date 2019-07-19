<template>
  <div>
   <div class="column row items-center justify-center">
     <div class="q-pa-md row justify-center" style="max-width: 500px">
       <q-select
         outlined
         style="min-width:230px"
         v-model='sortingList' :options="options" label="Sort" dark class="q-pr-md"/>
       <q-select
         outlined
         style="min-width:230px"
         v-model='sortingCategory' :options="Category" label="Category" dark class="q-pl-md"/>
     </div>
     <q-table
       :data="sortedDate"
       :columns="columns"
       class="text-white"
       dark
       style="max-width:1000px;"
       row-key="name"
       grid
         >
     <template #item="props">
           <q-card class="q-ma-sm bg-grey-9 col" dark  style="min-width:900px">
            <div class="float-right">
             <q-btn round unelevated icon="more_vert"></q-btn>
           </div>
            <q-list class="col">
              <q-item>
                <q-item-section>
                  <q-item-label style="font-size:25px;" class="float-left">
                    {{ props.row.name }}
                  </q-item-label>
                  <q-item-label style="font-size:25px;">{{ props.row.category }}</q-item-label>
                  <q-item-label caption class="text-white" style="font-size:20px;">
                    {{ props.row.subject }}</q-item-label>
                  <q-item-label style="font-size:15px">{{ props.row.suggestion }}</q-item-label>

                  <q-item-label caption class="text-white" style="font-size:12px">
                    Date: {{ props.row.date }}
                  </q-item-label>

                </q-item-section>
             </q-item>
            </q-list>
         </q-card>
     </template>
        </q-table>
     <q-btn to="/suggestion" color="primary" label="Suggestion Form"/>
    </div>
  </div>
</template>

<script>
import DataService from 'src/services/data-service.js';

export default {
  name: 'Dashboard',
  data() {
    return {
      data: [],
      sortingList: 'Date Descending',
      sortingCategory: 'All',
      columns: [
        {
          name: 'Category', align: 'center', label: 'Category', field: 'category',
        },
        {
          name: 'Subject', align: 'center', label: 'Subject', field: 'subject',
        },
        {
          name: 'Suggestion', align: 'center', label: 'Suggestion', field: 'suggestion',
        },
        {
          name: 'Date', align: 'center', label: 'Date', field: 'date',
        },
      ],
      suggestionForms: [],
      options: [
        'Date Descending', 'Date Ascending',
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
      if (!this.suggestionForms) {
        return this.suggestionForms;
      }
      if (this.sortingList === 'Date Ascending') {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties
        this.suggestionForms.sort((a, b) => Date.parse(a.date) - Date.parse(b.date));
      } else if (this.sortingList === 'Date Descending') {
        // eslint-disable-next-line vue/no-side-effects-in-computed-properties,radix
        this.suggestionForms.sort((a, b) => Date.parse(b.date) - Date.parse(a.date));
      }
      if (this.sortingCategory === 'All') {
        return this.suggestionForms;
      }
      return this.suggestionForms.filter(topic => topic.category === this.sortingCategory);
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
