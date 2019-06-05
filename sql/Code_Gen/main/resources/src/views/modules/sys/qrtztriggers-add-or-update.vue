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
    <el-form-item label="" prop="jobName">
      <el-input v-model="dataForm.jobName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="jobGroup">
      <el-input v-model="dataForm.jobGroup" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="description">
      <el-input v-model="dataForm.description" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="nextFireTime">
      <el-input v-model="dataForm.nextFireTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="prevFireTime">
      <el-input v-model="dataForm.prevFireTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="priority">
      <el-input v-model="dataForm.priority" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="triggerState">
      <el-input v-model="dataForm.triggerState" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="triggerType">
      <el-input v-model="dataForm.triggerType" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="startTime">
      <el-input v-model="dataForm.startTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="endTime">
      <el-input v-model="dataForm.endTime" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="calendarName">
      <el-input v-model="dataForm.calendarName" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="misfireInstr">
      <el-input v-model="dataForm.misfireInstr" placeholder=""></el-input>
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
          triggerName: '',
          triggerGroup: '',
          jobName: '',
          jobGroup: '',
          description: '',
          nextFireTime: '',
          prevFireTime: '',
          priority: '',
          triggerState: '',
          triggerType: '',
          startTime: '',
          endTime: '',
          calendarName: '',
          misfireInstr: '',
          jobData: ''
        },
        dataRule: {
          triggerName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          triggerGroup: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jobName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          jobGroup: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          description: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          nextFireTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          prevFireTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          priority: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          triggerState: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          triggerType: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          startTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          endTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          calendarName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          misfireInstr: [
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
              url: this.$http.adornUrl(`/sys/qrtztriggers/info/${this.dataForm.schedName}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.triggerName = data.qrtztriggers.triggerName
                this.dataForm.triggerGroup = data.qrtztriggers.triggerGroup
                this.dataForm.jobName = data.qrtztriggers.jobName
                this.dataForm.jobGroup = data.qrtztriggers.jobGroup
                this.dataForm.description = data.qrtztriggers.description
                this.dataForm.nextFireTime = data.qrtztriggers.nextFireTime
                this.dataForm.prevFireTime = data.qrtztriggers.prevFireTime
                this.dataForm.priority = data.qrtztriggers.priority
                this.dataForm.triggerState = data.qrtztriggers.triggerState
                this.dataForm.triggerType = data.qrtztriggers.triggerType
                this.dataForm.startTime = data.qrtztriggers.startTime
                this.dataForm.endTime = data.qrtztriggers.endTime
                this.dataForm.calendarName = data.qrtztriggers.calendarName
                this.dataForm.misfireInstr = data.qrtztriggers.misfireInstr
                this.dataForm.jobData = data.qrtztriggers.jobData
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
              url: this.$http.adornUrl(`/sys/qrtztriggers/${!this.dataForm.schedName ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'schedName': this.dataForm.schedName || undefined,
                'triggerName': this.dataForm.triggerName,
                'triggerGroup': this.dataForm.triggerGroup,
                'jobName': this.dataForm.jobName,
                'jobGroup': this.dataForm.jobGroup,
                'description': this.dataForm.description,
                'nextFireTime': this.dataForm.nextFireTime,
                'prevFireTime': this.dataForm.prevFireTime,
                'priority': this.dataForm.priority,
                'triggerState': this.dataForm.triggerState,
                'triggerType': this.dataForm.triggerType,
                'startTime': this.dataForm.startTime,
                'endTime': this.dataForm.endTime,
                'calendarName': this.dataForm.calendarName,
                'misfireInstr': this.dataForm.misfireInstr,
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
