<template>
  <el-dialog :visible.sync="visible" :title="!dataForm.orderId ? $t('add') : $t('update')" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmitHandle()" :label-width="$i18n.locale === 'en-US' ? '120px' : '80px'">
          <el-form-item label="用户ID" prop="userId">
          <el-input v-model="dataForm.userId" placeholder="用户ID"></el-input>
      </el-form-item>
          <el-form-item label="菜单编号" prop="menuId">
          <el-input v-model="dataForm.menuId" placeholder="菜单编号"></el-input>
      </el-form-item>
          <el-form-item label="餐厅编号" prop="restaurantId">
          <el-input v-model="dataForm.restaurantId" placeholder="餐厅编号"></el-input>
      </el-form-item>
          <el-form-item label="点餐日期" prop="orderDate">
          <el-input v-model="dataForm.orderDate" placeholder="点餐日期"></el-input>
      </el-form-item>
          <el-form-item label="数量" prop="quantity">
          <el-input v-model="dataForm.quantity" placeholder="数量"></el-input>
      </el-form-item>
          <el-form-item label="用户点餐订单号" prop="userOrder">
          <el-input v-model="dataForm.userOrder" placeholder="用户点餐订单号"></el-input>
      </el-form-item>
          <el-form-item label="单价" prop="price">
          <el-input v-model="dataForm.price" placeholder="单价"></el-input>
      </el-form-item>
      </el-form>
    <template slot="footer">
      <el-button @click="visible = false">{{ $t('cancel') }}</el-button>
      <el-button type="primary" @click="dataFormSubmitHandle()">{{ $t('confirm') }}</el-button>
    </template>
  </el-dialog>
</template>

<script>
import debounce from 'lodash/debounce'
export default {
  data () {
    return {
      visible: false,
      dataForm: {
        orderId: '',
        userId: '',
        menuId: '',
        restaurantId: '',
        orderDate: '',
        quantity: '',
        userOrder: '',
        price: ''
      }
    }
  },
  computed: {
    dataRule () {
      return {
        userId: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        menuId: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        restaurantId: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        orderDate: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        quantity: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        userOrder: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        price: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    init () {
      this.visible = true
      this.$nextTick(() => {
        this.$refs['dataForm'].resetFields()
        if (this.dataForm.orderId) {
          this.getInfo()
        }
      })
    },
    // 获取信息
    getInfo () {
      this.$http.get(`/demo/orders/${this.dataForm.orderId}`).then(({ data: res }) => {
        if (res.code !== 0) {
          return this.$message.error(res.msg)
        }
        this.dataForm = {
          ...this.dataForm,
          ...res.data
        }
      }).catch(() => {})
    },
    // 表单提交
    dataFormSubmitHandle: debounce(function () {
      this.$refs['dataForm'].validate((valid) => {
        if (!valid) {
          return false
        }
        this.$http[!this.dataForm.orderId ? 'post' : 'put']('/demo/orders/', this.dataForm).then(({ data: res }) => {
          if (res.code !== 0) {
            return this.$message.error(res.msg)
          }
          this.$message({
            message: this.$t('prompt.success'),
            type: 'success',
            duration: 500,
            onClose: () => {
              this.visible = false
              this.$emit('refreshDataList')
            }
          })
        }).catch(() => {})
      })
    }, 1000, { 'leading': true, 'trailing': false })
  }
}
</script>
