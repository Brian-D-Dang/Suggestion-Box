<template>
  <div>
    <br>
    <p class="titleSize">DROPDOWN</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select outlined v-model="survey.dropDown" :options="options" label="DropDown Subjects"/>
    </div>
    <br>

    <p class="titleSize">Subject</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="survey.subject" label="Subject" />
    </div>
    <br>

    <p class="titleSize">Description</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="survey.description" label="Description" />
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
        dropDown: ' ',
        subject: ' ',
        description: ' ',
      },
      savedSurvey: {
        dropDown: ' ',
        subject: ' ',
        description: ' ',
      },
      options: [
        'Company Improvement', 'Employee Happiness', 'Other',
      ],
    };
  },
  methods: {
    save() {
      const { dropDown: dd, subject: sub, description: desc } = this.survey;
      this.savedSurvey = {
        dropDown: dd,
        subject: sub,
        description: desc,
      };
    },
  },
  computed: {
    showIt() {
      const { dropDown, subject, description } = this.savedSurvey;
      return dropDown + ' ' + subject + ' ' + description;
    },
  },
};
</script>
<style scoped>
  .titleSize {
    font-size: 20px;
  }
</style>
