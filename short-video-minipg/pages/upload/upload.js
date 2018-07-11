
Page({
  data: {
    recordFlg: false,
    devicePosOpts: ['front', 'back'],
    devicePosIndex: 0,
  },

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
  },

  startRecord: function(){
    this.setData({
      recordFlg: true,
    })
  },

  endRecord: function(){
    this.setData({
      recordFlg: false,
    })
  },

  doReverse: function(){
    if (this.data.devicePosIndex == 0) {
      this.data.devicePosIndex = 1;
    } else {
      this.data.devicePosIndex = 0;
    }
  }
})
