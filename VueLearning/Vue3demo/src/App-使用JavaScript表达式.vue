<template>
  <!-- 双括号语法，Mustache -->
  <h1>{{msg}}</h1>
  <!-- JavaScript表达式可以在模板语法里使用 -->
  <h1>{{msg.split('')}}</h1>
  <h1>{{msg.split('').reverse()}}</h1>
  <h1>{{msg.split('').reverse().join('')}}</h1>
  <div v-bind:id="msg.split('').reverse().join('')" v-bind:class="id"></div>
  <div>{{color=='green' ? "开心" : "难过"}}</div>
  

</template>


<script>
  export default {
    name: 'App',
    data() {
      return {
        msg:"hello world",
        color:"yellow"
      }
    },
  }
</script>



<style>

</style>
