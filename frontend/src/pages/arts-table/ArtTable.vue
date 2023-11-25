<template>
  <main>
    <!-- Table-->
    <div>
      <div class="container mt-4">
        <h1>Роботи в галереї</h1>
        <a href="/artwork/add">Add Artworks</a>
        <table class="table table-bordered table-responsive ">
          <thead>
          <tr>
            <th scope="col">Назва роботи</th>
            <th scope="col">Опис роботи</th>
            <th scope="col">Техніка створення</th>
            <th scope="col">Рік створення</th>
            <th scope="col">Художник</th>
            <th scope="col">Дії</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="artwork in artworks" :key="artwork.id">
            <th scope="row">{{ artwork.title }}</th>
            <td>{{ artwork.description }}</td>
            <td>{{ artwork.technique }}</td>
            <td>{{ artwork.creation_year }}</td>
            <td>{{ artwork.artwork_link }}</td>
            <td>
              <a class="btn btn-primary" :href="`/edit/${artwork.id}`">Edit</a>
              <button class="btn btn-danger mx-2" @click="deleteArtwork(artwork.id)">Delete</button>
            </td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
  </main>
</template>


<script>
export default {
  name: 'home',
  data() {
    return {
      artworks: []
    }
  },

  beforeMount() {
    this.getArtworks()
  },

  methods: {
    getArtworks() {
      fetch('http://localhost:8080/artworks')
          .then(res => res.json())
          .then(data => {
            this.artworks = data
            console.log(data)
          })
    },
    deleteArtwork(id) {
      fetch(`http://localhost:8080/artwork/${id}`, {
        method: 'DELETE'
      })
          .then(data => {
            console.log(data)
            this.getArtworks()
          })
    }
  }

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