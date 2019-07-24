import { axiosInstance } from 'src/boot/axios.js';

export default {
  savedForms: null,
  saveAccountId: 0,
  userUsername: null,
  userEmail: null,
  userFirstName: null,
  userLastName: null,
  userManagerId: 0,
  async createUser(createUserCred) {
    return axiosInstance.post('/User/createUserAccount', createUserCred)
      .then(response => response);
  },
  async saveSurvey(saved) {
    const { category: cat, subject: sub, suggestion: sug } = saved;
    const suggestion = {
      category: cat,
      subject: sub,
      suggestion: sug,
      userAccountId: this.saveAccountId,
    };
    return axiosInstance.post('/SuggestionForm/addSuggestion', suggestion)
      .then(response => response);
  },
  async getUser(userExist) {
    return axiosInstance.get('/User/returnUserAccountId', {
      params: {
        username: userExist.username,
        password: userExist.password,
      },
    })
    // eslint-disable-next-line no-return-assign
      .then(response => response);
  },
  setUserInfo(saved) {
    console.log(saved);
    this.saveAccountId = saved.userAccountId;
    this.userFirstName = saved.firstName;
    this.userLastName = saved.lastName;
    this.userUsername = saved.username;
    this.userEmail = saved.email;
    this.userManagerId = saved.managerId;
  },
  resetUserInfo() {
    this.saveAccountId = 0;
    this.userFirstName = null;
    this.userLastName = null;
    this.userUsername = null;
    this.userEmail = null;
    this.userManagerId = 0;
  },
  // eslint-disable-next-line no-return-assign
  async getSuggestionForms() {
    return axiosInstance.get('/SuggestionForm/getSuggestions')
    // eslint-disable-next-line no-return-assign
      .then(response => response);
  },
};
