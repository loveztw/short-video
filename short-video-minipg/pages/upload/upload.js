
Page({
  onShow: function(){
    wx.hideTabBar({})
  },

  onUnload: function(){
    wx.showTabBar({})
  },

  toIndex: function(){
    wx.reLaunch({
      url: '../index/index',
    })
  }
})
