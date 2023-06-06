<template>
  <el-dialog :visible.sync="visible" :title="!dataForm.menuId ? $t('add') : $t('update')" :close-on-click-modal="false" :close-on-press-escape="false">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmitHandle()" :label-width="$i18n.locale === 'en-US' ? '120px' : '80px'">
          <el-form-item label="餐厅编号" prop="restaurantId">
          <el-input v-model="dataForm.restaurantId" placeholder="餐厅编号"></el-input>
      </el-form-item>
          <el-form-item label="菜名" prop="dishName">
          <el-input v-model="dataForm.dishName" placeholder="菜名"></el-input>
      </el-form-item>
          <el-form-item label="价格（元）" prop="price">
          <el-input v-model="dataForm.price" placeholder="价格（元）"></el-input>
      </el-form-item>
          <el-form-item label="图片地址" prop="url">
          <el-input v-model="dataForm.url" placeholder="图片地址"></el-input>
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
        menuId: '',
        restaurantId: '',
        dishName: '',
        price: '',
        url: ''
      }
    }
  },
  computed: {
    dataRule () {
      return {
        restaurantId: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        dishName: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        price: [
          { required: true, message: this.$t('validate.required'), trigger: 'blur' }
        ],
        url: [
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
        if (this.dataForm.menuId) {
          this.getInfo()
        }
      })
    },
    // 获取信息
    getInfo () {
      this.$http.get(`/demo/menus/${this.dataForm.menuId}`).then(({ data: res }) => {
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
        this.$http[!this.dataForm.menuId ? 'post' : 'put']('/demo/menus/', this.dataForm).then(({ data: res }) => {
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
