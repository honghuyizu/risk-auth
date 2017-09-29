package com.risk.common.utils;

import javax.ws.rs.core.Response;

/**
 */
public class IConstant {


    //手机正则表达式
    public static final String SHOUJI_REGEXP = "^[1][34578]\\d{9}$";
    //邮箱正则表达式
    public static final String YOUXIANG_REGEXP = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
    //用户名-必须包含字母、数字、下划线至少两种(可以是纯字母)
    public static final String ZMSZXHX_REGEXP = "^(?![0-9]+$)(?![_]+$)[a-zA-Z0-9_]{8,16}$";
    //验证登录名称是否是手机号、邮箱、用户名
    public static final String DENGLUNAME_REGEXP = ZMSZXHX_REGEXP + "|" + SHOUJI_REGEXP + "|" +YOUXIANG_REGEXP;
    //必须包含字母、数字、符号至少两种
    public static final String ZMSZFH_REGEXP = "^(?![a-zA-z]+$)(?!\\d+$)(?![!@#$%^&*]+$)[a-zA-Z\\d!@#$%^&*]+$";
    //验证15为数字
    public static final String SHUZI15_REGEXP = "^\\d{15}$";
    //验证身份证号15位、18位以及X结尾
    public static final String SFZH_REGEXP = "(^\\d{15}$)|(^\\d{17}([0-9]|X)$)";

    //公司相册
    public static final String GONGSI_XIANGCE = "公司相册";
    //资质证明
    public static final String ZIZHI_ZHENGMING = "资质证明";
    //栏目动态
    public static final String DONGTAI = "动态";
    //设备相册
    public static final String SHEBEI = "设备";
    //redis锁定标签
    public static final String REDIS_FLAG = "dengLuSuo:";

    /**
     * 自定义状态码枚举
     */
    public enum Status {

        JIHUO_CHENGGONG("1006", "激活成功", Response.Status.OK),
        WEITIJIAO_SHENHE("1005", "未提交审核", Response.Status.OK),
        RENZHENG_CHENGGONG("1004", "认证成功", Response.Status.OK),
        DENGLU_CHENGGONG("1003", "登录成功", Response.Status.OK),
        ZHUCE_CHENGGONG("1002", "注册成功", Response.Status.CREATED),
        YONGHUMING_BUCUNZAI("1001", "用户名不存在", Response.Status.OK),
        SHOUJIHAO_BUCUNZAI("1000", "手机号不存在", Response.Status.OK),
        FASONG_CHENGGONG("4", "发送成功", Response.Status.OK),
        XINZENG_CHENGGONG("3", "新增成功", Response.Status.CREATED),
        SHANCHU_CHENGGONG("2", "删除成功", Response.Status.CREATED),
        XIUGAI_CHENGGONG("1", "修改成功", Response.Status.ACCEPTED),
        CHAXUN_CHENGGONG("0", "查询成功", Response.Status.OK),
        CANSHU_CUOWU("-1", "参数错误", Response.Status.BAD_REQUEST),
        HOUTAI_YICHANG("-2", "后台异常", Response.Status.INTERNAL_SERVER_ERROR),
        SHUJU_BUCUNZAI("-3", "数据不存在", Response.Status.NOT_FOUND),
        YONGHUMING_CUNZAI("-1000", "用户名已存在", Response.Status.BAD_REQUEST),
        SHOUJIHAO_CUNZAI("-1001", "手机号已存在", Response.Status.BAD_REQUEST),
        ZHANGHAO_BUCUNZAI("-1002", "账号不存在", Response.Status.NOT_FOUND),
        ZHANGHAO_SUODING("-1003", "密码错误6次，账号已锁定", Response.Status.UNAUTHORIZED),
        MIMA_CUOWU("-1004", "密码错误", Response.Status.FORBIDDEN),
        RENZHENG_SHIBAI("-1005", "认证未通过", Response.Status.BAD_REQUEST),
        RENZHENG_YISHENQING("-1006", "您已申请过实名认证", Response.Status.BAD_REQUEST),
        BANGDINGSHOUJI_BUTONG("-1007", "不能与绑定手机相同", Response.Status.BAD_REQUEST),
        XIANGCEMING_CUNZAI("-1008", "相册名称已存在", Response.Status.BAD_REQUEST),
        MIMA_YIZHI("-1009", "密码一致", Response.Status.BAD_REQUEST),
        MIBAOSHOUJI_BUTONG("-1010", "不能与密保手机相同", Response.Status.BAD_REQUEST),
        SHOUJIHAO_CHONGFU("-1011", "手机号重复", Response.Status.BAD_REQUEST),
        MEIYOUSHUJU_QUANXIAN("-1012", "没有数据权限", Response.Status.BAD_REQUEST),
        DUANXINMOBAN_CUOWU("-1013", "短信模板错误", Response.Status.BAD_REQUEST),
        QYLEIMUGUANXI_CUNZAI("-1014", "企业会员类目关系已存在", Response.Status.BAD_REQUEST),
        YEZI_LEIMU("-1015", "类目必须为叶子类目", Response.Status.BAD_REQUEST),
        SHUJU_YICUNZAI("-1016", "存在", Response.Status.BAD_REQUEST),
        BUMEN_JIBIEBUTONG("-1017", "部门不在同一级别", Response.Status.BAD_REQUEST),
        YOUXIANG_CHONGFU("-1018", "邮箱重复", Response.Status.BAD_REQUEST),
        YOUJIANMOBAN_CUOWU("-1019", "邮件模板编号错误", Response.Status.BAD_REQUEST),
        YOUXIANG_YIZHANYONG("-1020", "邮箱已占用", Response.Status.BAD_REQUEST),
        YOUXIANG_YIRENZHENG("-1021", "邮箱已认证", Response.Status.BAD_REQUEST),
        JIHUO_SHIBAI("-1022", "激活失败", Response.Status.BAD_REQUEST),
        YONGHU_YIJIHUO("-1023", "已激活", Response.Status.BAD_REQUEST),
        ZHANGHAO_TINGYONG("-1024", "账号已停用", Response.Status.BAD_REQUEST),
        TOUZI_SHIBAI("-1025", "投资失败", Response.Status.BAD_REQUEST),
        CHEDAN_SHIBAI("-1026", "不可以撤单", Response.Status.BAD_REQUEST),
        CHONGFU_ZHIFU("-1027", "重复支付", Response.Status.BAD_REQUEST),
        TIAOZHANGSHENQING_CHENGGONG("-1028","调账申请提交成功",Response.Status.OK),
        TIAOZHANGSHENQING_SHIBAI("-1029","调账申请提交失败",Response.Status.OK);
        /**
         * 状态码
         */
        private final String zhuangTaiMa;
        /**
         * 状态码含义
         */
        private final String hanYi;
        /**
         * HTTP响应码
         */
        private final Response.Status httpStatus;

        Status(String zhuangTaiMa, String hanYi, Response.Status httpStatus) {
            this.zhuangTaiMa = zhuangTaiMa;
            this.hanYi = hanYi;
            this.httpStatus = httpStatus;
        }

        public String getZhuangTaiMa() {
            return zhuangTaiMa;
        }

        public String getHanYi() {
            return hanYi;
        }

        public String getHanYi(String miaoShu) {
            return miaoShu+hanYi;
        }


        public Response.Status getHttpStatus() {
            return httpStatus;
        }

        public String getStatLog() {
            return this.getHanYi() + ",状态码[" + this.getZhuangTaiMa() + "]";
        }
    }

}
