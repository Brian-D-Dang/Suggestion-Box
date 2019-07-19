<template>
  <div>
   <div class="column row items-center justify-center">
     <q-table
       :data="sortedDate"
       :columns="columns"
       class="text-white"
       style="max-width:1000px"
       row-key="name"
       grid
         >
     <template #item="props">
           <q-card class="q-ma-sm bg-grey-9 col" dark  style="min-width:1000px">
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
                 <q-item-label caption style="font-size:12px">{{ props.row.date }}</q-item-label>

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
      columns: [
        {
          name: 'Category', align: 'center', label: 'Category', field: 'category',
        },
        {
          name: 'Subject', align: 'center', label: 'Subject', field: 'subject',
        },
        {
          name: 'Suggestion', label: 'Suggestion', field: 'suggestion',
        },
        {
          name: 'Date', align: 'center', label: 'Date', field: 'date',
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
