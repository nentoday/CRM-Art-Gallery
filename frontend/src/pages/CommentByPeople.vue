<template>
  <div class="container mt-4">
    <h1>Comments</h1>
    <form @submit.prevent="addComment" class="mb-4">
      <div class="form-row">
        <div class="form-group col-md-4">
          <label for="nickname">Nickname</label>
          <input type="text" id="nickname" class="form-control" v-model="nickname" required>
        </div>
        <div class="form-group col-md-8">
          <label for="comment">Comment</label>
          <textarea id="comment" class="form-control" rows="3" v-model="comment" required></textarea>
        </div>
      </div>
      <button type="submit" class="btn btn-success">Add Comment</button>
    </form>
    <ul class="list-group">
      <li v-for="c in comments" :key="c.id" class="list-group-item">
        <strong>{{ c.nickname }}</strong>: {{ c.comment }}
        <button @click="deleteComment(c.id)" class="btn btn-sm btn-danger float-right">Delete</button>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'CommentByPeople',
  data() {
    return {
      comments: {
        nickname: '',
        comment: '',
      },
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
            this.comments = data;
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
    addComment() {
      const newCommentText = this.comment;

      fetch('http://localhost:8080/comment/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          nickname: this.nickname,
          comment: newCommentText,
        }),
      })
          .then(data => {
            console.log(data);
            this.nickname = '';
            this.comment = '';
            this.getComment();
          });
    },

  },
};
</script>

<style scoped>
.container {
}
</style>
