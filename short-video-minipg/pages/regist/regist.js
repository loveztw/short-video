const app = getApp();

Page({
  doRegist: function(e) {
    var formObj = e.detail.value;
    var username = formObj.username;
    if (username.length == 0) {
      wx.showToast({
        title: '请输入用户名',
        icon: 'none',
        duration: 3000
      })
      return;
    }

    var password = formObj.password;
    if (password.length == 0) {
      wx.showToast({
        title: '请输入密码',
        icon: 'none',
        duration: 3000
      })
      return;
    }

    var passwordConfirm = formObj.passwordConfirm;
    if (passwordConfirm.length == 0) {
      wx.showToast({
        title: '请再次输入密码',
        icon: 'none',
        duration: 3000
      })
      return;
    }

    if (passwordConfirm != password) {
      wx.showToast({
        title: '2次输入的密码不一致',
        icon: 'none',
        duration: 3000
      })
      return;
    }

    //password to md5
    var utilMd5 = require('../utils/md5.js');
    var passwordMd5 = utilMd5.b64MD5(password);  

    var serverUrl = app.serverUrl;

    wx.showLoading({
      title: '处理中',
    });
    wx.request({
      url: serverUrl + '/regist',
      method: 'POST',
      data: {
        username: username,
        password: passwordMd5
      },
      header: {
        'content-type': 'application/json' //默认值
      },
      success: function(res){
        wx.hideLoading();
        if (res.data.status == 200) {
          wx.showToast({
            title: '注册成功，请登录',
            icon: 'none',
            duration: 2000
          })
          var commUtils = require('../utils/common.js');
          commUtils.sleep(4000);  
          wx.redirectTo({
            url: '../login/login',
          })
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
    })
  }

})
