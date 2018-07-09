//app.js
App({
  serverUrl: "http://192.168.50.253:8081",
  userInfo: null,
  defaultFaceImag: '../resources/pictures/noneface.jpg',

    onLaunch: function () {
      // 小程序启动之后 触发
      this.userInfo = wx.getStorageSync('user');
    },
})