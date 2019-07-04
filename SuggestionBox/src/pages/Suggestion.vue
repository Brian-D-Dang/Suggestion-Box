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
      <q-input square outlined v-model="survey.description" label="Description" />
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
        description: '',
      },
      category: [
        'Company Improvement', 'Employee Happiness', 'Other',
      ],
    };
  },
  methods: {
    async save() {
      await DataService.saveSurvey(this.survey);
      try {
        if (DataService.saveSurvey) {
          this.$q.notify({
            message: 'Form sent successfully',
            color: 'primary',
          });
          this.$router.push('/dashboard');
        }
        if (!DataService.saveSurvey) {
          throw new Error('Survey did not send correctly.');
        }
      } catch (error) {
        // eslint-disable-next-line no-alert
        alert(error.message);
      }
    },
  },
  computed: {
    activateButton() {
      const { category, subject, description } = this.survey;
      return category && subject && description;
    },
  },
};
</script>
<style scoped>
</style>
