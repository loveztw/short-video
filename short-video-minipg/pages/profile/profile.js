const app = getApp();

Page({
  data: {
    editFlag: false,
    sexArray: ['男', '女'],
    index: -1,
    faceImage: '',
    dbFaceImagePath: '',
    defaultFaceImag: '../resources/pictures/noneface.jpg',
    nickname: '',
    signature: '',
    birthday: '0'
  },

  onShow: function(){
    var userInfo = app.userInfo
    if (userInfo == null) {
      return
    }

    if (userInfo.faceImage != null && userInfo.faceImage != '') {
      this.setData({
        faceImage: app.serverUrl + '/' + userInfo.faceImage
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

    if (userInfo.sex != null && userInfo.sex != '') {
      var sexIndex = userInfo.sex - 1
      this.setData({
        index: sexIndex
      })
    }

    if (userInfo.birthday != null && userInfo.birthday != '') {
      this.setData({
        birthday: userInfo.birthday
      })
    }
  },

  selectSex: function(e){
    var selSex = parseInt(e.detail.value);
    this.setData({
      editFlag: true,
      index: selSex
    })
  },

  selectDate: function(e){
    var selDate = e.detail.value;
    this.setData({
      editFlag: true,
      birthday: selDate
    })
  },

  doUploadFace:function(){
    var that = this
    wx.chooseImage({
      count: 1,
      success: function (res) {


        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        var tempFilePaths = res.tempFilePaths
        var userId = (app.userInfo == null) ? 'test-uid' : app.userInfo.id

        wx.showLoading({
          title: '处理中',
        });
        console.log(app.serverUrl + '/user/face-upload')
        wx.uploadFile({
          url: app.serverUrl + '/user/face-upload',
          filePath: tempFilePaths[0],
          name: 'file',
          formData: {
            'userId': userId
          },
          header: {
            'content-type': 'application/json' //默认值
          },
          success: function (res) {
            var data = JSON.parse(res.data)
            wx.hideLoading()
            if (data.status == 200) {
              wx.showToast({
                title: '上传成功',
                icon: 'success'
              })

              that.setData({
                editFlag: true,
                faceImage: app.serverUrl + '/' + data.data.faceImage,
                dbFaceImagePath: data.data.faceImage
              })
            } else {
              wx.showToast({
                title: data.msg,
                icon: 'warn',
              })
            }
          },
          fail: function (res) {
            wx.hideLoading();
            wx.showToast({
              title: '系统错误',
              icon: 'none',
            })
          }          
        })


      }
    })
  },

  handleFaceImgError: function(event){
    //用户上传图片显示失败时，使用默认头像
    this.setData({
      faceImage: ''
    })
  },

  doEditUserInfo: function(e){
    var sexIndex = this.data.index + 1
    var birthday = (this.data.birthday == '0') ? null : this.data.birthday

    wx.showLoading({
      title: '处理中',
    });
    wx.request({
      url: app.serverUrl + '/user/edit',
      method: 'POST',
      data: {
        id: app.userInfo.id,
        sex: sexIndex,
        faceImage: this.data.dbFaceImagePath,
        nickname: this.data.nickname,
        birthday: birthday,
        signature: this.data.signature
      },
      header: {
        'content-type': 'application/json' //默认值
      },
      success: function (res) {
        wx.hideLoading();
        if (res.data.status == 200) {
          wx.showToast({
            title: '保存成功',
            icon: 'success',
          })

          app.userInfo = res.data.data
          wx.navigateBack({})
        } else {
          wx.showToast({
            title: res.data.msg,
            icon: 'none',
          })
        }
      },
      fail: function (res) {
        wx.hideLoading();
        wx.showToast({
          title: '系统错误',
          icon: 'none',
        })
      }
    });
  }
})
