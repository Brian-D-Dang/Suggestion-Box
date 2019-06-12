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
