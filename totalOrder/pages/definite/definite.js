// pages/order/definite/definite.js
Page({
  data:{
    put_order:[],
    surelist:[],
    suregoods:0,
    remarkmessage:''
  },
  onLoad(){       //这里想使用真机测试onShow时页面栈的影响，可是真机无法访问电脑ip的服务器。
    const pagedata=getCurrentPages();
    const pagemenu = pagedata[pagedata.length-2];
    this.setData({
      surelist:pagemenu.data.translist,
      translist:pagemenu.data.translist,
      suregoods:pagemenu.data.isgoods
    })
  },
  handleRemark(e){
    this.setData({
      remarkmessage:e.detail.value
    })
  },
  handleDetail(){
    let orderNumber = wx.getStorageSync('Cookies').match(/\d+/g).join('');

    this.data.put_order = []
    for(let i = 0;i < this.data.translist.length;i++){
      var temp = {};
      temp.userId = wx.getStorageSync('UserId');
      temp.menuId = this.data.translist[i].foods_id;
      temp.restaurantId = this.data.translist[i].res_id;
      temp.quantity = this.data.translist[i].number;
      temp.user_order = orderNumber;
      temp.price = this.data.translist[i].price;
      this.data.put_order.push(temp);
    }
    console.log(this.data.put_order)
    wx.request({
      url: 'http://localhost:5050/orders/add',
      method: 'POST',
      data : this.data.put_order,
      header: {"Content-Type":"application/json;charset=UTF-8"},
      success: (result) => {      
        //请求成功
          // 把接口返回数据给resData
        // console.log(result.data.content)
        console.log(result)
      },
        
      fail: (err) => {
        // wx.hideLoading()
      },
      complete: (res) => {},
    })
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