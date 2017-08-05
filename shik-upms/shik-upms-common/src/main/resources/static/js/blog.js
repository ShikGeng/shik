var form, layer;
layui.use(['layer', 'form'], function () {
    layer = layui.layer;
    form = layui.form();

    //自定义验证规则
    form.verify({
        title: function (value) {
            if (value.length < 5) {
                return '标题至少得5个字符啊';
            }
        }
    });

    //监听提交
    form.on('submit(save_blog)', function (data) {

        $('input[name=content]').val($("#summernote").summernote('code'));

        // $(data.form).submit();

    });
});

/**
 * 编辑
 * @param id
 */
function edit(id) {
    location.href = '/admin/blog/' + id + '/edit';
}

/**
 * add group
 */
function group_add() {
    layer.open({
        type: 2,
        title: '添加分组',
        closeBtn: 0,
        shadeClose: true,
        area: ['35%', '90%'],
        content: '/admin/group/add'
    });
}

/**
 * 页面初始化
 */
$(function () {
    /**
     * 初始化一个summernote
     */
    $('#summernote').summernote({
        lang: 'zh-CN', // default: 'en-US'
        height: 300,                 // set editor height
        minHeight: null,             // set minimum height of editor
        maxHeight: null,             // set maximum height of editor
        focus: false,                  // set focus to editable area after initializing summernote});
//            toolbar: [
//                // [groupName, [list of button]]
//                ['style', ['bold', 'italic', 'underline', 'clear']],
//                ['font', ['strikethrough', 'superscript', 'subscript']],
//                ['fontsize', ['fontsize']],
//                ['color', ['color']],
//                ['para', ['ul', 'ol', 'paragraph']],
//                ['height', ['height']]
//            ]
    });
})

