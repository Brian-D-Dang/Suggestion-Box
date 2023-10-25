<template>
    <q-card class="column items-center bg-grey-9" dark>
      <q-card-section class="col">
<!--        BRIAN testing-->
        <slot name="suggestion-type" />
        Create Suggestion
      </q-card-section>
      <q-separator color="white" style="min-height:1px"></q-separator>
      <q-form>
        <q-card-section class="row" style="width: 600px">
        <div class="q-pa-md col-12">
          <q-input square outlined color="white" v-model="survey.subject" label="Subject" dark/>
        </div>
        <div class="q-pa-md col-12">
          <q-select
            square
            outlined
            color="white"
            v-model="survey.category"
            :options="category"
            label="Category" dark/>
        </div>
        <div class="q-pa-md col-12">
          <q-input
            dark
            square
            outlined
            color="white"
            :v-model="editSurvey != null ? survey.suggestion : editSurvey.suggestion"
            label="Description" filled type="textarea" counter maxlength="64"/>
          <q-btn
            color="brand"
            class="block full-width q-ma-md"
            size="20px"
            type="submit" @click="save" label="Submit" :disable="!activateButton"
          />
        </div>
        </q-card-section>
      </q-form>
    </q-card>
</template>

<script>
import DataService from 'src/services/data-service.js';

export default {
  name: 'Suggestion',
  props: {
    editSurvey: {
      type: Object,
      default() {
        return null;
      },
    },
  },
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
            color: 'green-10',
          });
          this.survey.category = '';
          this.survey.subject = '';
          this.survey.suggestion = '';
        }
        this.$root.$emit('refresh');
      } catch (error) {
        this.$q.notify({
          message: 'Form did not send successfully',
          color: 'red-9',
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
