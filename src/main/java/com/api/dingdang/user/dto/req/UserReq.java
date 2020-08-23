package com.api.dingdang.user.dto.req;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;

@Data
public class UserReq  implements Serializable{

    /**  */
    private Integer svuserid;

    /** 用户注册的手机号 */
    private String svuserteleno;

    /** 余额，可能不准确，以函数query_leftmoney为准 */
    private BigDecimal svuserleftmoney;

    /** 已充值金额 */
    private BigDecimal svusertotalmoney;

    /** 有效期随着绑定卡的时长增加  */
    private Integer svuserlifeday;

    /** 用户过期时间 */
    private Date svuserexpireday;

    /** 注册到系统时间 */
    private Date svusergenday;

    /** 用户状态 0-正常，-1禁止使用 */
    private Integer svuserstate;

    /** 用户是从哪台服务器上注册的 */
    private String svuserbandfromip;

    /** 用户一号通号码,或集团网短号 */
    private String svuseruptnumber;

    /** 所属集团网 */
    private String svuserbloc;

    /** 用户登录密码 */
    private String svuserpasswd;

    /** 最开始用在用户在支付这块的归属哪个代理，演变成用户归属哪个代理 */
    private String svuserpaybloc;

    /** 用户名 */
    private String svusername;

    /** 用户是否已经认领 */
    private Integer svuserisbloc;

    /** 用户用来显示的号码 */
    private String svuserddisplaycaller;

    /** 用户是否需要录音 */
    private Integer svuserisneedmixmontor;

    /** 用户是否需要生成软电话帐号，默认不生成 */
    private Integer svuserisneedsip;

    /** 用户第二号码透传号码 */
    private String svusersecuptnumber;

    /** 用户由谁推广的 */
    private String svuserspreaduid;

    /** 用户电话跟进随号码 */
    private String svuserfollowme;

    /** 自动群呼，并发线路，0不限制 */
    private Integer svuserccsimul;

    /** 自动群呼项目延时默认值 */
    private Integer svuserccprojdelay;

    /** 用户项目默认每天规定的开始时间 */
    private Time svuserccprojstarttime;

    /** 用户项目默认每天规定的结束时间 */
    private Time svuserccprojendtime;

    /** 分机编号 */
    private String svuserextenno;

    /** 用户备注 */
    private String svusernote;

    /** 用户角色类型	3：默认是散户，需要扣费，4、呼叫中心坐席，5、班长 */
    private Integer svusertype;

    /** 用户的并发项目数(0不限制) */
    private Integer svusersimuprojnum;

    /** 用户是否需要语音信箱，0：不需要,1:需要留言 */
    private Integer svuserneedmailbox;

    /** 用户留言时的语音信箱 */
    private String svusermailbox;

    /** 用户运营商归属(0:未知,1:移动，2:电信，3:联通) */
    private Integer svusercarrier;

    /** 用户角色类型 */
    private Integer roletype;

    /** 默认为1:普通回玲 0:SIP拨打 2:热线直拨 */
    private Integer svusercalltype;

    /** 客服表 增加一个分配号码字段 */
    private String svusertelnature;

    /** 是否弹屏 */
    private Integer svuserpopup;

    /** 短信扩展码   ;挪车项目存放：车牌号 */
    private String subextno;

    /** 用户扩展参数 挪车项目存放：微信ID */
    private String svuserparam;

    /** 用户弹屏接口与外界系统的互换。比如外界系统用户id为abc，当外界系统传入abc时，可以通过abc找到该分机，进行弹屏 */
    private String svuserotherid;

    /** 用户自动示闲 */
    private Integer svuserautoidle;

    /** 用户的AI机器人并发数 */
    private Integer svusersimuainum;

    /** 用户所在地区 */
    private String svuserarea;

    /** 用户详细地址 */
    private String svuseraddress;

    /** 用户头像 */
    private String svuserface;

    /** 用户性别 */
    private Integer svusersex;
}
