<template>
  <!-- 动态指令 -->
  <div v-bind:[attributeName]="d1"></div>
  <button @click="togglecolor">点击切换颜色</button>
  <button @[eventName]="togglecolor">点击切换颜色</button>
  

</template>


<script>
  export default {
    name: 'App',
    data() {
      return {
        attributeName:"class",
        d1:"d1",
        eventName:"click"
      }
    },
    methods:{
      togglecolor:function(){
        this.attributeName = "id"
      }
    }
  }
</script>



<style>
#d1{
  width: 100px;
  height: 100px;
  background: yellow;
}
.d1{
  width: 100px;
  height: 100px;
  background: purple;
}
</style>
