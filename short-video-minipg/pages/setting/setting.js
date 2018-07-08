const app = getApp()

Page({
  toPassReset: function() {
    wx.navigateTo({
      url: '../regist/regist?resetFlg=true',
    })
  },
})
