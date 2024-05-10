<!--
 * @Author: tianleiyu 
 * @Date: 2024-05-10 08:50:18
 * @LastEditTime: 2024-05-10 16:32:44
 * @LastEditors: tianleiyu
 * @Description: 
 * @FilePath: /organization1/src/components/editor/index.vue
 * 可以输入预定的版权声明、个性签名、空行等
-->
<template>
    <editor v-model="textContent" :init="init" :tinymceScriptSrc="tinymceScriptSrc"></editor>
  </template>
  
  <script setup lang="ts">
  import { onMounted, ref, watch } from 'vue'
  import tinymce from 'tinymce/tinymce' //tinymce默认hidden，不引入不显示
  import Editor from '@tinymce/tinymce-vue'
  import 'tinymce/themes/silver/theme' // 主题文件
  import 'tinymce/icons/default'
  import 'tinymce/models/dom'
  // tinymce插件可按自己的需要进行导入
  import 'tinymce/plugins/accordion' // 列表插件
  import 'tinymce/plugins/lists' // 列表插件
  import 'tinymce/plugins/advlist' // 有序列表插件
  import 'tinymce/plugins/autolink' // 当用户输入有效的完整URL时，autolink插件会自动创建超链接。
  import 'tinymce/plugins/link' // 链接
  import 'tinymce/plugins/autosave' // 定时自动将编辑内容保存到浏览器本地存储中（Local Storage）
  import 'tinymce/plugins/autoresize' // 可拉伸宽度
  import 'tinymce/plugins/charmap' // 特殊字符
  import 'tinymce/plugins/code' // 查看源码
  import 'tinymce/plugins/codesample' // 插入代码
  import 'tinymce/plugins/directionality' // 文字方向
  import 'tinymce/plugins/emoticons' // 表情符号
  import 'tinymce/plugins/emoticons/js/emojis'
  import 'tinymce/plugins/fullscreen' //全屏
  import 'tinymce/plugins/image' // 插入上传图片插件
  import 'tinymce/plugins/importcss' //引入自己定义的css文件
  import 'tinymce/plugins/insertdatetime' //插入时间日期
  import 'tinymce/plugins/nonbreaking' // 空格
  import 'tinymce/plugins/pagebreak' //分页
  import 'tinymce/plugins/preview' // 预览
  import 'tinymce/plugins/quickbars' // 快速工具栏
  import 'tinymce/plugins/save' // 保存
  import 'tinymce/plugins/searchreplace' //查询替换
  import 'tinymce/plugins/table' // 插入表格插件
  import 'tinymce/plugins/wordcount' // 字数统计插件
  import 'tinymce/plugins/visualblocks' // 块范围显示
  
  import { ElMessage } from 'element-plus';

  import {uploadImg} from '@/api/activity'


  import { useCookies } from "vue3-cookies";
//使用vue3-cookies
const { cookies } = useCookies();
const token = cookies.get('token')


  const props = defineProps({
    modelValue: String,
  })
  const emit = defineEmits(['update:modelValue'])
  const tinymceScriptSrc = '/tinymce/tinymce.min.js'
  const init = {
    height: 900,
    language_url: '/tinymce/langs/zh_CN.js',
    language: 'zh_CN',
    skin_url: '/tinymce/skins/ui/oxide', // 皮肤：这里引入的是public下的资源文件
    // skin_url: 'tinymce/skins/ui/oxide-dark',//黑色系
    content_css: '/tinymce/skins/content/default/content.css', //内容区域css样式
    content_style: "img {max-width:100%;height:auto}",
    plugins: 'save accordion lists advlist quickbars autolink link autosave charmap wordcount code codesample directionality emoticons fullscreen image insertdatetime nonbreaking pagebreak preview searchreplace table visualblocks formatpainter kityformula-editor',
    toolbar: `save undo redo restoredraft code pastetext formatpainter removeformat | forecolor backcolor styles blocks fontfamily fontsize bold italic underline strikethrough lineheight | alignleft alignright aligncenter alignjustify 
    outdent indent ltr rtl | bullist numlist | blockquote subscript superscript  | link table image charmap emoticons hr pagebreak insertdatetime | codesample kityformula-editor 
    | print preview fullscreen | wordcount nonbreaking searchreplace visualblocks custom-btn`,
    toolbar_mode: 'wrap', // 工具栏模式: floating sliding scrolling wrap
    menubar: true, // 菜单栏
    statusbar: true, // 是否显示底部状态栏
    auto_focus: true, // 自动聚焦
    branding: false, // 默认会在右下角显示Tiny图标
    promotion: false, // 隐藏upgrade按钮
    resize: true, // 改变宽高
    // 快速工具栏配置，需引入插件 quickbars
    quickbars_selection_toolbar: 'bold italic underline strikethrough', // 设置 快速选择 触发提供的工具栏 需引入插件  默认 'alignleft aligncenter alignright' 设置为false禁用
    quickbars_insert_toolbar: 'quickimage quicktable quicklink', // 设置 快速插入 触发提供的工具栏 需引入插件quickbars 默认 quickimage quicktable 设置为false禁用
    quickbars_image_toolbar: 'alignleft aligncenter alignright',
    save_onsavecallback: function () { 
        ElMessage({
            message: '已保存',
            type: 'success',
        })
     },
    automatic_uploads: true, // 禁止图片自动上传
    font_size_formats: '12px 14px 16px 18px 24px 36px 48px 56px 72px',
    font_family_formats:
      '微软雅黑=Microsoft YaHei,Helvetica Neue,PingFang SC,sans-serif;苹果苹方=PingFang SC,Microsoft YaHei,sans-serif;宋体=simsun,serif;仿宋体=FangSong,serif;黑体=SimHei,sans-serif;Arial=arial,helvetica,sans-serif;Arial Black=arial black,avant garde;Book Antiqua=book antiqua,palatino;Comic Sans MS=comic sans ms,sans-serif;Courier New=courier new,courier;Georgia=georgia,palatino;Helvetica=helvetica;Impact=impact,chicago;Tahoma=tahoma,arial,helvetica,sans-serif;Terminal=terminal,monaco;Times New Roman=times new roman,times;Verdana=verdana,geneva;Webdings=webdings;Wingdings=wingdings,zapf dingbats;',
    // setup: (editor: any) => {
    //   console.log(editor);
    //   editor.ui.registry.addButton("custom-btn", {
    //     text: "自定义按钮",
    //     icon: "ai",
    //     tooltip: '自定义按钮',
    //     onAction: function () {
    //       alert('点击自定义按钮')
    //     }
    //   })
    //   const onAction = (autocompleteApi: any, rng: any, value: any) => {
    //     editor.selection.setRng(rng);
    //     // editor.insertContent(value);
    //     // contenteditable=false 不可编辑，保证删除时#和内容为一个整体
    //     editor.insertContent(`<span style="color: blue;" contenteditable="false">#${value}</span><span>&nbsp;</span>`);
    //     autocompleteApi.hide();
    //   };
  
    //   const getMatchedChars = (pattern: any) => {
    //     return specialChars.filter(char => char.text.indexOf(pattern) !== -1);
    //   };
    //   /* 自动补全 */
    //   editor.ui.registry.addAutocompleter('specialchars_cardmenuitems', {
    //     trigger: '#',
    //     minChars: 0,
    //     columns: 1,
    //     highlightOn: ['char_name'],
    //     onAction: onAction,
    //     fetch: (pattern: any) => {
    //       return new Promise((resolve) => {
    //         const results = getMatchedChars(pattern).map(char => ({
    //           type: 'cardmenuitem',
    //           value: char.value,
    //           label: char.text,
    //           items: [
    //             {
    //               type: 'cardcontainer',
    //               direction: 'vertical',
    //               items: [
    //                 {
    //                   type: 'cardtext',
    //                   text: char.text,
    //                   name: 'char_name'
    //                 },
    //                 {
    //                   type: 'cardtext',
    //                   text: char.value
    //                 }
    //               ]
    //             }
    //           ]
    //         }));
    //         resolve(results);
    //       });
    //     }
    //   });
  
    // },
    // 初始化完成
    // init_instance_callback: (editor: any) => {
    //   console.log('初始化完成：', editor)
    //   editor.on('blur', (_e: any) => {
    //     alert('失焦保存')
    //     // var content = tinyMCE.activeEditor.getContent();
    //   })
    // },
    // 此处为自定义图片上传处理函数
    images_upload_handler: (blobInfo: any) => new Promise(async (resolve: any, reject: any) => {
      let file = blobInfo.blob()
      // 调接口
      console.log(file, resolve, reject, '==file')
      const formData = new FormData();
      formData.append("file", file)
      formData.append("token", token);
      const result = await uploadImg(formData)
      console.log(result.data);
      let url = result.data
      resolve(url)
    }),
    image_dimensions: false, // 是否显示图片尺寸
    image_advtab: true, // 图片高级功能
    lists_indent_on_tab: true, // 是否按tab键进入新的子列表
    link_context_toolbar: true,
    link_rel_list: [
      { title: 'No Referrer', value: 'noreferrer' },
      { title: 'External Link', value: 'external' }
    ],
    link_target_list: [
      { title: 'None', value: '' },
      { title: 'Same page', value: '_self' },
      { title: 'New page', value: '_blank' },
      { title: 'Parent frame', value: '_parent' }
    ],
    fullscreen_native: true,
    pagebreak_split_block: true,
    table_border_widths: [
      { title: 'small', value: '1px' },
      { title: 'medium', value: '3px' },
      { title: 'large', value: '5px' },
    ],
    table_toolbar: 'tableprops tabledelete | tableinsertrowbefore tableinsertrowafter tabledeleterow | tableinsertcolbefore tableinsertcolafter tabledeletecol tablecellborderwidth tablecellborderstyle',
  }
  // 组件挂载完毕
  onMounted(() => {
    tinymce.init({})
  })
  const specialChars = [
    { text: 'exclamation mark', value: '123' },
    { text: 'at', value: '456' },
    { text: 'hash', value: '789' },
  ]
  
  const textContent = ref(props.modelValue)
  watch(textContent, (newVal) => emit('update:modelValue', newVal))
  
  </script>
  
  <style scoped></style>