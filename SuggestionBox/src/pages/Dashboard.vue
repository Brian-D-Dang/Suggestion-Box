<template>
  <div>
    <div class="row justify-center items-center">
      <div class="row col-12">
        <div class="offset-xl-6 offset-lg-6"></div>
        <div class="col-xl-5 col-lg-6">
          <div class="col-xl-6 q-pa-md row justify-center">
            <q-select
            outlined
            style="min-width:230px"
            v-model='sortingList' :options="options" label="Sort" dark class="q-pr-md"/>
            <q-select
              outlined
              style="min-width:230px"
              v-model='sortingCategory' :options="Category" label="Category" dark class="q-pl-md"/>
          </div>
        </div>
      </div>

      <q-dialog
      v-model="displayDelete">
        <q-card style="color:white" class="column items-center bg-grey-9">
          <q-card-section style="color:#fc3236">
            WARNING
          </q-card-section>
          <q-card-section>
            Are you sure you want to DELETE this suggestion?
          </q-card-section>
        <q-card-actions align="right">
          <q-btn label="Cancel" color="brand" v-close-popup />
          <q-btn
            label="Delete"
            color="brand" @click="sendDelete(deleteThisProp)" v-close-popup />
        </q-card-actions>
        </q-card>
      </q-dialog>
      <q-dialog
        v-model="displayEdit"
        class="row q-pa-xl">
        <q-card
          class="bg-grey-9"
          dark>
            <q-card-section class="row justify-end">
              <p class="q-ma-sm float-left col-6">EDIT SUGGESTION</p>
              <q-btn
                flat
                round
                class="float-right col-1"
                size="15px"
                icon="clear"
              @click="displayEdit = false"></q-btn>
          </q-card-section>

          <q-separator
            color="white" style="min-height:1px">
          </q-separator>
          <q-card-section class="column col-6 bg-grey-9 items-center">
            <q-form>
              <div class="q-pa-md col" style="min-width: 520px">
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

     <div class="col-12 row justify-center">
       <div class="col-lg-6 col-xl-5"><suggestion class="q-mx-sm"></suggestion></div>
       <div class="col-lg-6 col-xl-6">
         <q-table
         :data="sortedDate"
         :columns="columns"
         :rows-per-page-options="[0]"
         class="text-white"
         dark
         style="height:0px"
         row-key="name"
         grid
          >
         <template #item="props">
           <q-card class="q-mb-sm q-mx-sm bg-grey-9 col" dark  style="min-width:500px">
             <div
               class="float-right"
             >
               <q-btn
                 flat
                 round
                 class="q-ma-sm"
                 size="12px"
                 icon="more_vert"
                 :text-color="displayYourSuggestion(props.row)"
                 v-if="showEditSuggestion(displayYourSuggestion(props.row))"
               >
                 <q-menu auto-close >
                   <q-list
                     style="min-width:115px">
                     <q-item clickable v-if="checkManagerId">
                       IMPLEMENT
                     </q-item>
                     <q-item clickable v-if="checkManagerId">
                       DENY
                     </q-item>
                     <q-item
                     clickable
                     @click="displayEditSuggestion(props.row)"
                     v-if="props.row.userAccountId === editSurvey.userAccountId">
                       EDIT
                     </q-item>
                     <q-item
                     clickable
                     v-if="props.row.userAccountId === editSurvey.userAccountId">
                       DELETE
                     </q-item>
                   </q-list>
                 </q-menu>
               </q-btn>
             </div>
             <q-list class="col">
               <q-item>
                 <q-item-section>
                   <q-item-label style="font-size:25px;">
                    {{ props.row.subject }
                   }</q-item-label>
                   <q-item-label caption class="text-white" style="font-size:20px;">
                    {{ props.row.category }}
                   </q-item-label>
                   <q-item-label style="font-size:15px">
                    {{ props.row.suggestion }}
                   </q-item-label>
                   <q-item-label caption class="text-white" style="font-size:12px">
                     Created Date: {{ props.row.date }}
                   </q-item-label>
                 </q-item-section>
               </q-item>
             </q-list>
           </q-card>
         </template>
       </q-table>
       </div>
     </div>
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
      displayEdit: false,
      displayDelete: false,
      deleteThisProp: null,
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
    showEditSuggestion(trueFalse) {
      let display = false;
      if ((trueFalse === 'white') || (trueFalse === 'blue')) {
        display = true;
      } else if (trueFalse === 'grey') {
        display = false;
      }
      return display;
    },
    displayYourSuggestion(saveProps) {
      let color = 'grey';
      if (DataService.userManagerId) {
        if (DataService.saveAccountId === saveProps.userAccountId) {
          color = 'blue';
        } else {
          color = 'white';
        }
      } else if (DataService.saveAccountId === saveProps.userAccountId) {
        color = 'white';
      }
      return color;
    displayDeleteSuggestion(saveProps) {
      this.displayDelete = true;
      this.deleteThisProp = saveProps;
    },
    displayEditSuggestion(saveProps) {
      this.displayEdit = true;
      this.editSurvey.suggestionId = saveProps.suggestionId;
      this.editSurvey.category = saveProps.category;
      this.editSurvey.subject = saveProps.subject;
      this.editSurvey.suggestion = saveProps.suggestion;
    },
    async sendDelete(saveProps) {
      try {
        const deleteSuggestion = await DataService.deleteSuggestion(saveProps);
        if (deleteSuggestion) {
          this.$q.notify({
            message: 'Suggestion Deleted',
            color: 'green',
          });
          this.refreshSuggestions();
        }
      } catch (error) {
        this.$q.notify({
          message: 'Delete error',
          color: 'red-9',
        });
      }
    },
    async updateSuggestion() {
      try {
        this.displayEdit = false;
        const updateCheck = await DataService.updateSuggestion(this.editSurvey);
        if (updateCheck) {
          this.$q.notify({
            message: 'Form updated successfully',
            color: 'primary',
          });
          this.$router.push('/dashboard');
          this.refreshSuggestions();
        }
      } catch (error) {
        this.$q.notify({
          message: 'Form did not update successfully',
          color: 'red-9',
        });
      }
    },
    async refreshSuggestions() {
      const displaySuggestion = await DataService.getSuggestionForms();
      this.suggestionForms = displaySuggestion.data;
    },
  },
  computed: {
    checkManagerId() {
      return DataService.userManagerId;
    },
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
    this.$root.$on('refresh', this.refreshSuggestions);
    this.displayYourSuggestion();
  },
  beforeDestroy() {
    this.$root.$off('refresh');
  },
};
</script>

<style scoped>
  .bg-brand {
    background: #41709C;
  }
</style>
