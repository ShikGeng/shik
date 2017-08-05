/**
 * 通知
 */
$('.header .user .msg').hover(
    function () {
        $(this).children('.msg-info').fadeIn("fast");
    },
    function () {
        $(this).children('.msg-info').fadeOut("fast");
    }
);

/**
 * 用户名
 */
$('.header .user .info').hover(
    function () {
        $(this).children('.user-operation').fadeIn("fast");
    },
    function () {
        $(this).children('.user-operation').fadeOut("fast");
    }
);