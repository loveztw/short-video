const app = getApp()

Page({
  toPassReset: function() {
    wx.navigateTo({
      url: '../regist/regist?resetFlg=true',
    })
  },

  doLogoff: function() {
    app.userInfo = null;
    wx.removeStorageSync('user');
  }
})
