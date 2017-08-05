var form, layer;
layui.use(['form', 'layer'], function () {
    form = layui.form();
    layer = layui.layer;

    form.on("submit(submit)", function (data) {
        $.ajax({
            url: "/auth/geetest/verify",
            type: 'post',
            data: data.field,
            dataType: "json",
            async: false,
            success: function (result) {
                console.log(result);
                if (result) {
                    if (result.status) {
                        $.ajax({
                            url: "/auth/login",
                            type: 'post',
                            data: data.field,
                            dataType: "json",
                            async: false,
                            success: function (result) {
                                if (result) {
                                    if (result.status) {
                                        location.href = result.returnUrl;
                                    } else {
                                        layer.msg(result.msg, {icon: 5, anim: 6});
                                        initGT();
                                    }
                                }
                            }
                        });
                    } else {
                        layer.msg("验证码错误", {icon: 5, anim: 6});
                        initGT();
                    }
                }
            }
        });
        return false;
    });

});

$('input[name="password"]').focus(function () {
    $(this).attr('type', 'password');
});

$(function () {
    initGT();
})

var handler1 = function (captchaObj) {
    $("#submit1").click(function (e) {
        var result = captchaObj.getValidate();
        if (!result) {
            $("#notice1").show();
            setTimeout(function () {
                $("#notice1").hide();
            }, 2000);
            e.preventDefault();
        }
    });
    // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
    $('#captcha1').empty();
    captchaObj.appendTo("#captcha1");
    captchaObj.onReady(function () {
        $("#wait1").hide();
    });
    // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
};

// 初始化极验
function initGT() {
    $.ajax({
        url: "/auth/geetest/register?t=" + (new Date()).getTime(), // 加随机数防止缓存
        type: "get",
        dataType: "json",
        success: function (data) {
            // 调用 initGeetest 初始化参数
            // 参数1：配置参数
            // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
            initGeetest({
                gt: data.gt,
                challenge: data.challenge,
                new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
                offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
                product: "float", // 产品形式，包括：float，popup
                width: "302px"
                // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
            }, handler1);
        }
    });
}

