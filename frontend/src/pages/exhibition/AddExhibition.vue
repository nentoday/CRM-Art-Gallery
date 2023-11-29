<template>
  <main>
    <div class="container my-5">
      <div class="mx-auto" style="max-width: 600px;">
        <h2 class="text-center mb-3">Додати виставку</h2>
        <form @submit.prevent="addExhibition">
          <div class="form-group mt-3">
            <label for="title">Назва виставки</label>
            <input type="text" id="title" class="form-control" maxlength="80" v-model="exhibition.title"
                   @input="validateName" required>
            <p class="mt-1 error-message" id="name-error">{{ titleError }}</p>
          </div>
          <div class="form-group mt-3">
            <label for="description">Опис виставки</label>
            <textarea id="description" class="form-control" maxlength="500" v-model="exhibition.description"
                      @input="validateDescription" required></textarea>
            <p class="mt-1 error-message" id="description-error">{{ descriptionError }}</p>
          </div>
          <div class="form-group mt-3">
            <label for="startDate">Початок виставки</label>
            <input
                type="datetime-local"
                id="startDate"
                class="form-control"
                maxlength="80"
                v-model="exhibition.startTime"
                @input="validateStartDate"
                :min="getTomorrowISOString()"
                required
            />
            <p class="mt-1 error-message" id="startDate-error">{{ startDateError }}</p>
          </div>
          <div class="form-group mt-3">
            <label for="endDate">Кінець виставки</label>
            <input
                type="datetime-local"
                id="endDate"
                class="form-control"
                maxlength="80"
                v-model="exhibition.endTime"
                @input="validateEndDate"
                :min="getTomorrowISOString()"
                required
            />
            <p class="mt-1 error-message" id="endDate-error">{{ endDateError }}</p>
          </div>


          <div class="form-group mt-3">
            <label for="imageUrl">Посилання на зображення</label>
            <input type="text" id="imageLink" class="form-control" v-model="exhibition.imgUrl"
                   @input="validateImageUrl" required>
            <p class="mt-1 error-message" id="imageUrl-error">{{ imageUrlError }}</p>
          </div>
          <div class="form-group mt-3">
            <input class="btn btn-primary w-100 mb-5" type="submit" value="Додати">
          </div>
        </form>
      </div>
    </div>
  </main>
</template>
<script>
export default {
  name: 'addExhibition',
  data() {
    return {
      exhibition: {
        title: '',
        description: '',
        startDate: '',
        endDate: '',
        imgUrl: ''
      },
      titleError: '',
      descriptionError: '',
      startDateError: '',
      endDateError: '',
      imageUrlError: ''
    };
  },
  methods: {
    addExhibition() {
      if (this.validateForm()) {
        fetch('http://localhost:8080/exhibition/add', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.exhibition)
        })
            .then(data => {
              console.log(data);
              this.$router.push("/exhibition");
            });
      }
    },
    validateForm() {
      this.clearErrorMessages();

      let isValid = true;

      if (!this.validateName()) {
        isValid = false;
      }

      if (!this.validateDescription()) {
        isValid = false;
      }

      if (!this.validateStartDate()) {
        isValid = false;
      }

      if (!this.validateEndDate()) {
        isValid = false;
      }

      if (!this.validateImageUrl()) {
        isValid = false;
      }

      return isValid;
    },
    clearErrorMessages() {
      this.titleError = '';
      this.descriptionError = '';
      this.startDateError = '';
      this.endDateError = '';
      this.imageUrlError = '';
    },
    validateName() {
      const isValid = this.exhibition.title.trim() !== '';
      this.titleError = isValid ? '' : 'Введіть коректну назву виставки';
      return isValid;
    },
    validateDescription() {
      const isValid = this.exhibition.description.trim() !== '';
      this.descriptionError = isValid ? '' : 'Введіть коректний опис виставки';
      return isValid;
    },
    validateStartDate() {
      if (this.exhibition.startTime === '') {
        return true;
      }
      const selectedDate = new Date(this.exhibition.startTime);
      const currentDate = new Date();
      const tomorrow = new Date(currentDate);
      tomorrow.setDate(currentDate.getDate());
      this.startDateError =
          selectedDate >= tomorrow
              ? ''
              : 'Введіть майбутню дату';
      return selectedDate >= tomorrow;
    },

    validateEndDate() {
      if (this.exhibition.endTime === '' || this.exhibition.startTime === '') {
        return true;
      }

      const selectedStartDate = new Date(this.exhibition.startTime);
      const selectedEndDate = new Date(this.exhibition.endTime);
      const currentDate = new Date();
      const tomorrow = new Date(currentDate);
      const minEndDate = new Date(currentDate);

      tomorrow.setDate(currentDate.getDate() + 1);
      minEndDate.setDate(currentDate.getDate() + 3);

      const isValid =
          selectedEndDate >= tomorrow &&
          selectedEndDate >= selectedStartDate &&
          selectedEndDate >= minEndDate;

      this.endDateError = isValid
          ? ''
          : 'Введіть майбтню дату та мінумум на 3 дні більшу дату ніж початок виставки';

      return isValid;
    },

    validateImageUrl() {
      const linkRegex = /^(https?):\/\/[^\s/$.?#].[^\s]*$/;
      this.imageUrlError = linkRegex.test(this.exhibition.imgUrl) ? '' : 'Введіть коректне посилання на зображення';
      return linkRegex.test(this.exhibition.imgUrl);
    },
    getTomorrowISOString() {
      const tomorrow = new Date();
      tomorrow.setDate(tomorrow.getDate() + 1);
      return tomorrow.toISOString().slice(0, -8);
    },
  }
};
</script>


<style scoped>
.container {
  background-color: #ffffff;
  padding: 50px;
  margin-top: 20px;
  margin-bottom: 50px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  flex: 1;
}

.button-group {
  display: flex !important;
  flex-direction: column !important;
}

.error-message {
  color: red;
}
</style>
