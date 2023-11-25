<template>
  <div>
    <div class="container mt-4">
      <h1>Виставки</h1>
      <div class="search-container">
        <input type="text" class="search-input" placeholder="Пошук">
        <select class="filter-select">
          <option value="week">Наступний тиждень</option>
          <option value="month">Місяць</option>
          <option value="year">Рік</option>
        </select>
        <button type="submit" class="btn btn-primary m-lg-2">Підтвердити</button>
      </div>
      <p>Проведіть пошук необхідної виставки або оберіть проміжок часу</p>
      <div class="exhibition">
        <h2>Крута виставка 1</h2>
        <div class="artworks">
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
        </div>
      </div>

      <div class="exhibition">
        <h2>Крута виставка 2</h2>
        <div class="artworks">
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
          <div class="artwork">
            <div class="name">Квітковий Вальс</div>
            <div class="artist">Мельник Ірина</div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>

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

.exhibition {
  margin-top: 40px;
  padding: 20px;
  border: 1px solid #817f7f;
  border-radius: 10px;
  background-color: #f8f8f8;
}

h2 {
  font-size: 20px;
  margin-bottom: 10px;
}

.artworks {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(250px, 1fr));
  grid-gap: 20px;
}

.artwork {
  border: 1px solid #ddd;
  padding: 10px;
  border-radius: 10px;
  background-color: #efeeee;
}

.name {
  font-weight: bold;
}

.artist {
  margin-top: 10px;
}

.search-container {
  display: flex;
  align-items: center;
}

.search-input {
  flex: 1;
  padding: 5px;
  border: 1px solid #ddd;
  border-radius: 5px;
  margin-right: 10px;
}

.filter-select {
  padding: 5px;
  border: 1px solid #ddd;
  border-radius: 5px;
}
</style>
<script setup>
</script>