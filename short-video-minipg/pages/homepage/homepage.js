const app = getApp()

Page({
  data: {
    faceImage: app.defaultFaceImag,
    nickname: '我的昵称',
    signature: '我很懒，什么都没留下',
    likeCnt: '0',
    followCnt: '0',
    fansCnt: '0',
    sex: '性别未设置',
    constellation: '星座未设置',
    age: '年龄未设置'
  },

  onShow: function () {
    var userInfo = app.userInfo
    if (userInfo == null) {
      return
    }

    if (userInfo.faceImage != null && userInfo.faceImage != '') {
      this.setData({
        faceImage: app.serverUrl + userInfo.faceImage
      })
    }

    if (userInfo.nickname != null && userInfo.nickname != '') {
      this.setData({
        nickname: userInfo.nickname
      })
    }    

    if (userInfo.signature != null && userInfo.signature != '') {
      this.setData({
        signature: userInfo.signature
      })
    }  

    if (userInfo.receiveLikeCount != null && userInfo.receiveLikeCount != '') {
      this.setData({
        likeCnt: userInfo.receiveLikeCount
      })
    }  

    if (userInfo.followCount != null && userInfo.followCount != '') {
      this.setData({
        followCnt: userInfo.followCount
      })
    }

    if (userInfo.fansCount != null && userInfo.fansCount != '') {
      this.setData({
        fansCnt: userInfo.fansCount
      })
    }   

    if (userInfo.sex != null && userInfo.sex != '') {
      var sexName = (userInfo.sex == 1) ? '男银' : '女银'
      this.setData({
        sex: sexName
      })
    }   

    if (userInfo.age != null && userInfo.age != '') {
      this.setData({
        age: userInfo.age
      })
    }     

    if (userInfo.constellationName != null && userInfo.constellationName != '') {
      this.setData({
        constellation: userInfo.constellationName
      })
    }   
  },

  toUserEdit: function() {
    wx.navigateTo({
      url: '../profile/profile',
    })
  }
})
