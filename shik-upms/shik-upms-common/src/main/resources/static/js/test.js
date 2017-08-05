/**
 *
 * @author gengshikun
 * @date 2016/12/12
 */
/**
 扩展一个test组件
 **/
layui.define(function (exports) { //提示：组件也可以依赖其它组件，如：layui.define('layer', callback);
    var obj = {
        hello: function (str) {
            layer.msg('Hello ' + (str || 'test'));
        }
    };

    //输出test接口
    exports('test', obj);
});