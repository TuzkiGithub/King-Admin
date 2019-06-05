<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="spring bean名称" prop="beanName">
      <el-input v-model="dataForm.beanName" placeholder="spring bean名称"></el-input>
    </el-form-item>
    <el-form-item label="参数" prop="params">
      <el-input v-model="dataForm.params" placeholder="参数"></el-input>
    </el-form-item>
    <el-form-item label="cron表达式" prop="cronExpression">
      <el-input v-model="dataForm.cronExpression" placeholder="cron表达式"></el-input>
    </el-form-item>
    <el-form-item label="任务状态  0：正常  1：暂停" prop="status">
      <el-input v-model="dataForm.status" placeholder="任务状态  0：正常  1：暂停"></el-input>
    </el-form-item>
    <el-form-item label="备注" prop="remark">
      <el-input v-model="dataForm.remark" placeholder="备注"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          jobId: 0,
          beanName: '',
          params: '',
          cronExpression: '',
          status: '',
          remark: '',
          createTime: ''
        },
        dataRule: {
          beanName: [
            { required: true, message: 'spring bean名称不能为空', trigger: 'blur' }
          ],
          params: [
            { required: true, message: '参数不能为空', trigger: 'blur' }
          ],
          cronExpression: [
            { required: true, message: 'cron表达式不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '任务状态  0：正常  1：暂停不能为空', trigger: 'blur' }
          ],
          remark: [
            { required: true, message: '备注不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.jobId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.jobId) {
            this.$http({
              url: this.$http.adornUrl(`/sys/schedulejob/info/${this.dataForm.jobId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.beanName = data.schedulejob.beanName
                this.dataForm.params = data.schedulejob.params
                this.dataForm.cronExpression = data.schedulejob.cronExpression
                this.dataForm.status = data.schedulejob.status
                this.dataForm.remark = data.schedulejob.remark
                this.dataForm.createTime = data.schedulejob.createTime
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/sys/schedulejob/${!this.dataForm.jobId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'jobId': this.dataForm.jobId || undefined,
                'beanName': this.dataForm.beanName,
                'params': this.dataForm.params,
                'cronExpression': this.dataForm.cronExpression,
                'status': this.dataForm.status,
                'remark': this.dataForm.remark,
                'createTime': this.dataForm.createTime
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
