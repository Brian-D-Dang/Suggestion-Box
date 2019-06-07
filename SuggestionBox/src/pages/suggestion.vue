<template>
  <div>
    <br>
    <p class="titleSize">DROPDOWN</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model="survey.DROPDOWN" :options="options" label="DropDown Subjects"/>
    </div>
    <br>

    <p class="titleSize">Subject</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="survey.SUBJECT" label="Subject" />
    </div>
    <br>

    <p class="titleSize">Description</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="survey.DESCRIPTION" label="Description" />
    </div>
    <br>
    <div><q-btn @click="save" color="primary" label="Primary"/></div>
    <!-- to="/index"-->
    <p> {{ showIt }} </p>
  </div>
</template>

<script>
export default {
  name: 'Suggestion',
  data() {
    return {
      survey: {
        DROPDOWN: '',
        SUBJECT: ' ',
        DESCRIPTION: ' ',
      },
      savedSurvey: {
        savedDROPDOWN: ' ',
        savedSUBJECT: ' ',
        savedDESCRIPTION: ' ',
      },
      options: [
        'Company Improvement', 'Employee Happiness', 'Other',
      ],
    };
  },
  methods: {
    save() {
      this.savedSurvey.savedDROPDOWN = this.survey.DROPDOWN;
      this.savedSurvey.savedSUBJECT = this.survey.SUBJECT;
      this.savedSurvey.savedDESCRIPTION = this.survey.DESCRIPTION;
    },
  },
  computed: {
    showIt() {
      const { savedDROPDOWN, savedSUBJECT, savedDESCRIPTION } = this.savedSurvey;
      return savedDROPDOWN + ' ' + savedSUBJECT + ' ' + savedDESCRIPTION;
    },
  },
};
</script>
<style scoped>
  .titleSize {
    font-size: 20px;
  }
</style>
