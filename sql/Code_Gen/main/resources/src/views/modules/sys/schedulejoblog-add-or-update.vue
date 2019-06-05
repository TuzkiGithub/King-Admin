<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="任务id" prop="jobId">
      <el-input v-model="dataForm.jobId" placeholder="任务id"></el-input>
    </el-form-item>
    <el-form-item label="spring bean名称" prop="beanName">
      <el-input v-model="dataForm.beanName" placeholder="spring bean名称"></el-input>
    </el-form-item>
    <el-form-item label="参数" prop="params">
      <el-input v-model="dataForm.params" placeholder="参数"></el-input>
    </el-form-item>
    <el-form-item label="任务状态    0：成功    1：失败" prop="status">
      <el-input v-model="dataForm.status" placeholder="任务状态    0：成功    1：失败"></el-input>
    </el-form-item>
    <el-form-item label="失败信息" prop="error">
      <el-input v-model="dataForm.error" placeholder="失败信息"></el-input>
    </el-form-item>
    <el-form-item label="耗时(单位：毫秒)" prop="times">
      <el-input v-model="dataForm.times" placeholder="耗时(单位：毫秒)"></el-input>
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
          logId: 0,
          jobId: '',
          beanName: '',
          params: '',
          status: '',
          error: '',
          times: '',
          createTime: ''
        },
        dataRule: {
          jobId: [
            { required: true, message: '任务id不能为空', trigger: 'blur' }
          ],
          beanName: [
            { required: true, message: 'spring bean名称不能为空', trigger: 'blur' }
          ],
          params: [
            { required: true, message: '参数不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '任务状态    0：成功    1：失败不能为空', trigger: 'blur' }
          ],
          error: [
            { required: true, message: '失败信息不能为空', trigger: 'blur' }
          ],
          times: [
            { required: true, message: '耗时(单位：毫秒)不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.logId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.logId) {
            this.$http({
              url: this.$http.adornUrl(`/sys/schedulejoblog/info/${this.dataForm.logId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.jobId = data.schedulejoblog.jobId
                this.dataForm.beanName = data.schedulejoblog.beanName
                this.dataForm.params = data.schedulejoblog.params
                this.dataForm.status = data.schedulejoblog.status
                this.dataForm.error = data.schedulejoblog.error
                this.dataForm.times = data.schedulejoblog.times
                this.dataForm.createTime = data.schedulejoblog.createTime
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
              url: this.$http.adornUrl(`/sys/schedulejoblog/${!this.dataForm.logId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'logId': this.dataForm.logId || undefined,
                'jobId': this.dataForm.jobId,
                'beanName': this.dataForm.beanName,
                'params': this.dataForm.params,
                'status': this.dataForm.status,
                'error': this.dataForm.error,
                'times': this.dataForm.times,
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
