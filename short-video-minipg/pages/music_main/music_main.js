const app = getApp();

Page({
  data: {
    showMenuFlg: "",
    bgmList: [],
    serverUrl: app.serverUrl,
  },

  showMenu: function(e) {
    var id = e.currentTarget.id;
    this.setData({
      showMenuFlg: id,
    })
  },

  onShow: function() {
    var serverUrl = app.serverUrl;  
    var that = this;
    wx.request({
      url: serverUrl + '/bgm/list/1',
      method: 'GET',
      header: {
        'content-type': 'application/json' //默认值
      },
      success: function (res) {
        that.setData({
          bgmList: res.data.data,
        })
      }
    })
  },

  doAudioPlay: function(e) {
    console.log(e)
    if (this.audioCtx != null) {
      this.audioCtx.pause();
    }
    this.audioCtx = wx.createAudioContext(e.currentTarget.id);
    console.log(this.audioCtx)
  }
})
