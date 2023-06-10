<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="微信uid" prop="wxUid">
        <el-input
          v-model="queryParams.wxUid"
          placeholder="请输入微信uid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信昵称" prop="wxNickname">
        <el-input
          v-model="queryParams.wxNickname"
          placeholder="请输入微信昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="使用渠道    0微信提现    1积分兑换" prop="useChannel">
        <el-input
          v-model="queryParams.useChannel"
          placeholder="请输入使用渠道    0微信提现    1积分兑换"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="积分商城主表id" prop="mallMainId">
        <el-input
          v-model="queryParams.mallMainId"
          placeholder="请输入积分商城主表id"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="兑换数量" prop="exchangeCount">
        <el-input
          v-model="queryParams.exchangeCount"
          placeholder="请输入兑换数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="已使用数量，核销后回写该字段" prop="useCount">
        <el-input
          v-model="queryParams.useCount"
          placeholder="请输入已使用数量，核销后回写该字段"
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
          v-hasPermi="['rubbish:PointUseRecord:add']"
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
          v-hasPermi="['rubbish:PointUseRecord:edit']"
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
          v-hasPermi="['rubbish:PointUseRecord:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['rubbish:PointUseRecord:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="PointUseRecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="微信uid" align="center" prop="wxUid" />
      <el-table-column label="微信昵称" align="center" prop="wxNickname" />
      <el-table-column label="使用渠道    0微信提现    1积分兑换" align="center" prop="useChannel" />
      <el-table-column label="积分商城主表id" align="center" prop="mallMainId" />
      <el-table-column label="兑换数量" align="center" prop="exchangeCount" />
      <el-table-column label="已使用数量，核销后回写该字段" align="center" prop="useCount" />
      <el-table-column label="使用状态   0核销   1部分核销  2全部核销" align="center" prop="useStatus" />
      <el-table-column label="是否删除" align="center" prop="isDeleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['rubbish:PointUseRecord:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['rubbish:PointUseRecord:remove']"
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

    <!-- 添加或修改积分使用记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="主键id" prop="id">
          <el-input v-model="form.id" placeholder="请输入主键id" />
        </el-form-item>
        <el-form-item label="微信uid" prop="wxUid">
          <el-input v-model="form.wxUid" placeholder="请输入微信uid" />
        </el-form-item>
        <el-form-item label="微信昵称" prop="wxNickname">
          <el-input v-model="form.wxNickname" placeholder="请输入微信昵称" />
        </el-form-item>
        <el-form-item label="使用渠道    0微信提现    1积分兑换" prop="useChannel">
          <el-input v-model="form.useChannel" placeholder="请输入使用渠道    0微信提现    1积分兑换" />
        </el-form-item>
        <el-form-item label="积分商城主表id" prop="mallMainId">
          <el-input v-model="form.mallMainId" placeholder="请输入积分商城主表id" />
        </el-form-item>
        <el-form-item label="兑换数量" prop="exchangeCount">
          <el-input v-model="form.exchangeCount" placeholder="请输入兑换数量" />
        </el-form-item>
        <el-form-item label="已使用数量，核销后回写该字段" prop="useCount">
          <el-input v-model="form.useCount" placeholder="请输入已使用数量，核销后回写该字段" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除" />
        </el-form-item>
        <el-divider content-position="center">积分核销记录明细信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddPointUseRecordDetail">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeletePointUseRecordDetail">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="pointUseRecordDetailList" :row-class-name="rowPointUseRecordDetailIndex" @selection-change="handlePointUseRecordDetailSelectionChange" ref="pointUseRecordDetail">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="本次使用数量" prop="useCount" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.useCount" placeholder="请输入本次使用数量" />
            </template>
          </el-table-column>
          <el-table-column label="券码" prop="ticketCode" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.ticketCode" placeholder="请输入券码" />
            </template>
          </el-table-column>
          <el-table-column label="是否删除" prop="isDeleted" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.isDeleted" placeholder="请输入是否删除" />
            </template>
          </el-table-column>
        </el-table>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listPointUseRecord, getPointUseRecord, delPointUseRecord, addPointUseRecord, updatePointUseRecord } from "@/api/rubbish/PointUseRecord";

export default {
  name: "PointUseRecord",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedPointUseRecordDetail: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 积分使用记录表格数据
      PointUseRecordList: [],
      // 积分核销记录明细表格数据
      pointUseRecordDetailList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        wxUid: null,
        wxNickname: null,
        useChannel: null,
        mallMainId: null,
        exchangeCount: null,
        useCount: null,
        useStatus: null,
        isDeleted: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        id: [
          { required: true, message: "主键id不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询积分使用记录列表 */
    getList() {
      this.loading = true;
      listPointUseRecord(this.queryParams).then(response => {
        this.PointUseRecordList = response.rows;
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
        wxUid: null,
        wxNickname: null,
        useChannel: null,
        mallMainId: null,
        exchangeCount: null,
        useCount: null,
        useStatus: null,
        isDeleted: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.pointUseRecordDetailList = [];
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
      this.title = "添加积分使用记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPointUseRecord(id).then(response => {
        this.form = response.data;
        this.pointUseRecordDetailList = response.data.pointUseRecordDetailList;
        this.open = true;
        this.title = "修改积分使用记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.pointUseRecordDetailList = this.pointUseRecordDetailList;
          if (this.form.id != null) {
            updatePointUseRecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPointUseRecord(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除积分使用记录编号为"' + ids + '"的数据项？').then(function() {
        return delPointUseRecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 积分核销记录明细序号 */
    rowPointUseRecordDetailIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 积分核销记录明细添加按钮操作 */
    handleAddPointUseRecordDetail() {
      let obj = {};
      obj.useCount = "";
      obj.useRemark = "";
      obj.ticketCode = "";
      obj.isDeleted = "";
      this.pointUseRecordDetailList.push(obj);
    },
    /** 积分核销记录明细删除按钮操作 */
    handleDeletePointUseRecordDetail() {
      if (this.checkedPointUseRecordDetail.length == 0) {
        this.$modal.msgError("请先选择要删除的积分核销记录明细数据");
      } else {
        const pointUseRecordDetailList = this.pointUseRecordDetailList;
        const checkedPointUseRecordDetail = this.checkedPointUseRecordDetail;
        this.pointUseRecordDetailList = pointUseRecordDetailList.filter(function(item) {
          return checkedPointUseRecordDetail.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handlePointUseRecordDetailSelectionChange(selection) {
      this.checkedPointUseRecordDetail = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('rubbish/PointUseRecord/export', {
        ...this.queryParams
      }, `PointUseRecord_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
