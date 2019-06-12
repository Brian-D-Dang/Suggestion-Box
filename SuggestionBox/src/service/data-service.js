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

  async getUser(usersExist) {
    let exist = false;
    this.users.forEach((user) => {
      if (usersExist.username === user.username) {
        exist = true;
      }
    });
    console.log(usersExist);
    return exist;
  },
  async getSuggestionForms() {
    return this.savedForms;
  },
};
