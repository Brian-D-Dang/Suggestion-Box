<template>
  <div class="absolute-center">
    <q-card style="min-width:500px" class="column justify-start" >
      <q-card-section>Create Suggestion</q-card-section>
      <q-separator color="black" style="min-height: 1px"></q-separator>
      <q-card-section>
        <div class="q-pa-md" style="max-width: 500px">
          <q-select square outlined v-model="survey.category" :options="category" label="Category"/>
        </div>
        <br>
       <div class="q-pa-md" style="max-width: 500px">
        <q-input square outlined v-model="survey.subject" label="Subject" />
       </div>
        <br>
        <div class="q-pa-md" style="max-width: 500px">
          <form @submit.prevent.stop="save">
          <q-input
            square
            outlined
            v-model="survey.suggestion"
            label="Description" filled type="textarea" counter />
         </form>
        </div>
        <br>
          <q-btn class="block"
            @click="save" color="primary" label="Submit" :disable="!activateButton"
          />
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
      survey: {
        category: '',
        subject: '',
        suggestion: '',
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
