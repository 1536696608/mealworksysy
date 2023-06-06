// pages/order/definite/definite.js
Page({
  data:{
    surelist:[],
    suregoods:0,
    remarkmessage:''
  },
  onLoad(){       //这里想使用真机测试onShow时页面栈的影响，可是真机无法访问电脑ip的服务器。
    const pagedata=getCurrentPages();
    const pagemenu = pagedata[pagedata.length-2];
    this.setData({
      surelist:pagemenu.data.translist,
      suregoods:pagemenu.data.isgoods
    })
  },
  handleRemark(e){
    this.setData({
      remarkmessage:e.detail.value
    })
  },
  handleDetail(){
    wx.showToast({
      title: '成功，即将跳转',
      icon:'success',
      duration:1000
    })
    setTimeout(() => {
      wx.navigateTo({
        url: '/pages/detail/detail?remarks=' + this.data.remarkmessage,
      })
    }, 1000);
    
  }
})