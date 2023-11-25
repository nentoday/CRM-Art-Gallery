<template>
  <main>
    <div class="my-5">
      <div class="mx-auto w-25 " style="max-width:100%;">
        <h2 class="text-center mb-3">Оновити роботу</h2>
        <form @submit.prevent="updateArtwork">
          <div class="form-group mt-3">
            <label for="title">Назва роботи</label>
            <input type="text" id="title" class="form-control" v-model="artwork.title"  required>
            <!--            <p class="mt-1 error-message" id="name-error">{{ nameError }}</p>-->
          </div>
          <div class="form-group mt-3">
            <label for="description">Опис роботи</label>
            <textarea id="description" class="form-control" v-model="artwork.description" required></textarea>
            <!--            <p class="mt-1 error-message" id="description-error">{{ descriptionError }}</p>-->
          </div>
          <div class="form-group mt-3">
            <label for="technique">Техніка створення</label>
            <input type="text" id="technique" class="form-control" v-model="artwork.technique" required>
            <!--            <p class="mt-1 error-message" id="technique-error">{{ techniqueError }}</p>-->
          </div>

          <div class="form-group mt-3">
            <label for="year">Рік створення</label>
            <input type="date" id="year" class="form-control" v-model="artwork.creation_year" required>
            <!--            <p class="mt-1 error-message" id="price-error">{{ yearError }}</p>-->
          </div>
          <div class="form-group mt-3">
            <label for="imageLink">Посилання на зображення роботи</label>
            <input type="text" id="imageLink" class="form-control" v-model="artwork.artwork_link" required>
          </div>


          <div class="row">
            <div class="col-md-12 form-group">
              <input class="btn btn-primary w-100" type="submit" value="Submit">
            </div>
          </div>

          <div>

          </div>
        </form>

      </div>
    </div>

  </main>
</template>


<script>

export default {
  name: 'edit',
  data() {
    return {
      artwork: {
        id: '',
        title: '',
        description: '',
        creation_year: '',
        technique: '',
        artwork_link: ''
      }
    }
  },

  beforeMount() {
    this.getArtwork();
  },

  methods: {
    getArtwork() {
      fetch(`http://localhost:8080/artwork/${this.$route.params.id}`)
          .then(res => res.json())
          .then(data => {
            this.artwork = data;
            console.log(this.artwork);
          })

    },
    updateArtwork() {
      fetch(`http://localhost:8080/artwork`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.artwork)
      })
          .then(data => {
            console.log(data);
            this.$router.push(`/artworks`);
          })
    }
  }
}

</script>

<style scoped>
.error-message {
  color: red;
}

body {
  background-color: #f8f8f8;
}

.container {
  background-color: #ffffff;
  padding: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  flex: 1;
}

div.active p {
  display: block;
}

body {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  margin: 0;
}

main {
  flex: 1;
}

p {
  word-wrap: break-word;
  max-width: 600px;
}
</style>
