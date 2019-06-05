<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="triggerName">
      <el-input v-model="dataForm.triggerName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="triggerGroup">
      <el-input v-model="dataForm.triggerGroup" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="repeatCount">
      <el-input v-model="dataForm.repeatCount" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="repeatInterval">
      <el-input v-model="dataForm.repeatInterval" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="timesTriggered">
      <el-input v-model="dataForm.timesTriggered" placeholder=""></el-input>
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
          triggerName: '',
          triggerGroup: '',
          repeatCount: '',
          repeatInterval: '',
          timesTriggered: ''
        },
        dataRule: {
          triggerName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          triggerGroup: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          repeatCount: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          repeatInterval: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          timesTriggered: [
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
              url: this.$http.adornUrl(`/sys/qrtzsimpletriggers/info/${this.dataForm.schedName}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.triggerName = data.qrtzsimpletriggers.triggerName
                this.dataForm.triggerGroup = data.qrtzsimpletriggers.triggerGroup
                this.dataForm.repeatCount = data.qrtzsimpletriggers.repeatCount
                this.dataForm.repeatInterval = data.qrtzsimpletriggers.repeatInterval
                this.dataForm.timesTriggered = data.qrtzsimpletriggers.timesTriggered
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
              url: this.$http.adornUrl(`/sys/qrtzsimpletriggers/${!this.dataForm.schedName ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'schedName': this.dataForm.schedName || undefined,
                'triggerName': this.dataForm.triggerName,
                'triggerGroup': this.dataForm.triggerGroup,
                'repeatCount': this.dataForm.repeatCount,
                'repeatInterval': this.dataForm.repeatInterval,
                'timesTriggered': this.dataForm.timesTriggered
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
