<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="商品分类id" prop="typeMainId">
        <el-input
          v-model="queryParams.typeMainId"
          placeholder="请输入商品分类id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品编号" prop="productCode">
        <el-input
          v-model="queryParams.productCode"
          placeholder="请输入产品编号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已售" prop="saleVolume">
        <el-input
          v-model="queryParams.saleVolume"
          placeholder="请输入已售"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="需要多少积分可兑换" prop="usePoint">
        <el-input
          v-model="queryParams.usePoint"
          placeholder="请输入需要多少积分可兑换"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="产品标签" prop="tag">
        <el-input
          v-model="queryParams.tag"
          placeholder="请输入产品标签"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="库存" prop="inventory">
        <el-input
          v-model="queryParams.inventory"
          placeholder="请输入库存"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否删除" prop="isDeleted">
        <el-input
          v-model="queryParams.isDeleted"
          placeholder="请输入是否删除"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['rubbish:MallMain:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['rubbish:MallMain:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['rubbish:MallMain:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['rubbish:MallMain:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="MallMainList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="商品分类id" align="center" prop="typeMainId" />
      <el-table-column label="产品编号" align="center" prop="productCode" />
      <el-table-column label="产品名称" align="center" prop="productName" />
      <el-table-column label="产品状态" align="center" prop="productStatus" />
      <el-table-column label="已售" align="center" prop="saleVolume" />
      <el-table-column label="需要多少积分可兑换" align="center" prop="usePoint" />
      <el-table-column label="产品标签" align="center" prop="tag" />
      <el-table-column label="库存" align="center" prop="inventory" />
      <el-table-column label="产品描述" align="center" prop="description" />
      <el-table-column label="产品说明" align="center" prop="productRemark" />
      <el-table-column label="是否删除" align="center" prop="isDeleted" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['rubbish:MallMain:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['rubbish:MallMain:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改积分商城管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="商品分类id" prop="typeMainId">
          <el-input v-model="form.typeMainId" placeholder="请输入商品分类id" />
        </el-form-item>
        <el-form-item label="产品编号" prop="productCode">
          <el-input v-model="form.productCode" placeholder="请输入产品编号" />
        </el-form-item>
        <el-form-item label="产品名称" prop="productName">
          <el-input v-model="form.productName" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="已售" prop="saleVolume">
          <el-input v-model="form.saleVolume" placeholder="请输入已售" />
        </el-form-item>
        <el-form-item label="需要多少积分可兑换" prop="usePoint">
          <el-input v-model="form.usePoint" placeholder="请输入需要多少积分可兑换" />
        </el-form-item>
        <el-form-item label="产品标签" prop="tag">
          <el-input v-model="form.tag" placeholder="请输入产品标签" />
        </el-form-item>
        <el-form-item label="库存" prop="inventory">
          <el-input v-model="form.inventory" placeholder="请输入库存" />
        </el-form-item>
        <el-form-item label="产品描述" prop="description">
          <el-input v-model="form.description" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="产品说明" prop="productRemark">
          <el-input v-model="form.productRemark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除" />
        </el-form-item>
        <el-form-item label="备注" prop="remark">
          <el-input v-model="form.remark" type="textarea" placeholder="请输入内容" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listMallMain, getMallMain, delMallMain, addMallMain, updateMallMain } from "@/api/rubbish/MallMain";

export default {
  name: "MallMain",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 积分商城管理表格数据
      MallMainList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        typeMainId: null,
        productCode: null,
        productName: null,
        productStatus: null,
        saleVolume: null,
        usePoint: null,
        tag: null,
        inventory: null,
        description: null,
        productRemark: null,
        isDeleted: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询积分商城管理列表 */
    getList() {
      this.loading = true;
      listMallMain(this.queryParams).then(response => {
        this.MallMainList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        id: null,
        typeMainId: null,
        productCode: null,
        productName: null,
        productStatus: null,
        saleVolume: null,
        usePoint: null,
        tag: null,
        inventory: null,
        description: null,
        productRemark: null,
        isDeleted: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        remark: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加积分商城管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMallMain(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改积分商城管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMallMain(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMallMain(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除积分商城管理编号为"' + ids + '"的数据项？').then(function() {
        return delMallMain(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('rubbish/MallMain/export', {
        ...this.queryParams
      }, `MallMain_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
