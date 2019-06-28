import { axiosInstance } from 'src/boot/axios.js';

export default {
  async getHelloWorld() {
    try {
      const response = axiosInstance.get('/');
      console.log(response);
    } catch (error) {
      console.error(error);
    }
  },
  savedForms: [],
  users: [
    {
      username: 'brian',
      password: '12345q',
    },
    {
      username: 'david',
      password: '1',
    },
    {
      username: 'brandon',
      password: 'soup',
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
    return axiosInstance.get('/User/getUser', {
      params: {
        name: userExist.username,
        pass: userExist.password,
      },
    })
    // eslint-disable-next-line no-return-assign
      .then(response => response);
  },
  async getSuggestionForms() {
    return this.savedForms;
  },
};
