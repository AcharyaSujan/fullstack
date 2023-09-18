<template>
    <a-layout style="min-height: 100vh">
      <a-layout-sider v-model:collapsed="collapsed" collapsible>
        <div class="logo" style="height:80px;color:#fff;display:flex;justify-content:center;align-items:center;font-size:20px;">
            RT-在线教育
        </div>
        <a-menu v-model:selectedKeys="selectedKeys" theme="dark" mode="inline">
          <a-menu-item key="1">
            <pie-chart-outlined />
            <span><router-link to="/dashboard" style="color:#fff">数据分析</router-link></span>
          </a-menu-item>
         
          <a-sub-menu key="sub1">
            <template #title>
              <span>
                <user-outlined />
                <span>课程管理</span>
              </span>
            </template>
            <a-menu-item key="3"><router-link style="color:#fff" to="/course">信息管理</router-link></a-menu-item>
            <a-menu-item key="4"><router-link style="color:#fff" to="/category">类别管理</router-link></a-menu-item>

          </a-sub-menu>
          
        </a-menu>
      </a-layout-sider>
      <a-layout>
        <a-layout-header style="background: #fff; padding: 0" />
        <a-layout-content style="margin: 0 16px">
          <a-breadcrumb style="margin: 16px 0;text-align:left;">
            <a-breadcrumb-item>User</a-breadcrumb-item>
            <a-breadcrumb-item>Bill</a-breadcrumb-item>
          </a-breadcrumb>
          <div :style="{ padding: '24px', background: '#fff', minHeight: '360px' }">
            <!-- 这是主页面去 -->
            <router-view/>
          </div>
        </a-layout-content>
        <a-layout-footer style="text-align: center">
          Ant Design ©2018 Created by Ant UED
        </a-layout-footer>
      </a-layout>
    </a-layout>
  </template>
  <script>
  import { PieChartOutlined, DesktopOutlined, UserOutlined, TeamOutlined, FileOutlined } from '@ant-design/icons-vue';
  import { defineComponent, ref } from 'vue';
  export default defineComponent({
    components: {
      PieChartOutlined,
      DesktopOutlined,
      UserOutlined,
      TeamOutlined,
      FileOutlined,
    },
    data() {
      return {
        collapsed: ref(false),
        selectedKeys: ref(['1']),
      };
    },
  });
  </script>
  <style>
  #components-layout-demo-side .logo {
    height: 32px;
    margin: 16px;
    background: rgba(255, 255, 255, 0.3);
  }
  
  .site-layout .site-layout-background {
    background: #fff;
  }
  [data-theme='dark'] .site-layout .site-layout-background {
    background: #141414;
  }
  </style>