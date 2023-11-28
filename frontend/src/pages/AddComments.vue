<template>
  <!-- Comment Form -->
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
</template>

<script>
export default {
  name: 'addComment',
  data() {
    return {
      nickname: '',
      comment: '',
    };
  },
  methods: {
    addComment() {
      fetch('http://localhost:8080/comment/add', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          nickname: this.nickname,
          comment: this.comment,
        }),
      })
          .then(data => {
            console.log(data);
            this.$router.push("/comment");
          });
    },
  },
}
</script>
