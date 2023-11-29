<template>
  <div class="container mt-4">
    <h1 class="mb-4">Відгуки</h1>

    <div class="row">
      <div v-for="c in comments" :key="c.id" class="col-md-4 mb-4">
        <div class="card h-100 d-flex flex-column">
          <div class="card-body d-flex flex-column">
            <h5 class="card-title text-center"><strong>{{ c.nickname }}</strong></h5>
            <p class="card-text flex-grow-1 comment-text text-center">{{ c.comment }}</p>
            <button @click="deleteComment(c.id)" class="btn btn-sm btn-danger mt-2">Видалити</button>
          </div>
        </div>
      </div>
    </div>
    <form @submit.prevent="addComment" class="mt-4">
      <div class="form-row">
        <p class="mt-5"><b>Хочете поділитись враженнями після відвідування виставки? Заповніть форму:</b></p>

        <div class="form-group col-md-4">
          <label for="nickname">Ім'я</label>
          <input type="text" id="nickname" class="form-control" v-model="nickname" required>
        </div>
        <div class="form-group col-md-8">
          <label for="comment">Відгук</label>
          <textarea id="comment" class="form-control" rows="3" v-model="comment" required></textarea>
        </div>
      </div>
      <button type="submit" class="btn btn-success mt-3">Додати</button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'CommentByPeople',
  data() {
    return {
      comments: [],
      nickname: '',
      comment: '',
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
  background-color: #ffffff;
  padding: 50px;
  margin-top: 20px;
  margin-bottom: 50px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  flex: 1;
}
.card {
  min-height: 300px;
}

.comment-text {
  word-wrap: break-word;
}

.card-body {
  display: flex;
  flex-direction: column;
}
.btn-danger {
  background-color: #ff7b7b;
  border-color: #ff7b7b;
  color: #fff;
}
</style>
