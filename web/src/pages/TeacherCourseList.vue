<template>
  <q-page class="q-pa-md">
    <div class="row q-mb-md">
      <div class="col text-h5">课程</div>
    </div>

    <div class="q-gutter-x-sm q-mb-md">
      <q-btn unelevated color="primary" label="创建课程" @click='createDialogVisible = true' />
    </div>

    <div class="row q-col-gutter-md">
      <div class="col-xs-12 col-sm-6 col-md-4 col-lg-3" v-for="n in 6" :key="`course-${n}`">
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

    <course-create-dialog v-model="createDialogVisible" />

  </q-page>
</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import CourseCreateDialog from 'components/CourseCreateDialog.vue';

export default defineComponent({
  name: 'TeacherCourseList',
  components: { CourseCreateDialog },
  setup() {
    const createDialogVisible = ref(false);
    return {
      createDialogVisible,
    };
  }
});
</script>
