<template>
  <div class="container">
    <h3 class="text-center mt-4">Найпоширеніші запитання</h3>
    <div class="d-flex justify-content-center mt-4">
      <input type="text" class="form-control" v-model="searchInput" id="searchInput" placeholder="Пошук" style="width: 65%;">
    </div>
    <div v-if="displayedQuestions.length === 0" class="text-center mt-3">
      <p>Не знайдено жодних співпадінь.</p>
    </div>
    <div v-for="q in displayedQuestions" :key="q.id" class="row mb-4 mt-4">
      <div class="col-lg-8 offset-lg-2">
        <div class="border p-4">
          <strong>{{q.question}}</strong>
          <p>{{q.answer}}</p>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: 'QA',
  data() {
    return {
      questions: [],
      searchInput: '',
    };
  },

  beforeMount() {
    this.getQuestions();
  },
  computed: {
    displayedQuestions() {
      return this.searchInput
          ? this.questions.filter(question =>
              question.question.toLowerCase().includes(this.searchInput.toLowerCase())
          )
          : this.questions;
    },
  },


  methods: {
    getQuestions() {
      fetch('http://localhost:8080/q-a')
          .then(res => res.json())
          .then(data => {
            this.questions = data;
            console.log(data);
          });
    },
  }
}
</script>
<style scoped>
</style>