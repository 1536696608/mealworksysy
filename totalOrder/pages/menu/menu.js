const service=require("../../module/service.js");
Page({
  data:{
    menu_rec : {
      menus:{},
      page:0,
      size:5
    },
    put_order:[],
    temp_order:{},
    res_rec : {
      restaurants:{},
      page:0,
      size:6
    },
    nowrestaurantName:'一食堂',
    nowmenu:{},
    menumessage:{},
    menuindex:"a0",//索引的序号
    isleft:0,
    isgoods:0, //判断控制显示样式和满减的文字与价格
    count:0,
    //这里将写组件相关的属性
    iscpn:false,
    translist:[],    //单价:shopvalue，虚拟id:foods_id、总价:price、名字:name、数量:number
    tempdiscount:0
  },
  onLoad: function(options) {
    // //请求首页接口

      wx.request({
        url: 'http://localhost:5050/restaurants/reslist',
        method: 'POST',
        data : this.data.res_rec,
        
        header: {"Content-Type":"application/json;charset=UTF-8"},
        success: (result) => {      
          //请求成功
            // 把接口返回数据给resData
          this.setData({ resData: result.data.content });
          
          var reqId = this.data.resData[this.data.isleft].restaurantId
          var resMenuData = {
            menus:{
              restaurantId:reqId      
            },
            page:0,
            size:5
          }
            wx.request({
              url: 'http://localhost:5050/menus/recomment',
              method: 'POST',
              data : resMenuData,
              
              header: {"Content-Type":"application/json;charset=UTF-8"},
              success: (result) => {      
                //请求成功
                wx.hideLoading();
                  // 把接口返回数据给listData
                  
                this.setData({nowmenu: result.data.content });
                console.log(this.data.listData)
              },
                
              fail: (err) => {
                // wx.hideLoading()
              },
              complete: (res) => {},
            })
            console.log(this.data.listData)
        },
          
        fail: (err) => {
          // wx.hideLoading()
        },
        complete: (res) => {},
      })
          //   wx.showLoading({ title: '努力加载中' })

    },
  orderJump(e){
    var reqId = this.data.resData[e.currentTarget.dataset.list].restaurantId
    var resMenuData = {
      menus:{
        restaurantId:reqId      
      },
      page:0,
      size:5
    }
    console.log(reqId)
    this.setData({ nowrestaurantName: this.data.resData[e.currentTarget.dataset.list].name });
    wx.request({
      url: 'http://localhost:5050/menus/recomment',
      method: 'POST',
      data : resMenuData,
      header: {"Content-Type":"application/json;charset=UTF-8"},
      success: (result) => {      
        //请求成功
          // 把接口返回数据给resData
        // console.log(result.data.content)
        this.setData({ nowmenu: result.data.content });
      },
        
      fail: (err) => {
        // wx.hideLoading()
      },
      complete: (res) => {},
    })
    this.setData({
      menuindex:'a' + e.currentTarget.dataset.list,
      isleft:e.currentTarget.dataset.list
    })
  },
  increaseShop(e){
    var tempobj={};
    console.log(this.data.nowmenu)
    console.log(e.currentTarget.dataset.foodsfun)
    tempobj.name=this.data.nowmenu[e.currentTarget.dataset.foodsfun].dishName +'(' +this.data.nowrestaurantName+ ')';
    tempobj.price=this.data.nowmenu[e.currentTarget.dataset.foodsfun].price;//商品的总价格
    tempobj.shopvalue=this.data.nowmenu[e.currentTarget.dataset.foodsfun].price;//商品的单价
    tempobj.foods_id=this.data.nowmenu[e.currentTarget.dataset.foodsfun].menuId;
    tempobj.res_id=this.data.nowmenu[e.currentTarget.dataset.foodsfun].restaurantId;
    tempobj.number=1;
    this.seekNum(tempobj)//这里进行一步相同商品的判断
    this.setData({
      isgoods:(this.data.nowmenu[e.currentTarget.dataset.foodsfun].price + this.data.isgoods) //商品的价格
    })
    if(this.data.isgoods > 25 && this.data.tempdiscount===0){     //是否优惠3元
      this.setData({
        count:this.data.count + 1,  //购物车的图标
        isgoods:(this.data.isgoods - 3),//商品的价格
        tempdiscount:1,         //只享受一次优惠
        //传给组件的商品数据
        translist:this.data.translist
      })
    }else{
      this.setData({
        count:this.data.count + 1,  //购物车的图标
        //传给组件的商品数据
        translist:this.data.translist
      })
    }
  },
  handleCpn(){
    this.setData({
      iscpn:!this.data.iscpn
    })
  },
  handleDelete(){
    this.setData({
      count:0,
      isgoods:0,
      translist:[],
      iscpn:false
    })
  },
  handleReduce(event){
    this.pageReduce(event.detail.cpnreduceid)
  },
  handleAdd(event){
    this.pageAdd(event.detail.cpnaddid)
  },
  handleDefinite(){
    // this.data.put_order = []
    // for(let i = 0;i < this.data.translist.length;i++){
    //   var temp = {};
    //   temp.userId = 1000;
    //   temp.menuId = this.data.translist[i].foods_id;
    //   temp.restaurantId = this.data.translist[i].res_id;
    //   temp.quantity = this.data.translist[i].number;
    //   temp.user_order = 100001;
    //   temp.price = this.data.translist[i].price;
    //   this.data.put_order.push(temp);
    // }
    // console.log(this.data.put_order)
    // wx.request({
    //   url: 'http://localhost:5050/orders/add',
    //   method: 'POST',
    //   data : this.data.put_order,
    //   header: {"Content-Type":"application/json;charset=UTF-8"},
    //   success: (result) => {      
    //     //请求成功
    //       // 把接口返回数据给resData
    //     // console.log(result.data.content)
    //     console.log(result)
    //   },
        
    //   fail: (err) => {
    //     // wx.hideLoading()
    //   },
    //   complete: (res) => {},
    // })
    wx.navigateTo({
      url: '/pages/definite/definite'
    })
  },
  //一些辅助函数,判断商品重复、去掉商品和添加商品
  seekNum(obj){
    if(this.data.translist.length!==0){
      const translength=this.data.translist.length;
      for(let i=0;i<translength;++i){
        if(this.data.translist[i].foods_id === obj.foods_id){
          this.data.translist[i].price +=  obj.price;
          ++this.data.translist[i].number
          return
        }else{
          if(i===translength-1)
          this.data.translist.push(obj)
        }
      }
    }else {
      this.data.translist.push(obj)
    }
  },
  pageReduce(tempreduceid){
    const templength = this.data.translist.length;
    for(let j = 0;j<templength;j++){
      if(this.data.translist[j].foods_id === tempreduceid){
        --this.data.translist[j].number
        this.data.translist[j].price -= this.data.translist[j].shopvalue
        const tempvalue = this.data .translist[j].shopvalue;  //取出来要删除的商品的单价
        if(this.data.translist[j].number === 0){
        //删除数组中的数据  ----------------------------------------------------------
          this.cancleArray(j)
          this.setData({
            translist:this.data.translist,
            count:this.data.count - 1 ,
            isgoods:this.data.isgoods - tempvalue
          })
          if(this.data.translist.length === 0){
           this.setData({
            iscpn:!this.data.iscpn
           })
         }
        }else{
          this.setData({
            translist:this.data.translist,
            count:this.data.count - 1 ,
            isgoods:this.data.isgoods - tempvalue
          })
        }
        return
      }
    }
  },
  pageAdd(tempaddid){
    const templength = this.data.translist.length;
    for(let m = 0; m < templength ; m++){
      if(this.data.translist[m].foods_id === tempaddid){
        ++this.data.translist[m].number
        this.data.translist[m].price += this.data.translist[m].shopvalue
        this.setData({
          translist:this.data.translist,
          count:this.data.count + 1 ,
          isgoods:this.data.isgoods + this.data.translist[m].shopvalue
        })
        return
      }
    }
  },
  cancleArray(n){
    //删除translist数组中第n项的数据
    if(n === 0){
      this.data.translist.shift()
    }else{     //数组进行向后的排序，删除最后一个元素。不考虑性能的情况下
      for(let p=n+1;p<this.data.translist.length;p++){
        temparray=this.data.translist[n];
        this.data.translist[n]=this.data.translist[p];
        this.data.translist[p]=temparray;
      }
      this.data.translist.pop()
    }
  }
})

