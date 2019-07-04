import { axiosInstance } from 'src/boot/axios.js';

export default {
  // async getHelloWorld() {
  //   try {
  //     const response = axiosInstance.get('/');
  //     console.log(response);
  //   } catch (error) {
  //     console.error(error);
  //   }
  // },
  savedForms: [],
  // async saveSurvey(saved) {
  //   const theDate = new Date();
  //   const { category, subject, description } = saved;
  //   const copy = Object.assign({}, {
  //     category, subject, description, date: theDate,
  //   });
  //   this.savedForms.push(copy);
  //   return this.savedForms;
  // },
  async saveSurvey(saved) {
    const theDate = new Date();
    const { category: cat, subject: sub, description: des } = saved;
    return axiosInstance.get('/SuggestionForm/saveSurvey', {
      params: {
        category: cat,
        subject: sub,
        description: des,
        date: theDate,
      },
    })
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
  // eslint-disable-next-line no-return-assign
  async getSuggestionForms() {
    return this.savedForms;
  },
};
