const fetch = require("../../module/service.js") //必须使用相对路径
Page({
  data:{
    detaillist:[],
    detailgoods:0,
    remarks:'',
    detailmessage:{}
  },
  onLoad(options){
    //获取组件的数据
    const pagedata=getCurrentPages(); 
    const pagemenu = pagedata[pagedata.length-3];
    this.setData({
      detaillist:pagemenu.data.translist,
      detailgoods:pagemenu.data.isgoods,
      remarks:options.remarks   //这是备注的信息
    })
    //得到服务器的数据
    fetch('food/order').then((res)=>{
      this.setData({
        detailmessage:res.data
      })
    }).catch(()=>{
      wx.showToast({
        title: '数据请求错误',
        icon:'error',
        duration:500
      })
    })
  },
  //使用页面回退的方式进入到订单列表
  onUnload(){ 
    wx.switchTab({
      url: '/pages/list/list'
    })
  }
})