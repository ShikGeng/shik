/**
 *
 * @author gengshikun
 * @date 2016/12/12
 */
layui.use(['form', 'layer', 'jquery', 'laypage'], function () {
    console.log(parent.layer === undefined)
    var form = layui.form;
        layer = layui.layer;
        $ = layui.jquery;
        laypage = layui.laypage;

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
        $.post('/admin/save', data.field, function(){
            closeIframe();
            parent.location.reload(); // 刷新
        }, 'json');
        return false; //阻止表单跳转。如果需要表单跳转，去掉这段即可。
    });

    $('.admin_add').on('click', function() {
        layer.open({
            type: 2,
            title: '管理员添加',
            content: ['/admin/add', 'no'],
            area: ['440px', '220px']
        });
    });

    $('.admin_cancel').on('click', function() {
        closeIframe();
    })

    function closeIframe() {
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index); //再执行关闭
    }
});