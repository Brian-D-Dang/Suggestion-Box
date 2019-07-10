import { axiosInstance } from 'src/boot/axios.js';

export default {
  savedForms: [],
  saveAccountId: 0,
  async saveSurvey(saved) {
    const { category: cat, subject: sub, suggestion: sug } = saved;
    const objTest = {
      category: cat,
      subject: sub,
      suggestion: sug,
      userAccountId: this.saveAccountId,
    };
    console.log(this.saveAccountId);
    return axiosInstance.post('/SuggestionForm/save-suggestion', objTest)
      .then(response => response);
  },
  async getUser(userExist) {
    return axiosInstance.get('/User/getUser', {
      params: {
        username: userExist.username,
        password: userExist.password,
      },
    })
    // eslint-disable-next-line no-return-assign
      .then(response => response);
  },
  async setUserAccountId(saved) {
    this.saveAccountId = saved;
    return this.saveAccountId;
  },
  // eslint-disable-next-line no-return-assign
  async getSuggestionForms() {
    return this.savedForms;
  },
};
