/**
 index.js 项目 JS 主入口
 以依赖 layui 的 layer 和 form 模块为例
 **/
// 模块和回调函数
// 一般直接写在一个js文件中
layui.use(['layer', 'form','element'], function(){
    var layer = layui.layer
        ,form = layui.form;

    layer.msg('Hello World');
});