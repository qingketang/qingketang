<template>
  <q-dialog v-model="visible">
      <q-card style="min-width: 480px">
        <q-form
          @submit="onSubmit"
        >
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
            <q-btn flat label="取消" :disable='loading' v-close-popup />
            <q-btn flat label="创建" :loading="loading" type="submit" />
          </q-card-actions>
        </q-form>
      </q-card>

  </q-dialog>
</template>

<script lang="ts">
import { defineComponent, ref, watch, toRefs } from 'vue';
import { classApi} from 'src/api/class-api';

export default defineComponent({
  name: 'ClassCreateDialog',
  props: {
    modelValue: {
      type: Boolean,
      default: false,
    },
  },
  emits: ['update:modelValue', 'created'],
  setup(props, context) {
    /**
     * @see https://v3.cn.vuejs.org/guide/component-basics.html#%E5%9C%A8%E7%BB%84%E4%BB%B6%E4%B8%8A%E4%BD%BF%E7%94%A8-v-model
     */
    const visible = ref(false);
    const {modelValue} = toRefs(props);
    watch(modelValue, (modelValue) => visible.value = modelValue);
    watch(visible, (visible) => context.emit('update:modelValue', visible));

    const name = ref('');
    const loading = ref(false);
    const onSubmit = async () => {
      loading.value = true;
      const created = await classApi.create({name: name.value});
      console.log('class created:', created);
      visible.value = false;
      loading.value = false;
    };

    watch(visible, () => {
      name.value = '';
    });

    return {
      visible,
      name,
      loading,
      onSubmit,
    }
  }
})
</script>
