<template>
  <q-dialog ref="dialogRef" @hide="onDialogHide" @show="onDialogShow">
      <q-card style="min-width: 480px">
        <q-form ref="formRef" @submit="onSubmit">
          <q-card-section>
            <div class="text-h6">创建新课程</div>
          </q-card-section>
          <q-card-section class="q-pt-none">
            <q-input
              v-model="form.name"
              label="课程名称"
              lazy-rules
              :rules="[
                val => val !== null && val !== '' || '请输入课程名称',
                val => val.length > 0 && val.length < 100 || '课程名称不能大于 100 字',
              ]"
            />
          </q-card-section>
          <q-card-actions align="right" class="text-primary">
            <q-btn flat label="取消" :disable='loading' @click="onDialogCancel" />
            <q-btn flat label="创建" :loading="loading" type="submit" />
          </q-card-actions>
        </q-form>
      </q-card>

  </q-dialog>
</template>

<script lang="ts">
import { defineComponent, ref, reactive, toRaw} from 'vue';
import { classApi} from 'src/api/class-api';
import { useDialogPluginComponent } from 'quasar';

export default defineComponent({
  name: 'ClassCreateDialog',
  props: {
  },
  emits: [
    ...useDialogPluginComponent.emits,
  ],
  setup() {
    const { dialogRef, onDialogHide, onDialogOK, onDialogCancel } = useDialogPluginComponent();

    const formRef = ref(null);
    const form = reactive({
      name : '',
    })

    const loading = ref(false);

    const onDialogShow = () => {
      (formRef.value as any).reset();
    };

    const onSubmit = async () => {
      loading.value = true;
      const created = await classApi.create(toRaw(form));
      loading.value = false;
      onDialogOK(created);
    }

    return {
      loading,
      form,
      formRef,
      onSubmit,
      dialogRef,
      onDialogShow,
      onDialogHide,
      onDialogCancel,
    }
  }
})
</script>
