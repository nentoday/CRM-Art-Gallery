<template>
  <div class="container mt-4">
    <div class="px-4 py-2">
      <h3>Творче Агентство "ARTuni"</h3><br>
      <p class="mb-1">Вулиця Творчості 123</p>
      <p class="mb-1">Місто Мистецтва</p>
      <p class="mb-3">Країна Талантів</p>
      <p><i class="fa fa-phone"></i> Телефон: +380123456789</p>
      <p><i class="fa fa-envelope"></i> Електронна пошта: gallerymails@email.com</p>

      <form @submit.prevent="submitForm" class="mb-4">
        <div class="form-row">
          <div class="form-group col-md-6">
            <p class="mt-5"><b>Маєте додаткові питання? Заповніть форму і ми вам зателефонуємо:</b></p>
            <label for="name">Як до вас звертатись?</label>
            <input type="text" id="name" class="form-control" v-model="contacts.name" @input="validateName" required>
            <p class="mt-1 error-message" id="name-error">{{ nameError }}</p>
          </div>
          <div class="form-group col-md-6">
            <label for="phoneNumber">Номер телефону</label>
            <input type="text" id="phoneNumber" class="form-control" v-model="contacts.phoneNumber" v-mask="'+38(0##)-###-##-##'"
                   placeholder="+38(0__)-___-__-__" @input="validatePhoneNumber" required>
            <p class="mt-1 error-message" id="phone-error">{{ phoneNumberError }}</p>
          </div>
        </div>
        <button type="submit" class="btn btn-primary mb-5">Надіслати</button>
      </form>
      <div v-if="submissionMessage" class="mt-2 alert alert-success">
        {{ submissionMessage }}
      </div>
    </div>
  </div>
</template>

<script>
import {mask} from 'vue-the-mask';
export default {
  name: 'Contacts',
  directives: {
    mask,
  },
  data() {
    return {
      contacts: {
        name: '',
        phoneNumber: '',

      },
      nameError: '',
      phoneNumberError: '',
      submissionMessage: null,
    };
  },
  methods: {
    getContact() {
      fetch('http://localhost:8080/contacts')
          .then(res => res.json())
          .then(data => {
            this.contacts = data;
            console.log(data);
          });
    },
    //if (this.validateForm()){}
    submitForm() {
      const newContactText = this.contacts.phoneNumber;

      fetch('http://localhost:8080/contacts/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          name: this.contacts.name,
          number: newContactText,
        }),
      })
          .then(data => {
            console.log(data);
            this.contacts.name = '';
            this.contacts.phoneNumber = '';
            this.getContact();
            this.submissionMessage = 'Ми отримали ваше повідомлення, очікуйте на дзвінок!';
          });
    },
    validateForm() {
      this.clearErrorMessages();

      let isValid = true;

      if (!this.validateName()) {
        isValid = false;
      }
      if (!this.validatePhoneNumber()) {
        isValid = false;
      }

      return isValid;
    },
    clearErrorMessages() {
      this.nameError = '';
      this.phoneNumberError = '';
    },
    validateName() {
      const isValid = this.contacts.name.trim() !== '';
      this.nameError = isValid ? '' : 'Введіть коректне ім\'я';
      return isValid;
    },
    validatePhoneNumber() {
      const phoneDigits = this.contacts.phoneNumber.replace(/\D/g, '')
      this.phoneNumberError = phoneDigits.length === 12 ? '' : 'Введіть коректний номер телефону'
      return phoneDigits.length === 12;
    },
  },
};
</script>

<style scoped>
.error-message {
  color: red;
}
</style>