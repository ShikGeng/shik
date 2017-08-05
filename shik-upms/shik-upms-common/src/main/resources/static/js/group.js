var form, layer;
layui.use(['form', 'layer'], function () {
    form = layui.form();
    layer = layui.layer;

    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 5) {
                return '标题至少得5个字符啊';
            }
        }
        , pass: [/(.+){6,12}$/, '密码必须6到12位']
        , content: function (value) {
            layedit.sync(editIndex);
        }
    });

    //监听提交
    form.on('submit(submit)', function (data) {

        $('input[name=content]').val($("#summernote").summernote('code'));

    });
});

