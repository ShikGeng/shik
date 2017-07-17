/**
 * ━━━━━━神兽出没━━━━━━
 * 　　　┏┓　　　┏┓
 * 　　┏┛┻━━━┛┻┓
 * 　　┃　　　　　　　┃
 * 　　┃　　　━　　　┃
 * 　　┃　┳┛　┗┳　┃
 * 　　┃　　　　　　　┃
 * 　　┃　　　┻　　　┃
 * 　　┃　　　　　　　┃
 * 　　┗━┓　　　┏━┛
 * 　　　　┃　　　┃神兽保佑, 永无BUG!
 * 　　　　┃　　　┃Code is far away from bug with the animal protecting
 * 　　　　┃　　　┗━━━┓
 * 　　　　┃　　　　　　　┣┓
 * 　　　　┃　　　　　　　┏┛
 * 　　　　┗┓┓┏━┳┓┏┛
 * 　　　　　┃┫┫　┃┫┫
 * 　　　　　┗┻┛　┗┻┛
 * ━━━━━━感觉萌萌哒━━━━━━
 */
package com.shik.constant;

/**
 * @author gengshikun
 * @date 2016/12/10
 */
public class SysConstants {

    public static final String URL_CHARSET = "UTF-8";

    /********************** permission type start ************************/
    /**
     * 系统
     */
    public static final String PERMISSION_TYPE_A01 = "A01";
    /**
     * 菜单
     */
    public static final String PERMISSION_TYPE_A02 = "A02";
    /**
     * 按钮
     */
    public static final String PERMISSION_TYPE_A03 = "A03";
    /********************** permission type end ************************/

    /********************** group type start ************************/
    public static final String GROUP_TYPE_ALL = "B00"; //全部分组
    public static final String GROUP_TYPE_BLOG = "B01"; //blog
    /********************** group type end ************************/


    /********************** sort 字段 start ************************/
    public static final String SORT_ASC = "asc"; // 升序
    public static final String SORT_DESC = "desc"; // 降序

    public static final Integer SORT_PAGE_NUMBER = 5; // 通用分页数

    public static final String SORT_CREATE_TIME = "createTime";
    /********************** sort 字段 end ************************/


    /************************** amqp start ****************************/
    public static final String AMQP_DEFAULT_EXCHANGE = "spring-boot-exchange";  // 使用同一个交换机


    public static final String AMQP_ROUTINGKEY_DEFAULT = "spring-boot-routingKey";
    public static final String AMQP_QUEUE_DEFAULT = "spring-boot-queue";

    public static final String AMQP_ROUTINGKEY_MAP = "spring-boot-routingKey-map";
    public static final String AMQP_QUEUE_MAP = "spring-boot-queue-map";
    /************************** amqp end ****************************/

    /******************************文件类型 start*********************************/
    /**
     * 图片
     */
    public static final String FILE_TYPE_IMAGE = "image";
    /**
     * WORD
     */
    public static final String FILE_TYPE_WORD = "word";
    /**
     * PPT
     */
    public static final String FILE_TYPE_PPT = "ppt";
    /**
     * PDF
     */
    public static final String FILE_TYPE_PDF = "pdf";
    /**
     * EXCEL
     */
    public static final String FILE_TYPE_EXCEL = "excel";
    /**
     * 其他
     */
    public static final String FILE_TYPE_OTHER = "other";
    /******************************文件类型 end***********************************/

    /****************************** WeChat start ***********************************/
    public static final String WE_CHAT_STATE_KEY = "zkgengkun_wechat_key";
    /****************************** WeChat end ***********************************/
}
