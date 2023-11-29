<template>
  <div class="container">
    <div class="d-flex flex-grow-1">
      <input type="text" class="form-control" v-model="searchInput" id="searchInput" placeholder="Пошук" style="width: 80%;">
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