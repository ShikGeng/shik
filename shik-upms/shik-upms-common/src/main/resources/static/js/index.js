/**
 *
 * @author gengshikun
 * @date 2016/12/12
 */
layui.config({
    dir: 'http://static.shik.com:1180/layui/' //layui.js 所在路径（注意，如果是script单独引入layui.js，无需设定该参数。），一般情况下可以无视
    ,version: false //一般用于更新模块缓存，默认不开启。设为true即让浏览器不缓存。也可以设为一个固定的值，如：201610
    ,debug: false //用于开启调试模式，默认false，如果设为true，则JS模块的节点会保留在页面
    ,base: '' //设定扩展的Layui模块的所在目录，一般用于外部模块扩展
}).use(['layer', 'jquery', 'element', 'laypage', 'form'], function () {
    var layer = layui.layer;
        element = layui.element;
        $ = layui.jquery;
    // 左侧导航点击
    $(".layui-nav .layui-nav-item").on("click", 'a', function(){
        var shik_url = $(this).attr('shik_url');
        var shik_name = $(this).text();

        if(shik_url === undefined){
            return ;
        }

        if($('li[lay-id="'+shik_url+'"]').is('li')){
            // tab已存在
            element.tabChange('shik_tab', shik_url);
        } else {
            // tab不存在
            $.ajax({
                url: shik_url,
                dataType: 'html',
                success: function(html) {
                    element.tabAdd('shik_tab', {
                        title: shik_name,
                        content: "<iframe src='"+shik_url+"' data-id='"+shik_url+"'></frame>", //支持传入html
                        id: shik_url
                    });
                    element.tabChange('shik_tab', shik_url);
                }
            });
        }
    });

    // 监听鼠标点击tab事件
    $('.layui-tab .layui-tab-title').on('mousedown', 'li', function(event){
        // console.log(event.button); // 0:左键 1:滚轮 2:右键
        var index = $(this).parent().children().index($(this)); // 获取当前tab下标
        if(index == 0) {
            // 首页没有右键菜单
            return ;
        }
        var x = event.originalEvent.x || event.originalEvent.layerX || 0; // 获得鼠标点击位置
        var y = event.originalEvent.y || event.originalEvent.layerY || 0; // 获得鼠标点击位置
        if(event.button == 2){
            // 右键添加菜单
            var menu = '<ul class="layui-nav layui-nav-tree" lay-filter="shik_right_nav" shik_index="'+index+'">'+
                '<li class="layui-nav-item"><a href="javascript:;">刷新当前</a></li>'+
                '<li class="layui-nav-item"><a href="javascript:;">关闭当前</a></li>'+
                '<li class="layui-nav-item"><a href="javascript:;">关闭其他</a></li>'+
                '</ul>';
            var shik_right_nav_index = layer.open({
                type: 1,
                title: false,
                resize: false,
                move: false,
                shadeClose: true,
                closeBtn: false,
                content: menu,
                offset: [y+'px', x+'px']
            });
            // 初始化菜单
            element.init();
            element.on('nav(shik_right_nav)', function(data){
                var index = data.parent().children().index(data);
                var tab_index = data.parent().attr('shik_index');
                var tab_li = $('.layui-tab .layui-tab-title').children().get(tab_index);
                var tab_div = $('.layui-tab .layui-tab-content').children().get(tab_index);
                switch (index) {
                    case 0 :
                        var shik_url = $(tab_li).attr('lay-id');
                        $(tab_div).html("<iframe src='"+shik_url+"' data-id='"+shik_url+"'></frame>");
                        break; // 刷新当前
                    case 1 :
                        element.tabDelete('shik_tab', $(tab_li).attr('lay-id')); //删除 lay-id="xxx" 的这一项
                        break; // 关闭当前
                    case 2 :
                        $(tab_li).siblings().each(function(){
                            element.tabDelete('shik_tab', $(this).attr('lay-id'));
                        });
                        break; // 关闭其他
                }
                layer.close(shik_right_nav_index);

                listenerTab();
            });
        }
    });

    // 禁用鼠标右键
    $(document).on("contextmenu",function(){
        return false;
    });

    // tab与nav关联
    function listenerTab() {
        var shik_url = $('.layui-tab .layui-tab-title .layui-this').attr('lay-id');
        var $this_nav = $('.layui-nav-tree .layui-nav-child a[shik_url="'+shik_url+'"]').parent();
        $this_nav.addClass('layui-this').siblings().removeClass('layui-this');
    }

});