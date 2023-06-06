const fetch = require("../../module/service.js");
Page({
  data:{
    listmessage:[]
  },
  onLoad(){
    var req={
      userId:wx.getStorageSync('UserId'),
      size:10,
      current:0
    }
    wx.request({
      url: 'http://localhost:5050/payments/mine',
      method: 'POST',
      data : req,
      
      header: {"Content-Type":"application/json;charset=UTF-8"},
      success: (result) => {      
        //请求成功
          
        this.setData({listmessage: result.data.content });
        console.log(result)
      },
        
      fail: (err) => {
        // wx.hideLoading()
      },
      complete: (res) => {},
    })
  },
  getdetail(e){
    console.log(e)
  }
  
})