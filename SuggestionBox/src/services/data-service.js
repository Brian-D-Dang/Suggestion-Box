import { axiosInstance } from 'src/boot/axios.js';

export default {
  savedForms: null,
  saveAccountId: null,
  userUsername: null,
  userEmail: null,
  userFirstName: null,
  userLastName: null,
  async updateSuggestion(updatedSuggestion) {
    const {
      category: cat, subject: sub, suggestion: sug, userAccountId: userAccId, suggestionId: sugId,
    } = updatedSuggestion;
    console.log(updatedSuggestion);
    const suggestion = {
      category: cat,
      subject: sub,
      suggestion: sug,
      userAccountId: userAccId,
      suggestionId: sugId,
    };
    return axiosInstance.put('/SuggestionForm/updateSuggestion', suggestion)
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
    this.saveAccountId = saved.userAccountId;
    this.userFirstName = saved.firstName;
    this.userLastName = saved.lastName;
    this.userUsername = saved.username;
    this.userEmail = saved.email;
  },
  resetUserInfo() {
    this.saveAccountId = 0;
    this.userFirstName = null;
    this.userLastName = null;
    this.userUsername = null;
    this.userEmail = null;
  },
  // eslint-disable-next-line no-return-assign
  async getSuggestionForms() {
    return axiosInstance.get('/SuggestionForm/getSuggestions')
    // eslint-disable-next-line no-return-assign
      .then(response => response);
  },

};
