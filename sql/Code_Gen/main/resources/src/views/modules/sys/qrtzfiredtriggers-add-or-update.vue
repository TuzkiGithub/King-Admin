<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="entryId">
      <el-input v-model="dataForm.entryId" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="triggerName">
      <el-input v-model="dataForm.triggerName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="triggerGroup">
      <el-input v-model="dataForm.triggerGroup" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="instanceName">
      <el-input v-model="dataForm.instanceName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="firedTime">
      <el-input v-model="dataForm.firedTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="schedTime">
      <el-input v-model="dataForm.schedTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="priority">
      <el-input v-model="dataForm.priority" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="state">
      <el-input v-model="dataForm.state" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jobName">
      <el-input v-model="dataForm.jobName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jobGroup">
      <el-input v-model="dataForm.jobGroup" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="isNonconcurrent">
      <el-input v-model="dataForm.isNonconcurrent" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="requestsRecovery">
      <el-input v-model="dataForm.requestsRecovery" placeholder=""></el-input>
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
          entryId: '',
          triggerName: '',
          triggerGroup: '',
          instanceName: '',
          firedTime: '',
          schedTime: '',
          priority: '',
          state: '',
          jobName: '',
          jobGroup: '',
          isNonconcurrent: '',
          requestsRecovery: ''
        },
        dataRule: {
          entryId: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          triggerName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          triggerGroup: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          instanceName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          firedTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          schedTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          priority: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          state: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jobName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jobGroup: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          isNonconcurrent: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          requestsRecovery: [
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
              url: this.$http.adornUrl(`/sys/qrtzfiredtriggers/info/${this.dataForm.schedName}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.entryId = data.qrtzfiredtriggers.entryId
                this.dataForm.triggerName = data.qrtzfiredtriggers.triggerName
                this.dataForm.triggerGroup = data.qrtzfiredtriggers.triggerGroup
                this.dataForm.instanceName = data.qrtzfiredtriggers.instanceName
                this.dataForm.firedTime = data.qrtzfiredtriggers.firedTime
                this.dataForm.schedTime = data.qrtzfiredtriggers.schedTime
                this.dataForm.priority = data.qrtzfiredtriggers.priority
                this.dataForm.state = data.qrtzfiredtriggers.state
                this.dataForm.jobName = data.qrtzfiredtriggers.jobName
                this.dataForm.jobGroup = data.qrtzfiredtriggers.jobGroup
                this.dataForm.isNonconcurrent = data.qrtzfiredtriggers.isNonconcurrent
                this.dataForm.requestsRecovery = data.qrtzfiredtriggers.requestsRecovery
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
              url: this.$http.adornUrl(`/sys/qrtzfiredtriggers/${!this.dataForm.schedName ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'schedName': this.dataForm.schedName || undefined,
                'entryId': this.dataForm.entryId,
                'triggerName': this.dataForm.triggerName,
                'triggerGroup': this.dataForm.triggerGroup,
                'instanceName': this.dataForm.instanceName,
                'firedTime': this.dataForm.firedTime,
                'schedTime': this.dataForm.schedTime,
                'priority': this.dataForm.priority,
                'state': this.dataForm.state,
                'jobName': this.dataForm.jobName,
                'jobGroup': this.dataForm.jobGroup,
                'isNonconcurrent': this.dataForm.isNonconcurrent,
                'requestsRecovery': this.dataForm.requestsRecovery
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
