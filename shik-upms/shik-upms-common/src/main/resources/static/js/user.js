var form, layer;
layui.use(['form', 'layer', 'upload'], function () {
    form = layui.form();
    layer = layui.layer;

    layui.upload({
        url: '/admin/upload/image'
        , elem: '#test' //指定原始元素，默认直接查找class="layui-upload-file"
        , method: 'post' //上传接口的http类型
        , success: function (res) {
            console.log(res[0].data);
            $('input[name="fileUrl"]').val(res[0].fileUrl);
            LAY_demo_upload.src = res[0].data;
        }
    });
});

