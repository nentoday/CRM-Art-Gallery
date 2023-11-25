<template>
  <div>
    <div class="container-fluid">
      <div class="row">
        <div class="description">
          <div class="mb-4 text-center">
            <div class="brush-icon">
              <i class="fa fa-paint-brush"></i>
            </div>
            <h1><b>Про проєкт</b></h1>
            <p>Наш проєкт призначений для сприяння розвитку галерей та високоякісного мистецтва в Україні, створюючи
              платформу для презентації та підтримки творчих пошуків українських художників.</p>
          </div>
        </div>
      </div>

      <div class="row mx-auto">
        <div class="col-sm-12 col-md-6 mb-4">
          <h3>Як нас знайти</h3>
          <iframe
              src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d635.2475033704491!2d30.512885512277634!3d50.441286674854304!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x40d4cef91a3c0861%3A0xf19741345ee1d474!2z0JzRg9C30LXQuSDQpdCw0L3QtdC90LrRltCy!5e0!3m2!1suk!2sua!4v1695923177985!5m2!1suk!2sua"
              width="85%" height="250" style="border: 10px;" allowfullscreen="" loading="lazy"
              referrerpolicy="no-referrer-when-downgrade"></iframe>
        </div>
        <div class="col-sm-12 col-md-6 mb-4">
          <h3>Наша місія</h3>
          <p>Привіт, я Василь Онопко, засновник проєкту "ArtUni". Разом з Марією Литвиненко ми об'єднуємо свою страсть
            до мистецтва та багаторічний досвід у цьому напрямку.
            Ми вирішили створити "ArtUni", щоб зробити творчість більш доступною та динамічною в Україні. За
            допомогою цього проєкту, ми прагнемо створити інноваційну платформу для управління творчими колекціями
            та галереями, сприяючи розвитку українського мистецтва.
            Під назвою "ArtUni" ми об'єднали слова "Art" (мистецтво) і "Uni" (університет), що відображає нашу місію
            створити університет та об'єднати творчу спільноту. Ми віримо в силу об'єднання та розвитку культурного
            простору, і "ArtUni" стане центром для виявлення та підтримки талановитих українських художників.</p>
        </div>
      </div>

      <div class="container mt-5 mb-2">
        <h2>Наші проєкти</h2>
        <div class="row mb-4">
          <div class="col-md-4 col-sm-12">
            <div class="card">
              <img src="../assets/Pic1.jpeg" class="card-img-top img-fluid" alt="Image 1">
              <div class="card-body">
                <p class="card-text">Інноваційна Галерея: Де Мистецтво Зустрічає Технології</p>
              </div>
            </div>
          </div>

          <div class="col-md-4 col-sm-12 mb-4">
            <div class="card">
              <img src="../assets/pic4.jpg" class="card-img-top img-fluid" alt="Image 2">
              <div class="card-body">
                <p class="card-text">Творче Агентство 'ArtHub': Відкриваємо Двері в Світ Таланту</p>
              </div>
            </div>
          </div>

          <div class="col-md-4 col-sm-12 mb-4">
            <div class="card">
              <picture>
                <source srcset="../assets/pic5.jpg" media="(max-width: 300px)">
                <source srcset="../assets/pic2.jpg" media="(max-width: 1500px)">
                <source srcset="../assets/pic3.jpg">
                <img src="../assets/pic2.jpg" class="card-img-top img-fluid" alt="Image 3">
              </picture>
              <div class="card-body">
                <p class="card-text">Експресивний Простір: Проєкт 'ArtVanguard' для Виразного Мистецтва</p>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>

  </div>
</template>

<script>

</script>

<style scoped>
body {
  background-color: #f8f8f8;
}

.brush-icon {
  font-size: 40px;
  animation: brush-paint 2s linear infinite;
}

@keyframes brush-paint {
  0% {
    transform: translateX(0);
  }
  50% {
    transform: translateX(-10px);
  }
  100% {
    transform: translateX(0);
  }
}

.container {
  background-color: #ffffff;
  padding: 20px;
  margin-top: 20px;
  margin-bottom: 20px;
  border-radius: 10px;
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  flex: 1;
}

.description{
  background: linear-gradient(rgba(0, 0, 0, 0.5),rgba(0, 0, 0, 0.5)), url('../assets/pic2.jpg');
  color: cornsilk;
  width: 100%;
  height: 500px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-bottom: 40px;
}
.qa {
  margin-bottom: 20px;
  cursor: pointer;
}

.qa p {
  display: none;
}

div.active p {
  display: block;
}
body{
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  margin: 0;
}
main {
  flex: 1;
}

p {
  word-wrap: break-word;
  max-width: 600px;
}
.card-img-top{
  height: 150px;
  object-fit: cover;
}
</style>
