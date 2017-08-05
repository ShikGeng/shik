/**
 * layui Module initialization
 *
 * @author gengshikun
 * @date 2016/12/12
 */

layui.config({
    dir: 'http://bxu2359710744.my3w.com/static/libs/layui/1.0.7/' //layui.js 所在路径（注意，如果是script单独引入layui.js，无需设定该参数。），一般情况下可以无视
    , version: false //一般用于更新组件缓存，默认不开启。设为true即让浏览器不缓存。也可以设为一个固定的值，如：201610
    , debug: false //用于开启调试模式，默认false，如果设为true，则JS模块的节点会保留在页面
    , base: '../../static/js/' //设定扩展的Layui组件的所在目录，一般用于外部组件扩展
}).extend({ //设定组件别名
    test: 'test' //如果test.js是在根目录，也可以不用设定别名
    , test1: '../libs/test1' //相对于上述base目录的子目录
});
