<template>
  <div>
    <div class="container mt-4">
      <h1>Виставки</h1>
      <a href="/exhibition/add" class="btn btn-primary">Додати нову роботу</a>
      <div class="table-responsive">
        <table class="table table-bordered">
          <thead>
          <tr>
            <th scope="col">Назва виставки</th>
            <th scope="col">Опис</th>
            <th scope="col">Початок виставки</th>
            <th scope="col">Кінець виставки</th>
            <th scope="col">Посилання на картинку</th>
            <th scope="col">Дії</th>
          </tr>
          </thead>
          <tbody>
          <tr v-for="exhibition in exhibition" :key="exhibition.id">
            <td>{{ exhibition.title }}</td>
            <td>{{ exhibition.description }}</td>
            <td>{{ exhibition.startTime }}</td>
            <td>{{ exhibition.endTime }}</td>
            <td>{{ exhibition.imgUrl }}</td>
            <td>
              <button class="btn btn-danger m-1" @click="deleteExhibition(exhibition.id)">Delete</button>
            </td>
          </tr>
          </tbody>
        </table>
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
            this.exhibition = data;
            console.log(data);
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