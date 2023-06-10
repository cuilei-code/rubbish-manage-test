<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="微信昵称" prop="nickName">
        <el-input
          v-model="queryParams.nickName"
          placeholder="请输入微信昵称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="姓名" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入姓名"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="性别  0男   1女" prop="gender">
        <el-input
          v-model="queryParams.gender"
          placeholder="请输入性别  0男   1女"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信openid" prop="openid">
        <el-input
          v-model="queryParams.openid"
          placeholder="请输入微信openid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="微信uid" prop="wxUid">
        <el-input
          v-model="queryParams.wxUid"
          placeholder="请输入微信uid"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="手机号" prop="telephone">
        <el-input
          v-model="queryParams.telephone"
          placeholder="请输入手机号"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="省" prop="userProvice">
        <el-input
          v-model="queryParams.userProvice"
          placeholder="请输入省"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="市" prop="userCity">
        <el-input
          v-model="queryParams.userCity"
          placeholder="请输入市"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="国家" prop="userCountry">
        <el-input
          v-model="queryParams.userCountry"
          placeholder="请输入国家"
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
          v-hasPermi="['rubbish:WxUser:add']"
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
          v-hasPermi="['rubbish:WxUser:edit']"
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
          v-hasPermi="['rubbish:WxUser:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['rubbish:WxUser:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="WxUserList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="微信昵称" align="center" prop="nickName" />
      <el-table-column label="姓名" align="center" prop="userName" />
      <el-table-column label="性别  0男   1女" align="center" prop="gender" />
      <el-table-column label="微信openid" align="center" prop="openid" />
      <el-table-column label="微信uid" align="center" prop="wxUid" />
      <el-table-column label="手机号" align="center" prop="telephone" />
      <el-table-column label="头像" align="center" prop="avator" />
      <el-table-column label="省" align="center" prop="userProvice" />
      <el-table-column label="市" align="center" prop="userCity" />
      <el-table-column label="国家" align="center" prop="userCountry" />
      <el-table-column label="个人微信二维码" align="center" prop="wxQrcode" />
      <el-table-column label="备注" align="center" prop="remark" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['rubbish:WxUser:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['rubbish:WxUser:remove']"
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

    <!-- 添加或修改客户端普通用户对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="微信昵称" prop="nickName">
          <el-input v-model="form.nickName" placeholder="请输入微信昵称" />
        </el-form-item>
        <el-form-item label="姓名" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入姓名" />
        </el-form-item>
        <el-form-item label="性别  0男   1女" prop="gender">
          <el-input v-model="form.gender" placeholder="请输入性别  0男   1女" />
        </el-form-item>
        <el-form-item label="微信openid" prop="openid">
          <el-input v-model="form.openid" placeholder="请输入微信openid" />
        </el-form-item>
        <el-form-item label="微信uid" prop="wxUid">
          <el-input v-model="form.wxUid" placeholder="请输入微信uid" />
        </el-form-item>
        <el-form-item label="手机号" prop="telephone">
          <el-input v-model="form.telephone" placeholder="请输入手机号" />
        </el-form-item>
        <el-form-item label="头像" prop="avator">
          <el-input v-model="form.avator" type="textarea" placeholder="请输入内容" />
        </el-form-item>
        <el-form-item label="省" prop="userProvice">
          <el-input v-model="form.userProvice" placeholder="请输入省" />
        </el-form-item>
        <el-form-item label="市" prop="userCity">
          <el-input v-model="form.userCity" placeholder="请输入市" />
        </el-form-item>
        <el-form-item label="国家" prop="userCountry">
          <el-input v-model="form.userCountry" placeholder="请输入国家" />
        </el-form-item>
        <el-form-item label="个人微信二维码" prop="wxQrcode">
          <el-input v-model="form.wxQrcode" type="textarea" placeholder="请输入内容" />
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
import { listWxUser, getWxUser, delWxUser, addWxUser, updateWxUser } from "@/api/rubbish/WxUser";

export default {
  name: "WxUser",
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
      // 客户端普通用户表格数据
      WxUserList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        nickName: null,
        userName: null,
        gender: null,
        openid: null,
        wxUid: null,
        telephone: null,
        avator: null,
        userProvice: null,
        userCity: null,
        userCountry: null,
        wxQrcode: null,
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
    /** 查询客户端普通用户列表 */
    getList() {
      this.loading = true;
      listWxUser(this.queryParams).then(response => {
        this.WxUserList = response.rows;
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
        nickName: null,
        userName: null,
        gender: null,
        openid: null,
        wxUid: null,
        telephone: null,
        avator: null,
        userProvice: null,
        userCity: null,
        userCountry: null,
        wxQrcode: null,
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
      this.title = "添加客户端普通用户";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getWxUser(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改客户端普通用户";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateWxUser(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addWxUser(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除客户端普通用户编号为"' + ids + '"的数据项？').then(function() {
        return delWxUser(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('rubbish/WxUser/export', {
        ...this.queryParams
      }, `WxUser_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
