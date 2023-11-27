<template>
  <main>
    <div class="my-5">
      <div class="mx-auto" style="max-width: 600px;">
        <h2 class="text-center mb-3">Додати роботу</h2>
        <form @submit.prevent="addArtwork">
          <div class="form-group mt-3">
            <label for="name">Назва роботи</label>
            <input type="text" id="name" class="form-control" maxlength="80" v-model="artwork.title"
                   @input="validateName" required>
            <p class="mt-1 error-message" id="name-error">{{ nameError }}</p>
          </div>
          <div class="form-group mt-3">
            <label for="description">Опис роботи</label>
            <textarea id="description" class="form-control" maxlength="100" v-model="artwork.description"
                      @input="validateDescription" required></textarea>
            <p class="mt-1 error-message" id="description-error">{{ descriptionError }}</p>
          </div>
          <div class="form-group mt-3">
            <label for="technique">Техніка створення</label>
            <input type="text" id="technique" class="form-control" maxlength="80" v-model="artwork.technique"
                   @input="validateTechnique" required>
            <p class="mt-1 error-message" id="technique-error">{{ techniqueError }}</p>
          </div>
          <div class="form-group mt-3">
            <label for="year">Рік створення</label>
            <input type="number" id="year" class="form-control" v-model="artwork.creation_year" @input="validateYear"
                   required>
            <p class="mt-1 error-message" id="year-error">{{ yearError }}</p>
          </div>
          <div class="form-group mt-3">
            <label for="imageLink">Посилання на зображення роботи</label>
            <input type="text" id="imageLink" class="form-control" v-model="artwork.artwork_link"
                   @input="validateArtworkLink" required>
            <p class="mt-1 error-message" id="imageLink-error">{{ imageLinkError }}</p>
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
  name: 'add',
  data() {
    return {
      artwork: {
        title: '',
        creation_year: '',
        description: '',
        technique: '',
        artwork_link: ''
      },
      nameError: '',
      descriptionError: '',
      techniqueError: '',
      yearError: '',
      imageLinkError: ''
    };
  },
  methods: {
    addArtwork() {
      if (this.validateForm()) {
        fetch('http://localhost:8080/artwork/add', {
          method: 'POST',
          headers: {
            'Content-Type': 'application/json'
          },
          body: JSON.stringify(this.artwork)
        })
            .then(data => {
              console.log(data);
              this.$router.push("/artworks");
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

      if (!this.validateTechnique()) {
        isValid = false;
      }

      if (!this.validateYear()) {
        isValid = false;
      }

      if (!this.validateArtworkLink()) {
        isValid = false;
      }

      return isValid;
    },
    clearErrorMessages() {
      this.nameError = '';
      this.descriptionError = '';
      this.techniqueError = '';
      this.yearError = '';
      this.imageLinkError = '';
    },
    validateName() {
      const isValid = this.artwork.title.trim() !== '';
      this.nameError = isValid ? '' : 'Введіть коректну назву роботи';
      return isValid;
    },
    validateDescription() {
      const isValid = this.artwork.description.trim() !== '';
      this.descriptionError = isValid ? '' : 'Введіть коректний опис роботи';
      return isValid;
    },
    validateTechnique() {
      const isValid = this.artwork.technique.trim() !== '';
      this.techniqueError = isValid ? '' : 'Введіть коректну техніку виконання';
      return isValid;
    },
    validateYear() {
      const yearRegex = /^\d{4}$/;
      const enteredYear = parseInt(this.artwork.creation_year, 10);
      if (!yearRegex.test(this.artwork.creation_year) || enteredYear > new Date().getFullYear()) {
        this.yearError = 'Введіть коректний рік створення';
        return false;
      }
      this.yearError = '';
      return true;
    },

    validateArtworkLink() {
      const linkRegex = /^(https?):\/\/[^\s/$.?#].[^\s]*$/;
      this.imageLinkError = linkRegex.test(this.artwork.artwork_link) ? '' : 'Введіть коректне посилання на зображення';
      return linkRegex.test(this.artwork.artwork_link);
    }
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
