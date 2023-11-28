<template>
  <main>
    <div>
      <div class="container mt-4">
        <h1 class="text-center">Роботи в галереї</h1>
        <label for="searchInput" class="form-label">Пошук за назвою:</label>

        <div class="mb-3 d-flex justify-content-between align-items-center">
          <div class="d-flex flex-grow-1">
            <input type="text" class="form-control" v-model="searchInput" id="searchInput" placeholder="Пошук" style="width: 80%;">
          </div>
          <a href="/artwork/add" class="btn btn-primary">Додати нову роботу</a>
        </div>
        <div class="table-responsive">
          <table class="table table-bordered">
            <thead>
            <tr>
              <th scope="col">Назва роботи</th>
              <th scope="col">Опис роботи</th>
              <th scope="col">Техніка створення</th>
              <th scope="col">Рік створення</th>
              <th scope="col">Посилання на роботу</th>
              <th scope="col">Дії</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="artwork in displayedArtworks" :key="artwork.id">
              <td>{{ artwork.title }}</td>
              <td>{{ artwork.description }}</td>
              <td>{{ artwork.technique }}</td>
              <td>{{ artwork.creation_year }}</td>
              <td>{{ artwork.artwork_link }}</td>
              <td>
                <a class="btn btn-primary m-1" :href="`/edit/${artwork.id}`">Edit</a>
                <button class="btn btn-danger m-1" @click="deleteArtwork(artwork.id)">Delete</button>
              </td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </main>
</template>

<script>
export default {
  name: 'home',
  data() {
    return {
      artworks: [],
      searchInput: '',
    };
  },
  computed: {
    displayedArtworks() {
      return this.searchInput
          ? this.artworks.filter(artwork =>
              artwork.title.toLowerCase().includes(this.searchInput.toLowerCase())
          )
          : this.artworks;
    },
  },

  beforeMount() {
    this.getArtworks();
  },

  methods: {
    getArtworks() {
      fetch('http://localhost:8080/artworks')
          .then(res => res.json())
          .then(data => {
            this.artworks = data;
            console.log(data);
          });
    },
    deleteArtwork(id) {
      fetch(`http://localhost:8080/artwork/${id}`, {
        method: 'DELETE',
      })
          .then(data => {
            console.log(data);
            this.getArtworks();
          });
    },
  },
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
</style>
