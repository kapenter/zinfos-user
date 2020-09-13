1.DRUID 1.0.25 跟



接口文档:

-----------------------------------------用户管理----------------------------------------
1.用户注册
URL	:     /userReg
Request Method: POST
"headers": 
"Content-Type: application/json; charset=utf-8 ;version=1.0.0"

    请求参数	
    {
    “mobile”;”17688917168”, 
     "address":"深圳市宝安区麻布新村坪洲地铁站"
    ”password”:"sfsdfsdfsfsdsdffsdfsdfs”
    }
    返回结果	注册成功
    {
    “code”:  200,  //成功
    “message”:”注册成功”,
    “data”:
    {
          “accessTokne”:”32325d-s2dae-2-3-32-23-32323”
    } 


2.登录接口
URL	:     /doLogin
Request Method: POST
"headers": 
"Content-Type: application/json; charset=utf-8 ;version=1.0.0"

    请求参数	
    {
    “mobile”;”17688917168”,
    ”password”:"sfsdfsdfsfsdsdffsdfsdfs”
    }
    返回结果	登录成功
    {
    “code”:  200,  //成功
    “message”:”登录成功”,
    “data”:
    {
          “accessTokne”:”32325d-s2dae-2-3-32-23-32323”
    } 

3.用户信息修改
URL	:     /updateUserInfo
Request Method: POST
"headers": 
"Content-Type: application/json; charset=utf-8 ;version=1.0.0"

    请求参数	
    {
    “sex”;”0”,
    "svuserface”:"xxx.img”,//非必填
    "svuserarea" :"用户所在地区", //非必填
    "svuseraddress": "用户详细地址"//非必填
    }
    返回结果	
    {
    “code”:  200,  //成功
    “message”:”用户信息修改成功”,
    “data”:{}
    }
-----------------------------------------快件管理----------------------------------------
-- 快件表
DROP TABLE IF EXISTS `sv_dd_storehouse_static`;
CREATE TABLE `sv_dd_goods_storehouse` (
  `svddsid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',  -- 通话记录里的requestid保存快件的id
  `svddsexpressno`  varchar(64) DEFAULT '' COMMENT '',  --  货物运单号
  `svddstelephone`  varchar(64) DEFAULT '' COMMENT '',  --  货物接收人电话号码
  `svddspickupno` varchar(64) DEFAULT '' COMMENT '', -- 货物货架号
  `svddstatus`  int(11) DEFAULT '0' COMMENT '',  --  0入库，1，出库
  `svddstime` datetime DEFAULT NULL,   -- 添加的时间
   svddpicktime datetime    DEFAULT NULL  --'取件时间',  
   svddremark varchar(32)   --备注(未取件原因  拒收原因  取件 备注 之类)
  PRIMARY KEY (`svddgsid`),
  UNIQUE KEY  (`svddexpressno`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;


4:快件--入库
       URL	:     express/add
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
       “expressNo”;”订单编号”,
        "mobile”:"176889168”,//必填
        "pickupNo" :"货物架号", //必填
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”快件入库成功”,
       “data”:{}
       }
       
4:快件--取件
       URL	:     express/update
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
       “state”;”1”, 取件状态
        "pickTime”:"2020-09-02 10:00:00”
        "remark" :"货物架号",  //备注
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”快件入库成功”,
       “data”:{}
       }
       
5:快件查询--查询
        URL	:     express/list
        Request Method:  POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
         请求参数	
          {
              “mobile”;"*7168”  //手机号码
          }
          返回结果	
          {
              “code”:  200,  //成功
              “message”:  "快件查询”,
              “data”:[
                  {"svddsexpressno":"1111","svddspickupno":"A-1-1".....},
                  {"svddsexpressno":"2222","svddspickupno":"A-1-2".....}
              ]
          }
          
          
-----------------------------------------模板管理----------------------------------------
----模板表
DROP TABLE IF EXISTS `sv_notice_temp`;
CREATE TABLE `sv_notice_temp` (
  `svtid` int(11) NOT NULL AUTO_INCREMENT COMMENT '语音模板ID',
  `svtname` varchar(256) DEFAULT NULL COMMENT '模版名',
  `svtcontext` varchar(4096) DEFAULT NULL COMMENT '模版内容',
  `svntsort` int(11) DEFAULT NULL COMMENT '系统TTS生成语音1，自定义为2',
  `svnnature` varchar(256) DEFAULT NULL COMMENT '所属企业账户',
  `svtsignature` varchar(256) DEFAULT NULL COMMENT '模板签名',
  `svtdate` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`svtid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=gbk COMMENT='语音模板表';

6:模板--新增
       URL	:     template/add
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
       “svtname”;”模板名称”,
        "svtcontext”:"模板内容”,
        "svtsignature" :"模板签名", 
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”模板新增成功”,
       “data”:{}
       }

7:模板--删除
       URL	:     template/delete
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
       “svtid”;”语音模板ID”,
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”删除模板成功”,
       “data”:{}
       }
       
       
7:模板--修改
       URL	:     template/update
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
        “svtid”;”语音模板ID”,
        “svtname”;”模板名称”,
         "svtcontext”:"模板内容”,
         "svtsignature" :"模板签名", 
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”修改模板成功”,
       “data”:{}
       }

8:模板--查询
       URL	:     template/list
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
        “svtname”;”模板名称”,//非必填
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”修改模板成功”,
      “data”:[
                        {"svtid":"1","svtname":"顺丰快递","svtcontext":"货号:{},快递号{},请到xxx拿快递".....},
                         {"svtid":"2","svtname":"圆通快递","svtcontext":"货号:{},快递号{},请到xxx拿快递".....}
               ]
       }
       
       
-----------------------------------------发送记录----------------------------------------

-- 叮当通知之快件统计
DROP TABLE IF EXISTS `sv_dd_storehouse_static`;
CREATE TABLE `sv_dd_storehouse_static` (
  `svddsid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',  -- id
  `svddsexpressno`  varchar(64) DEFAULT '' COMMENT '',  --  货物运单号
  `svddstelephone`  varchar(64) DEFAULT '' COMMENT '',  --  货物接收人电话号码
  `svddspickupno` varchar(64) DEFAULT '' COMMENT '', -- 货物货架号
  `svddstatus`  int(11) DEFAULT '0' COMMENT '',  --  0:已发送，1，接受 2:失败 3:回复
    svddaccount  varchar(32)  --发送账号
  `svddstime` datetime DEFAULT NULL,   -- 添加的时间
   svddpicktime datetime    DEFAULT NULL  --'取件时间',  
   svddtempid int           --模板id  
   type        int(2)     ,--发送方式  1:短信 2:群呼
   PRIMARY KEY (`svddgsid`),
   UNIQUE KEY  (`svddexpressno`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk;

8:发送记录--查询
       URL	:     sendRecords/list
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
        “startTime”;"开始时间”,//非必填
        “endTime”;"结束时间”, //非必填
        “type”;"发送方式”,    //1:短信 2:群呼
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”修改模板成功”,
      “data”:[
                        {"sent":"100","receive":"50","failure":"10".....},
                        {"已发送":"100","已接受":"50","失败":"10".....},
               ]
       }
       
       
       
       
       
-----------------------------------------分组管理----------------------------------------   
----分组表
DROP TABLE IF EXISTS `sv_dd_group`;
CREATE TABLE `sv_dd_group` (
  `svgid` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `svggourpname` varchar(256) DEFAULT NULL COMMENT '分组名称',
  `svgnnature` varchar(256) DEFAULT NULL COMMENT '所属账户',
  `svgcreatetime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT '创建时间',
  `svgmodifytime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT  '修改时间',
  PRIMARY KEY (`svgid`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=gbk COMMENT='分组表';

    
9:分组--新增
       URL	:     group/add
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
       “svggourpname ”;”分组名称”,
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”分组新增成功”,
       “data”:{}
       }

10:分组--删除
       URL	:     group/delete
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
       “svgid”;”分组ID”,
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”删除分组成功”,
       “data”:{}
       }
       
       
11:分组--修改
       URL	:     group/update
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
        “svgid”;”语音模板ID”,
         "svggourpname”;"分组名称”,
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”修改分组成功”,
       “data”:{}
       }

12:分组--查询
       URL	:     group/list
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
        
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”修改模板成功”,
       “data”:[
                        {"svgid":"1","svggourpname":"宝安区客户"},
                        {"svtid":"2","svggourpname":"福田区客户"}
               ]
       }
              
 
       
-----------------------------------------客户管理----------------------------------------
CREATE TABLE IF NOT EXISTS `sv_customer_fields` (
  `svcfid` int(11) NOT NULL AUTO_INCREMENT,
  `svcfname` varchar(64) NOT NULL default '',		-- 页面显示字段名称
  `svcftype` ENUM('int', 'decimal', 'varchar', 'date', 'datetime', 'time', 'text') NOT NULL DEFAULT 'varchar', -- 客户资料表字段类型
  `svcflength` int(11) NOT NULL DEFAULT '0',		-- 客户资料表字段长度(不一定需要)
  `svcfdefault` varchar(128) DEFAULT NULL,		-- 客户资料表字段默认值
  `svcfshowtype` ENUM('text', 'textarea', 'select', 'radio', 'checkbox', 'img', 'file', 'password', 'hidden') NOT NULL DEFAULT 'text',-- 页面显示字段类型
  `svcfinuse` tinyint(1) NOT NULL DEFAULT '1',		-- 自定义字段是否使用，默认1使用
  `svcfshowpage` SET('create', 'modify', 'list', 'popup', 'detail','import','export') NOT NULL DEFAULT 'detail', -- 在哪些页面里显示
  `svcfcreater` varchar(32) NOT NULL DEFAULT '',	-- 归属（按企业，企业及以下的所有客服都要使用这个字段）
  `svcfsort` int(11) NOT NULL DEFAULT '0',		-- 页面显示排序（自定义字段管理页面也将此字段排序）
  `svcfcreatetime` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `svcfcolname` varchar(64) NOT NULL default '',       -- 客户资料表中字段名(英文)
  `svcfmark` varchar(128) NOT NULL default '',	       -- 备注 
  PRIMARY KEY (`svcfid`)
) ENGINE=InnoDB DEFAULT CHARSET=gbk AUTO_INCREMENT=1;


13:客户--新增
       URL	:     customer/add
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
           “groupId”：分组的ID    //必填
           “mobile”：手机号 //必填
           “name”：姓名 //必填
           “remark” : 备注 
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”客户新增成功”,
       “data”:{}
       }

14:客户--新增
       URL	:     customer/修改
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
           “id”：1   //客户ID
           “groupId”：分组的ID    //必填
           “mobile”：手机号 //必填
           “name”：姓名 //必填
           “remark” : 备注 
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”客户修改成功”,
       “data”:{}
       }
        
 15:客户--查询
        URL	:     customer/修改
        Request Method: POST
        "headers": 
        "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
        
        请求参数	
        {
            “name”：”周“   //客户名
            “moobile”：”7168“  //手机号码   
        }
        返回结果	
        {
        “code”:  200,  //成功
        “message”:”客户查询成功”,
        “data”:{
                “id”：1   //客户ID
               “groupId”：分组的ID    //必填
               “mobile”：手机号 //必填
               “name”：姓名 //必填
               “remark” : 备注 
            }
        } 
        
        
 16:客户--删除
        URL	:     customer/delete
        Request Method: POST
        "headers": 
        "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
        
        请求参数	
        {
            “id”：”1“   //客户id
        }
        返回结果	
        {
            “code”:  200,  //成功
            “message”:”客户删除成功”,
            “data”:{}
        } 

-----------------------------------------短信通知(调用短信接口)----------------------------------------   
 17:短信--发送
            URL	:     smsApi/sent
            Request Method: POST
           "headers": 
           "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
           
           请求参数	
           [{
               “smstemp”：”1“   //短信模板id
               “contextparam”：”短信验证码为：10086“   //内容
               “company”：”泽讯科技“   
               “keytime”：”时间戳“  
               “key”：”加密内容“   
               “callingline”：”被叫“   
               “datetime”：”定时发送时间“   
           },
           {
               “smstemp”：”1“   //语音模板id
               “contextparam”：”短信验证码为：10086“   //内容
               “company”：”泽讯科技“   
               “keytime”：”时间戳“  
               “key”：”加密内容“   
               “callingline”：”被叫“   
               “datetime”：”定时发送时间“  
           } 
           ]
           返回结果	
           {
               “code”:  200,  //成功
               “message”:”发送成功”,
               “data”:{}
           } 

  
-----------------------------------------语音通知(调用语音接口)----------------------------------------     
 18:语音--发送
        URL	:     noticeApi/sent
        Request Method: POST
        "headers": 
        "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
        
        请求参数	
        [{
            “company”：”泽讯科技“   
            “keytime”：”时间戳“  
            “key”：”加密内容“   
            “callingline”：”被叫“  
             “telno”：”主叫号码“   
             “sex”：”声音类型“   
             “requestid”：”唯一请求id“  --货物id 
             “userid”：”客户唯一请求id“  
             “ivr”：”ivr参数“ 
             “svbip”：”绑定ip“ 
             “playnum”：”播放次数“ 
        },
        {
            “company”：”泽讯科技“   
            “keytime”：”时间戳“  
            “key”：”加密内容“   
            “callingline”：”被叫“  
             “telno”：”主叫号码“   
             “sex”：”声音类型“   
             “requestid”：”唯一请求id“  --货物id 
             “userid”：”客户唯一请求id“  
             “ivr”：”ivr参数“ 
             “svbip”：”绑定ip“ 
             “playnum”：”播放次数“ 
        } 
        ]
        返回结果	
        {
            “code”:  200,  //成功
            “message”:”发送成功”,
            “data”:{}
        } 

 
 ------------发送通知表-----------------
 CREATE TABLE IF NOT EXISTS `svdd_sent_notice` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `item_number_mode` int(2) ,		-- 货号模式
   `type` int(2), -- 类型  0:草稿 1:定时
   `open_call` int(2) NOT NULL DEFAULT '0',		-- 0:不开启 1:开启
   `temp_id` int(16) not null,		-- 模板id
   `sent_type` int(2)  not null ,--0:短信发送 1:语音发送 
   `creater` varchar(32) NOT NULL DEFAULT '',	-- 创建人
   `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 创建时时间
   `modify` varchar(64) NOT NULL default '',       -- 修改人
   `modify_time` varchar(128) NOT NULL default '',	       -- 修改时间 
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=gbk AUTO_INCREMENT=1;
 
 
 ------------发送号码表-----------------
  CREATE TABLE IF NOT EXISTS `svdd_sent_mobile` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `mobile` varchar2(32) ,		-- 手机号码
    `order_no` varchar2(32) ,		-- 订单号码
    `shelf_no` varchar2(32) ,		-- 货架号码
    `send_status` int(2), -- 类型  0:未发送 1:已发送
    `flg` int(2), -- 类型  0:新客户 1:老客户
    `notice_id` int(16) not null,		-- 发送通知表id
    `creater` varchar(32) NOT NULL DEFAULT '',	-- 创建人
    `create_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 创建时时间
    `modify` varchar(64) NOT NULL default '',       -- 修改人
    `modify_time` varchar(128) NOT NULL default '',	       -- 修改时间 
    PRIMARY KEY (`id`)
  ) ENGINE=InnoDB DEFAULT CHARSET=gbk AUTO_INCREMENT=1;