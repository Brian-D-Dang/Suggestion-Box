export default {
  formsSent: [],
  savedForms: [],
  users: [
    {
      username: 'daddy',
      password: '12345q',
    },
    {
      username: 'dad',
      password: '1',
    },
    {
      username: 'alanIsMyDaddy',
      password: '42069',
    },
  ],
  async saveSurvey(survey, saved) {
    let formSent = false;
    console.log(this.formSent);
    if (this.formsSent.length === this.savedForms.length) {
      console.log('hello');
      this.formsSent.push(survey);
      this.savedForms.push(saved);
      formSent = true;
    }
    return formSent;
  },
  async getUser({ username }) {
    let exist = false;
    this.users.forEach(({ username: name }) => {
      if (username === name) {
        exist = true;
      }
    });
    console.log(username);
    return exist;
  },
  async getSuggestionForms() {
    return this.savedForms;
  },
};
