<template>
   <div class="row justify-center items-center">
     <suggestion class="col-lg-6 col-xl-5"></suggestion>

     <div class="column items-center col-lg-5 col-xl-6  ">
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
         :rows-per-page-options="[0]"
         class="text-white"
         dark
         row-key="name"
         grid
       >
         <template #item="props">
           <q-card class="q-ma-sm bg-grey-9 col" dark  style="min-width:500px">
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
         </div>
       </div>

</template>

<script>
import DataService from 'src/services/data-service.js';
import Suggestion from './Suggestion';

export default {
  name: 'Dashboard',
  components: { Suggestion },
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
    async refreshSuggestions() {
      const displaySuggestion = await DataService.getSuggestionForms();
      this.suggestionForms = displaySuggestion.data;
    },
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
    this.refreshSuggestions();
    this.$root.$on('added-suggestion', this.refreshSuggestions);
  },
  beforeDestroy() {
    this.$root.$off('added-suggestion');
  },
};

</script>

<style scoped>
  .bg-brand {
    background: #41709C;
  }
</style>
