Page({

  /**
   * 页面的初始数据
   */
  data: {
    current:1,
    codeText:'获取验证码',
    counting:false,
    username: '',
    password: '',
    workid:'',
    email:''
  },

  usernameInput: function (e) {
    this.data.username = e.detail.value
  },
  workidInput: function (e) {
    this.data.workid = e.detail.value
  },
  emailInput: function (e) {
    // this.setData({
    //   email: value
    // })
    // console.log(e)
    this.data.email = e.detail.value
  },
  // 获取输入密码 
  passwordInput: function (e) {
    this.data.password = e.detail.value
  },
  loginregister:function(){
    var url
    var post_data
    if(this.data.current == 1){
      url = 'http://localhost:5050/users/login'
      post_data = {
        userId : this.data.username,
        password : this.data.password
      }
    } else{
      url = 'http://localhost:5050/users/register'
      post_data = {
        userId : this.data.username,
        password : this.data.password,
        workId:this.data.workid,
        email:this.data.email
      }
    }
    wx.request({
      url: url,
      method: 'POST',
      data : post_data,
      header: {"Content-Type":"application/json;charset=UTF-8"},
      success: (result) => {      
        //请求成功
          // 把接口返回数据给resData
          console.log(post_data)
        if(result.data.data != null){
          wx.setStorageSync('Cookies',result.header['Set-Cookie'])
          wx.setStorageSync('UserId',result.data.data.userId)
          wx.switchTab({
            url: '/pages/index/index'
          })
        }
        
      },
        
      fail: (err) => {
        // wx.hideLoading()
      },
      complete: (res) => {},
    })
 
  },
  // 登陆注册监听
  click(e){
    let index = e.currentTarget.dataset.code;
    this.setData({
      current:index
    })
  },
  //获取验证码 
  getCode(){
    var that = this;
    if (!that.data.counting) {
      wx.showToast({
        title: '验证码已发送',
      })
      //开始倒计时60秒
      that.countDown(that, 60);
    } 
  },
  //倒计时60秒
  countDown(that,count){
    if (count == 0) {
      that.setData({
        codeText: '获取验证码',
        counting:false
      })
      return;
    }
    that.setData({
      counting:true,
      codeText: count + '秒后重新获取',
    })
    setTimeout(function(){
      count--;
      that.countDown(that, count);
    }, 1000);
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad(options) {

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage() {

  }
})
