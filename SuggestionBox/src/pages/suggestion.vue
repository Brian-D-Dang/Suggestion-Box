<template>
  <div>
    <br>
    <p class = "titleSize">DROPDOWN</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-select  outlined v-model="DROPDOWN" :options="options" label="DropDown Subjects"/>
    </div>
    <br>

    <p class = "titleSize">Subject</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="SUBJECT" label="Subject" />
    </div>
    <br>

    <p class = "titleSize">Description</p>
    <div class="q-pa-md" style="max-width: 300px">
      <q-input square outlined v-model="DESCRIPTION" label="Description" />
    </div>
    <br>
    <div><q-btn @click = "save" color="primary" label="Primary"/></div>
    <!-- to = "/index"-->
    <p> {{ showit }} </p>
  </div>
</template>

<script>
export default {
  name: 'suggestion',
  data() {
    return {
      DROPDOWN: '',
      SUBJECT: ' ',
      DESCRIPTION: ' ',
      savedDROPDOWN: ' ',
      savedSUBJECT: ' ',
      savedDESCRIPTION: ' ',
      options: [
        'Company Improvement', 'Employee Happiness', 'Other',
      ],
    };
  },
  methods: {
    save() {
      this.savedDROPDOWN = this.DROPDOWN;
      this.savedSUBJECT = this.SUBJECT;
      this.savedDESCRIPTION = this.DESCRIPTION;
    },
  },
  computed: {
    showit() {
      return this.savedDROPDOWN + ' ' + this.savedSUBJECT + ' ' + this.savedDESCRIPTION;
    },
  },
};
</script>
<style scoped>
  .titleSize {
    font-size: 20px;
  }
</style>
