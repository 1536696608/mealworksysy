const fetch = require("../../module/service.js");
Page({
  data: {
    image_url:'',
    recoredarray:[]
  },
  onLoad: function (options) {
    // wx.authorize({
    //   scope: 'scope.userInfo',
    //   success:()=>{
    //     wx.getUserInfo({
    //       lang:'zh_CN',
    //       success:(res)=>{
    //         const tempinfo = res.userInfo;
    //         console.log(tempinfo)
    //         this.setData({
    //           image_url:tempinfo.avatarUrl
    //         })
    //       }
    //     })
    //   }
    // })
    fetch('food/record').then((res)=>{
      this.setData({
        image_url:res.data.avatar,
        recoredarray:res.data.record
      })
    }).catch(()=>{
      wx.showToast({
        title: '数据请求失败',
        icon:'error',
        duration:500
      })
    })
  }
})