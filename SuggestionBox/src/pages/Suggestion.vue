<template>
  <div>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model="survey.category" :options="category" label="Category"/>
    </div>
    <br>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="survey.subject" label="Subject" />
    </div>
    <br>
    <div class="q-pa-md" style="max-width: 300px">
      <form @submit.prevent.stop="save">
      <q-input square outlined v-model="survey.suggestion" label="Description" />
      </form>
    </div>
    <br>
      <q-btn class="block"
        @click="save" color="primary" label="Submit" :disable="!activateButton"
      />
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
        } else {
          throw this.$q.notify({
            message: 'Form sent successfully',
            color: 'primary',
          });
        }
      } catch (error) {
        this.$q.notify(error);
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
