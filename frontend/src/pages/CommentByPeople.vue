<template>
  <div class="container mt-4">
    <h1>Comments</h1>
    <ul class="list-group">
      <li v-for="c in comment" :key="c.id" class="list-group-item">
        <strong>{{ c.nickname }}</strong>: {{ c.comment }}
        <button @click="deleteComment(c.id)" class="btn btn-sm btn-danger float-right">Delete</button>
      </li>
    </ul>

  </div>
</template>

<script>
export default {
  name: 'comment',
  data() {
    return {
      comment: [],
    };
  },

  beforeMount() {
    this.getComment();
  },

  methods: {
    getComment() {
      fetch('http://localhost:8080/comment')
          .then(res => res.json())
          .then(data => {
            this.comment = data;
            console.log(data);
          });
    },
    deleteComment(id) {
      fetch(`http://localhost:8080/comment/${id}`, {
        method: 'DELETE',
      })
          .then(data => {
            console.log(data);
            this.getComment();
          });
    },
  },
};
</script>

<style scoped>
.container {
  /* Add your styling if needed */
}
</style>
