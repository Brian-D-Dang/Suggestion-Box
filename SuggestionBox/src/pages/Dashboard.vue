<template>
  <div>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model='sortingList' :options="options" label="Sort" />
    </div>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model='sortingCategory' :options="Category" label="Category" />
    </div>
    <q-table
      title="Treats"
      :data="sortedDate"
      :columns="columns"
      row-key="name"
    />
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
      sortingList: null,
      sortingCategory: 'All',
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
    // async sortedDate() {
    //   const hello = await DataService.getSuggestionForms();
    //   this.suggestionForms = hello.data;
    //   console.log(this.suggestionForms);
    //   const what = this.suggestionForms;
    //   return what;
    // },
  },
  computed: {
    sortedDate() {
      return this.suggestionForms;
    },
    //   if (!this.suggestionForms) {
    //     return this.suggestionForms;
    //   }
    //   if (this.sortingList === 'Date Ascending') {
    //     // eslint-disable-next-line vue/no-side-effects-in-computed-properties
    //     this.suggestionForms.sort((a, b) => a.date - b.date);
    //   } else if (this.sortingList === 'Date Descending') {
    //     // eslint-disable-next-line vue/no-side-effects-in-computed-properties
    //     this.suggestionForms.sort((a, b) => b.date - a.date);
    //   }
    //   if (this.sortingCategory === 'All') {
    //     return this.suggestionForms;
    //   }
    //   return this.suggestionForms.filter(topic => topic.category === this.sortingCategory);
    // },
  },
  created() {
    (async () => {
      const hello = await DataService.getSuggestionForms();
      this.suggestionForms = hello.data;
      return JSON.stringify(this.suggestionForms);
    })();
  },
};
</script>

<style scoped>
</style>
