const service=require('../../module/service.js');
Page({
  onLoad(){
    wx.showLoading({
      title: '加载中...',
      mask:true
    })
    service('food/index').then((res)=>{
      this.setData({
        indexmessage:res.data
      })
      setTimeout(() => {
        wx.hideLoading()
      }, 500)
    },()=>{
      console.log("失败")
      wx.hideLoading()
    })
  },
  onOrder:function(){
    wx.navigateTo({
      url: '../../pages/menu/menu',
    })
  }
})