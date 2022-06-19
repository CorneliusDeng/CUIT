<template>
  <view class="all">
	<image src="http://mp4.q05.cc/2543156.gif"></image>
    <navigator url="/pages/user/login/login">
      <button type="primary">登录</button>
    </navigator>
    <navigator url="/pages/user/register/register">
      <button type="primary">注册</button>
    </navigator>
  </view>
</template>

<script>
  export default {
    data() {
      return {};
    }
  }
</script>

<style>
  button {
	width:80%;
	border-radius: 7.5rem;
    margin-top: 40upx;
	background: -webkit-linear-gradient(left, #fe7eb1 , #ff4d7f);
	background: linear-gradient(to right, #fe7eb1 , #ff4d7f); 
  }
  #all {
	  font-size: larger;
	  text-align: center;
  }
</style>
