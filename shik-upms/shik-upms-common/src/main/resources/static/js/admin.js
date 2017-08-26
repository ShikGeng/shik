/**
 *
 * @author gengshikun
 * @date 2016/12/12
 */
layui.use(['form', 'layer', 'laypage', 'jquery'], function () {
    var form = layui.form;
        layer = parent.layer === undefined ? layui.layer : parent.layer;
        $ = layui.jquery;
        laypage = parent.laypage === undefined ? layui.laypage : parent.laypage;

    //完整功能
    laypage.render({
        elem: 'shik_page'
        ,count: 100
        ,layout: ['count', 'prev', 'page', 'next', 'skip']
        ,jump: function(obj){
            console.log(obj)
        }
    });

    // admin_submit
    form.on('submit(admin_submit)', function(data){
        console.log(data.elem) //被执行事件的元素DOM对象，一般为button对象
        console.log(data.form) //被执行提交的form对象，一般在存在form标签时才会返回
        console.log(data.field) //当前容器的全部表单字段，名值对形式：{name: value}

        $.post('/admin/save', data.field, function(){
            closeIframe();
            parent.location.reload(); // 刷新
        }, 'json');
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    $('.admin_add').click(function() {
        layer.open({
            type: 2,
            title: '管理员添加',
            content: ['/admin/add', 'no'],
            area: ['440px', '220px']
        });
    });

    $('.cancel').click(function() {
        closeIframe();
    })

    function closeIframe() {
        var index = layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        layer.close(index); //再执行关闭
    }
});