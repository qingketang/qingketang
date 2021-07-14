<template>
  <q-page class="q-pa-md">
    <div class="row q-mb-md">
      <div class="col text-h5">课程</div>
    </div>

    <div class="q-gutter-x-sm q-mb-md">
      <q-btn unelevated color="primary" label="创建课程" />
    </div>

    <div class="row q-col-gutter-md">
      <div class="col-3" v-for="n in 6" :key="`course-${n}`">
        <q-card flat bordered>
          <q-card-section class="bg-grey-3" style="min-height: 120px;">
            <div class="text-h6 text-grey-8">默认课程 {{ n }}</div>
            <div class="text-subtitle2 text-grey-6">No: DF34RTJK</div>
          </q-card-section>

          <q-separator />

          <q-card-actions align="between">
            <q-btn flat icon="people" label="15 人" color="grey-8"></q-btn>
            <q-btn flat color="primary">开始上课</q-btn>
          </q-card-actions>
        </q-card>
      </div>
    </div>

  </q-page>
</template>

<script lang="ts">
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'TeacherCourseList',
  components: { },
  setup() {
    return {};
  }
});
</script>
