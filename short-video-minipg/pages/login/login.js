const app = getApp();

Page({

  goToRegistPage: function() {
    wx.navigateTo({
      url: '../regist/regist',
    })
  },

  goToIndex: function() {
    wx.reLaunch({
      url: '../index/index',
    })
  },

  doLogin: function(e) {
    var formObj = e.detail.value;
    var username = formObj.username;
    var password = formObj.password;

    if (username.length == 0) {
      wx.showToast({
        title: '请输入用户名',
        icon: 'none',
        duration: 3000
      })
      return;
    }

    if (password.length == 0) {
      wx.showToast({
        title: '请输入密码',
        icon: 'none',
        duration: 3000
      })
      return;
    }

    var utilMd5 = require('../utils/md5.js');
    var passwordMd5 = utilMd5.b64MD5(password); 

    var serverUrl = app.serverUrl;

    wx.showLoading({
      title: '处理中',
    });
    wx.request({
      url: serverUrl + '/login',
      method: 'POST',
      data: {
        username: username,
        password: passwordMd5
      },
      header: {
        'content-type': 'application/json' //默认值
      },
      success: function (res) {
        wx.hideLoading();
        if (res.data.status == 200) {
          wx.showToast({
            title: '登陆成功',
            icon: 'none',
            duration: 2000
          })
          
          app.userInfo = res.data.data
          wx.setStorageSync('user', app.userInfo)

          wx.reLaunch({
            url: '../homepage/homepage',
          })
        } else if (res.data.status == 500) { 
          wx.showToast({
            title: '系统错误',
            icon: 'none',
          }) 
        } else {
          wx.showToast({
            title: res.data.msg,
            icon: 'none',
          })
        }
      },
      fail: function(res) {
        wx.hideLoading();
        wx.showToast({
          title: '系统错误',
          icon: 'none',
        })
      }
    });
  }
})
