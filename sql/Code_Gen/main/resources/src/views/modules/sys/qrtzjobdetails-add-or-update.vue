<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="jobName">
      <el-input v-model="dataForm.jobName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jobGroup">
      <el-input v-model="dataForm.jobGroup" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="description">
      <el-input v-model="dataForm.description" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jobClassName">
      <el-input v-model="dataForm.jobClassName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="isDurable">
      <el-input v-model="dataForm.isDurable" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="isNonconcurrent">
      <el-input v-model="dataForm.isNonconcurrent" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="isUpdateData">
      <el-input v-model="dataForm.isUpdateData" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="requestsRecovery">
      <el-input v-model="dataForm.requestsRecovery" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jobData">
      <el-input v-model="dataForm.jobData" placeholder=""></el-input>
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
          schedName: 0,
          jobName: '',
          jobGroup: '',
          description: '',
          jobClassName: '',
          isDurable: '',
          isNonconcurrent: '',
          isUpdateData: '',
          requestsRecovery: '',
          jobData: ''
        },
        dataRule: {
          jobName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jobGroup: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jobClassName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isDurable: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isNonconcurrent: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isUpdateData: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          requestsRecovery: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jobData: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.schedName = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.schedName) {
            this.$http({
              url: this.$http.adornUrl(`/sys/qrtzjobdetails/info/${this.dataForm.schedName}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.jobName = data.qrtzjobdetails.jobName
                this.dataForm.jobGroup = data.qrtzjobdetails.jobGroup
                this.dataForm.description = data.qrtzjobdetails.description
                this.dataForm.jobClassName = data.qrtzjobdetails.jobClassName
                this.dataForm.isDurable = data.qrtzjobdetails.isDurable
                this.dataForm.isNonconcurrent = data.qrtzjobdetails.isNonconcurrent
                this.dataForm.isUpdateData = data.qrtzjobdetails.isUpdateData
                this.dataForm.requestsRecovery = data.qrtzjobdetails.requestsRecovery
                this.dataForm.jobData = data.qrtzjobdetails.jobData
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
              url: this.$http.adornUrl(`/sys/qrtzjobdetails/${!this.dataForm.schedName ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'schedName': this.dataForm.schedName || undefined,
                'jobName': this.dataForm.jobName,
                'jobGroup': this.dataForm.jobGroup,
                'description': this.dataForm.description,
                'jobClassName': this.dataForm.jobClassName,
                'isDurable': this.dataForm.isDurable,
                'isNonconcurrent': this.dataForm.isNonconcurrent,
                'isUpdateData': this.dataForm.isUpdateData,
                'requestsRecovery': this.dataForm.requestsRecovery,
                'jobData': this.dataForm.jobData
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
