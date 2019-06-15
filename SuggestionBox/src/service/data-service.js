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
    const { dropDown, subject, description } = saved;
    const copy = Object.assign({}, {
      dropDown, subject, description, date: theDate,
    });
    this.savedForms.push(copy);
    return this.savedForms;
  },
  // async getUser({ username }) {
  // let exist = false;
  // this.users.forEach(({ username: name }) => {
  //   if (username === name) {
  //     exist = true;
  //   }
  // });
  async getUser(userExist) {
    let exist = false;
    this.users.forEach((user) => {
      if ((userExist.username === user.username) && (userExist.password === user.password)) {
        exist = true;
      }
    });
    if (!exist) {
      throw new Error('Incorrect username or password');
    }
    return exist;
  },
  async getSuggestionForms() {
    return this.savedForms;
  },
};
