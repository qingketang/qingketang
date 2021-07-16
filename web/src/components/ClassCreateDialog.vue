<template>
  <q-dialog ref="dialogRef" @hide="onDialogHide">
      <q-card style="min-width: 480px">
        <q-form @submit="onSubmit">
          <q-card-section>
            <div class="text-h6">创建新课程</div>
          </q-card-section>
          <q-card-section class="q-pt-none">
            <q-input
              v-model="name"
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
import { defineComponent, ref} from 'vue';
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

    const name = ref('');
    const loading = ref(false);

    const onSubmit = async () => {
      loading.value = true;
      const created = await classApi.create({name: name.value});
      loading.value = false;
      onDialogOK(created);
    }

    return {
      loading,
      name,
      dialogRef,
      onDialogHide,
      onDialogCancel,
      onSubmit,
    }
  }
})
</script>
