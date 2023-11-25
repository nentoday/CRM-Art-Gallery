<template>
  <main>
    =
    <div class="my-5">
      <div class="mx-auto w-25 " style="max-width:100%;">
        <h2 class="text-center mb-3">Add Artwork</h2>
        <form @submit.prevent="addArtwork">
          <div class="form-group mt-3">
            <label for="name">Назва роботи</label>
            <input type="text" id="name" class="form-control" v-model="artwork.title" required>
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
            <input type="date" id="year" class="form-control" v-model="artwork.creation_year"  required>
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
  name: 'add',
  data() {
    return {
      artwork: {
        title: '',
        creation_year: '',
        description: '',
        technique: '',
        artwork_link: ''
      }
    }
  },

  methods: {
    addArtwork() {
      fetch('http://localhost:8080/artwork/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(this.artwork)
      })
          .then(data => {
            console.log(data)
            this.$router.push("/artworks");
          })

    }
  },

}


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


</style>