const app = getApp();

Page({
  data: {
    showMenuFlg: "",
    bgmList: [],
    serverUrl: app.serverUrl,
    curPage: 0,
    totalPage: 0,
  },

  showMenu: function(e) {
    var id = e.currentTarget.id;
    this.setData({
      showMenuFlg: id,
    })
  },

  onLoad: function() {
    var serverUrl = app.serverUrl;  
    var that = this;

    wx.showLoading({
      title: '加载中',
    })
    wx.request({
      url: serverUrl + '/bgm/listPage?page=1',
      method: 'POST',
      success: function (res) {
        wx.hideLoading();
        that.setData({
          bgmList: res.data.data.rows,
          curPage: res.data.data.page,
          totalPage: res.data.data.total,
        })
      }
    })
  },

  //上拉刷新
  onReachBottom: function() {
    var curPage = this.data.curPage;

    if (curPage >= this.data.totalPage) {
      return;
    }

    var newBgmList = this.data.bgmList;
    this.setData({
      curPage: curPage + 1,
      bgmList: [],
    })
    curPage = this.data.curPage;
    var serverUrl = app.serverUrl;
    var that = this;
    wx.request({
      url: serverUrl + '/bgm/listPage?page=' + curPage,
      method: 'POST',
      success: function (res) {
        console.log(res)
        that.setData({
          bgmList: newBgmList.concat(res.data.data.rows),
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
