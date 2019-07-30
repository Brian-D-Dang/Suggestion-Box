<template>
  <div>
    <div class="row justify-center items-center">
      <suggestion class="col-lg-6 col-xl-5"></suggestion>
      <q-dialog
        v-model="display"
        class="row q-pa-xl">
        <q-card
          class="column col-5 bg-grey-9 items-center"
          dark>
          <q-card-section class="col">
            EDIT SUGGESTION
          </q-card-section>
          <q-separator color="white" style="min-height:1px"></q-separator>
          <q-card-section>
            <q-form>
              <div class="q-pa-md col" style="min-width: 500px">
                <q-select
                  square
                  outlined
                  v-model="editSurvey.category"
                  :options="editCategory" label="Category" dark/>
              </div>
              <div class="q-pa-md col" style="min-width: 500px">
                <q-input
                  square
                  outlined
                  v-model="editSurvey.subject" label="Subject" dark/>
              </div>
              <div class="q-pa-md col" style="min-width: 500px">
                <q-checkbox
                  class="q-pb-lg"
                  color="brand"
                  v-model="postAnonymously" label="Post Anonymously" dark>
                </q-checkbox>
                <q-input
                  dark
                  square
                  outlined
                  v-model="editSurvey.suggestion"
                  label="Description"
                  filled type="textarea" counter maxlength="64"/>
              </div>
              <br>
              <q-btn
                color="brand"
                class="block q-mx-md q-mb-md"
                size="20px"
                style="min-width:500px"
                type="submit"
                @click="updateSuggestion"
                label="Submit" :disable="!activateButton"
              />
            </q-form>
          </q-card-section>
        </q-card>
      </q-dialog>

     <div class="column items-center col-lg-5 col-xl-6  ">
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
       <q-card class="q-ma-sm bg-grey-9 col" dark  style="min-width:900px">
        <div
          class="float-right"
          v-if="props.row.userAccountId === editSurvey.userAccountId"
          >
           <q-icon
             class="q-ma-sm"
             size="25px"
             name="more_vert">
             <q-menu auto-close>
               <q-list>
                 <q-item>
                   <q-item-section class="column items-center">
                     <q-btn label="EDIT" @click="displayEditSuggestion(props.row)" flat>
                     </q-btn>
                   </q-item-section>
                 </q-item>
                 <q-item>
                   <q-item-section>
                     <q-btn>DELETE</q-btn>
                   </q-item-section>
                 </q-item>
               </q-list>
             </q-menu>
           </q-icon>
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
    <q-btn
      class="q-ma-md col"
      to="/suggestion"
      color="brand"
      label="Create Suggestion"/>
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
      postAnonymously: false,
      display: false,
      editSurvey: {
        category: '',
        subject: '',
        suggestion: '',
        userAccountId: DataService.saveAccountId,
        suggestionId: 0,
        // postAnonymously: this.postAnonymously,
      },
      editCategory: [
        'Company Improvement', 'Employee Happiness', 'Other',
      ],
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
        {
          name: 'Suggestion Id', align: 'center', label: 'Suggestion Id', field: 'suggestionId',
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
    displayEditSuggestion(saveProps) {
      this.display = true;
      this.editSurvey.suggestionId = saveProps.suggestionId;
    },
    async updateSuggestion() {
      try {
        const updateCheck = await DataService.updateSuggestion(this.editSurvey);
        if (updateCheck) {
          this.$q.notify({
            message: 'Form sent successfully',
            color: 'primary',
          });
          this.$router.push('/dashboard');
        }
      } catch (error) {
        this.$q.notify({
          message: 'Form did not send successfully',
          color: 'red',
        });
      }
    },
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
    activateButton() {
      const { category, subject, suggestion } = this.editSurvey;
      return category && subject && suggestion;
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
