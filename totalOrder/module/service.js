module.exports=function (path){
  return new Promise((resolve,reject)=>{
    wx.request({
      url: 'http://127.0.0.1:8081/api/' + path,
      success:resolve,
      fail:reject
    })
  })
}