<template>
  <div>
    <div class="container mt-4">
      <h1>Виставки</h1>
      <a href="/exhibition/add" class="btn btn-primary mb-4">Додати виставку</a>
      <div class="row justify-content-center">
        <div v-for="exhibition in exhibition" :key="exhibition.id" class="col-md-6 mb-4">
          <div class="card" style="width: 100%;">
            <img :src="exhibition.imgUrl" class="card-img-top" alt="Картинка виставки"
                 style="height: 200px; object-fit: cover;">
            <div class="card-body">
              <h5 class="card-title">{{ exhibition.title }}</h5>
              <p class="card-text">{{ exhibition.description }}</p>
              <p class="card-text"><strong>Початок:</strong> {{ formatDate(exhibition.startTime) }}</p>
              <p class="card-text"><strong>Кінець:</strong> {{ formatDate(exhibition.endTime) }}</p>
              <button class="btn btn-danger" @click="deleteExhibition(exhibition.id)">Видалити</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Exhibition',
  data() {
    return {
      exhibition: [],
    };
  },

  beforeMount() {
    this.getExhibition();
  },

  methods: {

    getExhibition() {
      fetch('http://localhost:8080/exhibition')
          .then(res => res.json())
          .then(data => {
            this.exhibition = data.sort((a, b) => new Date(a.startTime) - new Date(b.startTime));
            console.log(this.exhibition);
          });
    },
    deleteExhibition(id) {
      fetch(`http://localhost:8080/exhibition/${id}`, {
        method: 'DELETE',
      })
          .then(data => {
            console.log(data);
            this.getExhibition();
          });
    },
    formatDate(dateTimeString) {
      const options = {
        year: 'numeric',
        month: 'numeric',
        day: 'numeric',
        hour: 'numeric',
        minute: 'numeric',
        second: 'numeric'
      };
      const dateTime = new Date(dateTimeString);
      return dateTime.toLocaleDateString('uk-ua', options).replace(/T/, ' ');
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
</style>