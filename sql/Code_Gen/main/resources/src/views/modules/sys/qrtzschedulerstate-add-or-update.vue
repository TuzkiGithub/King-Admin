<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="" prop="instanceName">
      <el-input v-model="dataForm.instanceName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="lastCheckinTime">
      <el-input v-model="dataForm.lastCheckinTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="checkinInterval">
      <el-input v-model="dataForm.checkinInterval" placeholder=""></el-input>
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
          instanceName: '',
          lastCheckinTime: '',
          checkinInterval: ''
        },
        dataRule: {
          instanceName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          lastCheckinTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          checkinInterval: [
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
              url: this.$http.adornUrl(`/sys/qrtzschedulerstate/info/${this.dataForm.schedName}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.instanceName = data.qrtzschedulerstate.instanceName
                this.dataForm.lastCheckinTime = data.qrtzschedulerstate.lastCheckinTime
                this.dataForm.checkinInterval = data.qrtzschedulerstate.checkinInterval
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
              url: this.$http.adornUrl(`/sys/qrtzschedulerstate/${!this.dataForm.schedName ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'schedName': this.dataForm.schedName || undefined,
                'instanceName': this.dataForm.instanceName,
                'lastCheckinTime': this.dataForm.lastCheckinTime,
                'checkinInterval': this.dataForm.checkinInterval
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
