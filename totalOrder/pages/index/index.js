const service=require('../../module/service.js');
Page({
  data:{
    menu_rec : {
      menus:{},
      page:0,
      size:5
    },
    res_rec : {
      restaurants:{},
      page:0,
      size:6
    }
  },
  
  onLoad: function(options) {
    //如果没登录
    if(wx.getStorageSync('Cookies') == ''){
      wx.navigateTo({
        url: '/pages/login/login',
      })
    }
    // console.log(wx.getStorageSync('Cookies'))
    //请求首页接口
      wx.showLoading({ title: '努力加载中' })
      
      wx.request({
        url: 'http://localhost:5050/menus/recomment',
        method: 'POST',
        data : this.data.menu_rec,
        
        header: {
          "Content-Type":"application/json;charset=UTF-8",
          "cookie":wx.getStorageSync('Cookies')
        },
        success: (result) => {      
          
          //请求成功
          wx.hideLoading();
            // 把接口返回数据给listData
          this.setData({ listData: result.data });
          console.log(result.header)
        },
          
        fail: (err) => {
          // wx.hideLoading()
        },
        complete: (res) => {},
      })
      wx.request({
        url: 'http://localhost:5050/restaurants/reslist',
        method: 'POST',
        data : this.data.res_rec,
        
        header: {
          "Content-Type":"application/json;charset=UTF-8",
          "cookie":wx.getStorageSync('Cookies')
        },
        success: (result) => {      
          //请求成功
            // 把接口返回数据给resData
          this.setData({ resData: result.data.content });
          console.log(result.header)
        },
          
        fail: (err) => {
          // wx.hideLoading()
        },
        complete: (res) => {},
      })
    },
  onOrder:function(){
    wx.navigateTo({
      url: '../../pages/menu/menu',
    })
  }
})