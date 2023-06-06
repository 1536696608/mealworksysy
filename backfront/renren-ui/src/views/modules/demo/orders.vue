<template>
  <el-card shadow="never" class="aui-card--fill">
    <div class="mod-demo__orders}">
      <el-form :inline="true" :model="dataForm" @keyup.enter.native="getDataList()">
        <el-form-item>
          <el-input v-model="dataForm.orderId" placeholder="orderId" clearable></el-input>
        </el-form-item>
        <el-form-item>
          <el-button @click="getDataList()">{{ $t('query') }}</el-button>
        </el-form-item>
        <el-form-item>
          <el-button type="info" @click="exportHandle()">{{ $t('export') }}</el-button>
        </el-form-item>
        <el-form-item>
          <el-button v-if="$hasPermission('demo:orders:save')" type="primary" @click="addOrUpdateHandle()">{{ $t('add') }}</el-button>
        </el-form-item>
        <el-form-item>
          <el-button v-if="$hasPermission('demo:orders:delete')" type="danger" @click="deleteHandle()">{{ $t('deleteBatch') }}</el-button>
        </el-form-item>
      </el-form>
      <el-table v-loading="dataListLoading" :data="dataList" border @selection-change="dataListSelectionChangeHandle" style="width: 100%;">
        <el-table-column type="selection" header-align="center" align="center" width="50"></el-table-column>
        <el-table-column prop="orderId" label="点餐号" header-align="center" align="center"></el-table-column>
        <el-table-column prop="userId" label="用户ID" header-align="center" align="center"></el-table-column>
        <el-table-column prop="menuId" label="菜单编号" header-align="center" align="center"></el-table-column>
        <el-table-column prop="restaurantId" label="餐厅编号" header-align="center" align="center"></el-table-column>
        <el-table-column prop="orderDate" label="点餐日期" header-align="center" align="center"></el-table-column>
        <el-table-column prop="quantity" label="数量" header-align="center" align="center"></el-table-column>
        <el-table-column prop="userOrder" label="用户点餐订单号" header-align="center" align="center"></el-table-column>
        <el-table-column prop="price" label="单价" header-align="center" align="center"></el-table-column>
        <el-table-column :label="$t('handle')" fixed="right" header-align="center" align="center" width="150">
          <template slot-scope="scope">
            <el-button v-if="$hasPermission('demo:orders:update')" type="text" size="small" @click="addOrUpdateHandle(scope.row.id)">{{ $t('update') }}</el-button>
            <el-button v-if="$hasPermission('demo:orders:delete')" type="text" size="small" @click="deleteHandle(scope.row.id)">{{ $t('delete') }}</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        :current-page="page"
        :page-sizes="[10, 20, 50, 100]"
        :page-size="limit"
        :total="total"
        layout="total, sizes, prev, pager, next, jumper"
        @size-change="pageSizeChangeHandle"
        @current-change="pageCurrentChangeHandle">
      </el-pagination>
      <!-- 弹窗, 新增 / 修改 -->
      <add-or-update v-if="addOrUpdateVisible" ref="addOrUpdate" @refreshDataList="getDataList"></add-or-update>
    </div>
  </el-card>
</template>

<script>
import mixinViewModule from '@/mixins/view-module'
import AddOrUpdate from './orders-add-or-update'
export default {
  mixins: [mixinViewModule],
  data () {
    return {
      mixinViewModuleOptions: {
        getDataListURL: '/demo/orders/page',
        getDataListIsPage: true,
        exportURL: '/demo/orders/export',
        deleteURL: '/demo/orders',
        deleteIsBatch: true
      },
      dataForm: {
        orderId: ''
      }
    }
  },
  components: {
    AddOrUpdate
  }
}
</script>
