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
    <el-form-item label="" prop="strProp1">
      <el-input v-model="dataForm.strProp1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="strProp2">
      <el-input v-model="dataForm.strProp2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="strProp3">
      <el-input v-model="dataForm.strProp3" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="intProp1">
      <el-input v-model="dataForm.intProp1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="intProp2">
      <el-input v-model="dataForm.intProp2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="longProp1">
      <el-input v-model="dataForm.longProp1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="longProp2">
      <el-input v-model="dataForm.longProp2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="decProp1">
      <el-input v-model="dataForm.decProp1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="decProp2">
      <el-input v-model="dataForm.decProp2" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="boolProp1">
      <el-input v-model="dataForm.boolProp1" placeholder=""></el-input>
    </el-form-item>
    <el-form-item label="" prop="boolProp2">
      <el-input v-model="dataForm.boolProp2" placeholder=""></el-input>
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
          strProp1: '',
          strProp2: '',
          strProp3: '',
          intProp1: '',
          intProp2: '',
          longProp1: '',
          longProp2: '',
          decProp1: '',
          decProp2: '',
          boolProp1: '',
          boolProp2: ''
        },
        dataRule: {
          triggerName: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          triggerGroup: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          strProp1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          strProp2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          strProp3: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          intProp1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          intProp2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          longProp1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          longProp2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          decProp1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          decProp2: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          boolProp1: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          boolProp2: [
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
              url: this.$http.adornUrl(`/sys/qrtzsimproptriggers/info/${this.dataForm.schedName}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.triggerName = data.qrtzsimproptriggers.triggerName
                this.dataForm.triggerGroup = data.qrtzsimproptriggers.triggerGroup
                this.dataForm.strProp1 = data.qrtzsimproptriggers.strProp1
                this.dataForm.strProp2 = data.qrtzsimproptriggers.strProp2
                this.dataForm.strProp3 = data.qrtzsimproptriggers.strProp3
                this.dataForm.intProp1 = data.qrtzsimproptriggers.intProp1
                this.dataForm.intProp2 = data.qrtzsimproptriggers.intProp2
                this.dataForm.longProp1 = data.qrtzsimproptriggers.longProp1
                this.dataForm.longProp2 = data.qrtzsimproptriggers.longProp2
                this.dataForm.decProp1 = data.qrtzsimproptriggers.decProp1
                this.dataForm.decProp2 = data.qrtzsimproptriggers.decProp2
                this.dataForm.boolProp1 = data.qrtzsimproptriggers.boolProp1
                this.dataForm.boolProp2 = data.qrtzsimproptriggers.boolProp2
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
              url: this.$http.adornUrl(`/sys/qrtzsimproptriggers/${!this.dataForm.schedName ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'schedName': this.dataForm.schedName || undefined,
                'triggerName': this.dataForm.triggerName,
                'triggerGroup': this.dataForm.triggerGroup,
                'strProp1': this.dataForm.strProp1,
                'strProp2': this.dataForm.strProp2,
                'strProp3': this.dataForm.strProp3,
                'intProp1': this.dataForm.intProp1,
                'intProp2': this.dataForm.intProp2,
                'longProp1': this.dataForm.longProp1,
                'longProp2': this.dataForm.longProp2,
                'decProp1': this.dataForm.decProp1,
                'decProp2': this.dataForm.decProp2,
                'boolProp1': this.dataForm.boolProp1,
                'boolProp2': this.dataForm.boolProp2
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
