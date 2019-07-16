import { axiosInstance } from 'src/boot/axios.js';

export default {
  savedForms: null,
  saveAccountId: 0,
  userFirstName: null,
  userLastName: null,
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
  setUserAccountId(saved) {
    this.saveAccountId = saved;
  },
  setUserFirstName(saved) {
    this.userFirstName = saved;
  },
  setUserLastName(saved) {
    this.userLastName = saved;
  },
  // eslint-disable-next-line no-return-assign
  async getSuggestionForms() {
    return axiosInstance.get('/SuggestionForm/getSuggestions')
    // eslint-disable-next-line no-return-assign
      .then(response => response);
  },
};
