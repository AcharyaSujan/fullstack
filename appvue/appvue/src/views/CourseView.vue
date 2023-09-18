<template>
    <a-table :dataSource="dataSource" :columns="columns"  :pagination="false" />
    <a-pagination 
      v-model:current="pageIndex" 
      :pageSize="size" 
      :total="count" 
      @change="changePageIndex" 
      show-less-items  
      style="text-align:right;margin-top:10px;"
      />
</template>
  <script setup>
  import { SmileOutlined, DownOutlined } from '@ant-design/icons-vue';

  import axios from 'axios';
  import {ref,reactive,toRefs,unref,onBeforeUnmount, shallowRef, onMounted,defineComponent} from 'vue'; 


  const columns = [
    {
        title: '课程名称',
        dataIndex: 'name',
        key: 'name',
    }, {
        title: '详情',
        dataIndex: 'courseInfo',
        key: 'courseInfo',
    }, {
        title: '老师姓名',
        dataIndex: 'teacherName',
        key: 'teacherName',
    }, {
        title: '封面',
        key: 'faceImg',
        dataIndex: 'faceImg',
    }, {
        title: '价格',
        key: 'price',
        dataIndex: 'price',
    }, {
        title: '类别',
        key: 'categoryName',
        dataIndex: 'categoryName',
    },{
        title: '机构',
        key: 'organizationName',
        dataIndex: 'organizationName',
    },{
        title: '课时',
        key: 'classHour',
        dataIndex: 'classHour',
    },{
        title: 'Action',
        key: 'action',
    }];


    let size = ref(3);
    let dataSource = ref(null);
    let pageIndex = ref(1);
    let count = ref(8);
    const getData = () =>{
                    
        let url = "/api/course/page/"+pageIndex.value+"/3"
        axios.get(url).then(function(result){
            console.log(result.data.data.page)
            dataSource.value = result.data.data.page.records
            pageIndex.value = result.data.data.page.current
            count.value = result.data.data.page.total
           
        }).catch(function (reason) {

        })
    }

    getData()
    
    const changePageIndex = () =>{
        getData()
    }
  </script>