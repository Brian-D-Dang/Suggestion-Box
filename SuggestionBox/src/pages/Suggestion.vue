<template>
  <div  >
<!--  class="row column justify-center items-center"  -->
    <q-card class="column items-center bg-grey-9 q-ma-md" dark>
      <q-card-section class="col">
        Create Suggestion
      </q-card-section>
      <q-separator color="white" style="min-height:1px"></q-separator>
      <q-card-section>
        <q-form>
        <div class="q-pa-md col" style="min-width: 500px">
          <q-select
            square
            outlined v-model="survey.category" :options="category" label="Category" dark/>
        </div>
       <div class="q-pa-md col" style="min-width: 500px">
        <q-input square outlined v-model="survey.subject" label="Subject" dark/>
       </div>
        <div class="q-pa-md col" style="min-width: 500px">
          <q-checkbox class="q-pb-lg"
            color="brand" v-model="postAnonymously" label="Post Anonymously" dark>
          </q-checkbox>
          <q-input
            dark
            square
            outlined
            v-model="survey.suggestion"
            label="Description" filled type="textarea" counter maxlength="64"/>
        </div>
        <br>
          <q-btn color="brand" class="block q-mx-md q-mb-md" size="20px" style="min-width:500px"
           type="submit" @click="save"  label="Submit" :disable="!activateButton"
          />
        </q-form>
      </q-card-section>
    </q-card>
  </div>
</template>

<script>
import DataService from 'src/services/data-service.js';

export default {
  name: 'Suggestion',
  data() {
    return {
      postAnonymously: false,
      survey: {
        category: '',
        subject: '',
        suggestion: '',
        // postAnonymously: this.postAnonymously,
      },
      category: [
        'Company Improvement', 'Employee Happiness', 'Other',
      ],
    };
  },
  methods: {
    async save() {
      try {
        const suggestionCheck = await DataService.saveSurvey(this.survey);
        if (suggestionCheck) {
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
  },
  computed: {
    activateButton() {
      const { category, subject, suggestion } = this.survey;
      return category && subject && suggestion;
    },
  },
};
</script>
<style scoped>
</style>
