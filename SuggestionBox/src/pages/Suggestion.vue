<template>
  <div>
    <br>
    <p class="title-size">Dropdown</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model="survey.dropDown" :options="options" label="DropDown Subjects"/>
    </div>
    <br>

    <p class="title-size">Subject</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="survey.subject" label="Subject" />
    </div>
    <br>

    <p class="title-size">Description</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="survey.description" label="Description" />
    </div>
    <br>
      <q-btn class="block"
        @click="save" color="primary" label="Submit" :disable="!activateButton"
      />
    <!-- to="/index"-->
  </div>
</template>

<script>
import DataService from 'src/service/data-service.js';

export default {
  name: 'Suggestion',
  data() {
    return {
      survey: {
        dropDown: '',
        subject: '',
        description: '',
      },
      options: [
        'Company Improvement', 'Employee Happiness', 'Other',
      ],
    };
  },
  methods: {
    save() {
      (async () => {
        const returnSuccessful = await DataService.saveSurvey(this.survey);
        console.log(returnSuccessful);
        this.$q.notify({
          message: 'Form sent successfully',
          color: 'primary',
        });
      })();
      this.$router.push('/dashboard');
    },
  },
  computed: {
    activateButton() {
      const { dropDown, subject, description } = this.survey;
      return dropDown && subject && description;
    },
  },
};
</script>
<style scoped>
  .title-size {
    font-size: 20px;
  }
</style>
