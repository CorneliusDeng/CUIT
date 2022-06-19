<template>
  <!-- 使用v-once指令，使得内容只渲染一次 -->
  <h1 @click="changeMsg" v-once>{{msg}}</h1>

  <!-- 使用v-model指令，实现数据双向绑定 -->  
  <input type="text" v-model="msg"/>

  <!-- 使用v-html指令，使得内容插入html代码 -->
  <div>{{content}}</div>
  <div v-html="content"></div>

  <!-- 使用v-bind指令，绑定属性的内容 -->
  <div :id="id" :class="id"></div>
  <div v-bind:id="id" v-bind:class="id"></div>

</template>


<script>
  export default {
    name: 'App',
    data() {
      return {
        msg:"helloworld",
        content: "<h1>标题1</h1><h2>标题2</h2>",
        id: "d1"
      }
    },
    methods: {
      changeMsg() {
        this.msg="这是一个测试！"
        this.id="d2"
      }
    }
  }
</script>



<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
#d1 {
  width: 100px;
  height: 100px;
  background: red;
}
#d2 {
  width: 100px;
  height: 100px;
  background: green;
}
</style>
