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
      <el-form-item label="所属社区" prop="attributePlot">
        <el-input
          v-model="queryParams.attributePlot"
          placeholder="请输入所属社区"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="积分来源" prop="pointSource">
        <el-input
          v-model="queryParams.pointSource"
          placeholder="请输入积分来源"
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
          v-hasPermi="['rubbish:PointRecordMain:add']"
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
          v-hasPermi="['rubbish:PointRecordMain:edit']"
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
          v-hasPermi="['rubbish:PointRecordMain:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['rubbish:PointRecordMain:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="PointRecordMainList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="微信uid" align="center" prop="wxUid" />
      <el-table-column label="微信昵称" align="center" prop="wxNickname" />
      <el-table-column label="所属社区" align="center" prop="attributePlot" />
      <el-table-column label="积分来源" align="center" prop="pointSource" />
      <el-table-column label="是否删除" align="center" prop="isDeleted" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['rubbish:PointRecordMain:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['rubbish:PointRecordMain:remove']"
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

    <!-- 添加或修改积分类目对话框 -->
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
        <el-form-item label="所属社区" prop="attributePlot">
          <el-input v-model="form.attributePlot" placeholder="请输入所属社区" />
        </el-form-item>
        <el-form-item label="积分来源" prop="pointSource">
          <el-input v-model="form.pointSource" placeholder="请输入积分来源" />
        </el-form-item>
        <el-form-item label="是否删除" prop="isDeleted">
          <el-input v-model="form.isDeleted" placeholder="请输入是否删除" />
        </el-form-item>
        <el-divider content-position="center">积分类目明细信息</el-divider>
        <el-row :gutter="10" class="mb8">
          <el-col :span="1.5">
            <el-button type="primary" icon="el-icon-plus" size="mini" @click="handleAddPointRecordItem">添加</el-button>
          </el-col>
          <el-col :span="1.5">
            <el-button type="danger" icon="el-icon-delete" size="mini" @click="handleDeletePointRecordItem">删除</el-button>
          </el-col>
        </el-row>
        <el-table :data="pointRecordItemList" :row-class-name="rowPointRecordItemIndex" @selection-change="handlePointRecordItemSelectionChange" ref="pointRecordItem">
          <el-table-column type="selection" width="50" align="center" />
          <el-table-column label="序号" align="center" prop="index" width="50"/>
          <el-table-column label="有效积分(真积分)" prop="effectivePoint" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.effectivePoint" placeholder="请输入有效积分(真积分)" />
            </template>
          </el-table-column>
          <el-table-column label="虚拟积分(假积分)" prop="virtualPoint" width="150">
            <template slot-scope="scope">
              <el-input v-model="scope.row.virtualPoint" placeholder="请输入虚拟积分(假积分)" />
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
import { listPointRecordMain, getPointRecordMain, delPointRecordMain, addPointRecordMain, updatePointRecordMain } from "@/api/rubbish/PointRecordMain";

export default {
  name: "PointRecordMain",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 子表选中数据
      checkedPointRecordItem: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 积分类目表格数据
      PointRecordMainList: [],
      // 积分类目明细表格数据
      pointRecordItemList: [],
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
        attributePlot: null,
        pointSource: null,
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
    /** 查询积分类目列表 */
    getList() {
      this.loading = true;
      listPointRecordMain(this.queryParams).then(response => {
        this.PointRecordMainList = response.rows;
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
        attributePlot: null,
        pointSource: null,
        isDeleted: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.pointRecordItemList = [];
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
      this.title = "添加积分类目";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPointRecordMain(id).then(response => {
        this.form = response.data;
        this.pointRecordItemList = response.data.pointRecordItemList;
        this.open = true;
        this.title = "修改积分类目";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.pointRecordItemList = this.pointRecordItemList;
          if (this.form.id != null) {
            updatePointRecordMain(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPointRecordMain(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除积分类目编号为"' + ids + '"的数据项？').then(function() {
        return delPointRecordMain(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
	/** 积分类目明细序号 */
    rowPointRecordItemIndex({ row, rowIndex }) {
      row.index = rowIndex + 1;
    },
    /** 积分类目明细添加按钮操作 */
    handleAddPointRecordItem() {
      let obj = {};
      obj.effectivePoint = "";
      obj.virtualPoint = "";
      this.pointRecordItemList.push(obj);
    },
    /** 积分类目明细删除按钮操作 */
    handleDeletePointRecordItem() {
      if (this.checkedPointRecordItem.length == 0) {
        this.$modal.msgError("请先选择要删除的积分类目明细数据");
      } else {
        const pointRecordItemList = this.pointRecordItemList;
        const checkedPointRecordItem = this.checkedPointRecordItem;
        this.pointRecordItemList = pointRecordItemList.filter(function(item) {
          return checkedPointRecordItem.indexOf(item.index) == -1
        });
      }
    },
    /** 复选框选中数据 */
    handlePointRecordItemSelectionChange(selection) {
      this.checkedPointRecordItem = selection.map(item => item.index)
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('rubbish/PointRecordMain/export', {
        ...this.queryParams
      }, `PointRecordMain_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
