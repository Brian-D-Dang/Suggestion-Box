export default {
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
  async saveSurvey(saved) {
    const theDate = new Date();
    const { category, subject, description } = saved;
    const copy = Object.assign({}, {
      category, subject, description, date: theDate,
    });
    this.savedForms.push(copy);
    return this.savedForms;
  },
  async getUser(userExist) {
    const exist = this.users.some(user => (
      (userExist.username === user.username) && (userExist.password === user.password)
    ));
    if (!exist) {
      throw new Error('Incorrect username or password');
    }
    return exist;
  },
  async getSuggestionForms() {
    return this.savedForms;
  },
};
