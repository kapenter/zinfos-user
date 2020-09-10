1.DRUID 1.0.25 跟



接口文档:

-----------------------------------------用户管理----------------------------------------
1.用户注册
URL	:     user/reg
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
    2.1:短信/密码登录
    URL	:     user/doLogin
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
        
    2.2:短信/验证码登录
    URL	:     user/verifyLogin
    Request Method: POST
    "headers": 
    "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
        请求参数	
        {
        “mobile”;”17688917168”,
        ”verifyCode”:"163526”
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
URL	:     user/updateInfo
Request Method: POST
"headers": 
"Content-Type: application/json; charset=utf-8 ;version=1.0.0"

    请求参数	
    {
    “sex”;”0”,
    "userFace”:"xxx.img”,//非必填
    "userArea" :"用户所在地区", //非必填
    "userAddress": "用户详细地址"//非必填
    }
    返回结果	
    {
    “code”:  200,  //成功
    “message”:”用户信息修改成功”,
    “data”:{}
    }
-----------------------------------------快件管理----------------------------------------
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
              “message”:  "快件查询成功”,
              “data”:[
                  {"svddsexpressno":"1111","svddspickupno":"A-1-1".....},
                  {"svddsexpressno":"2222","svddspickupno":"A-1-2".....}
              ]
          }
          
          
-----------------------------------------模板管理----------------------------------------
6:模板--新增
       URL	:     template/add
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
       “name”;”模板名称”,
        "context”:"模板内容”,
        "signature" :"模板签名", 
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
       “id”;”语音模板ID”,
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
        “id”;”语音模板ID”,
        “name”;”模板名称”,
         "context”:"模板内容”,
         "signature" :"模板签名", 
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
        “name”;”模板名称”,//非必填
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”查询模板成功”,
      “data”:[
                        {"svtid":"1","svtname":"顺丰快递","svtcontext":"货号:{},快递号{},请到xxx拿快递".....},
                         {"svtid":"2","svtname":"圆通快递","svtcontext":"货号:{},快递号{},请到xxx拿快递".....}
               ]
       }
       
       
-----------------------------------------发送记录----------------------------------------
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
9:分组--新增
       URL	:     group/add
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
       “gourpName ”;”分组名称”,
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
       “id”;”分组ID”,
       }
       返回结果	
       {
       “code”:  200,  //成功
       “message”:”分组删除成功”,
       “data”:{}
       }
       
       
11:分组--修改
       URL	:     group/update
       Request Method: POST
       "headers": 
       "Content-Type: application/json; charset=utf-8 ;version=1.0.0"
       
       请求参数	
       {
        “id”;”语音模板ID”,
         "gourpName”;"分组名称”,
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
       “message”:”分组查询成功”,
       “data”:[
                        {"svgid":"1","svggourpname":"宝安区客户"},
                        {"svtid":"2","svggourpname":"福田区客户"}
               ]
       }
              
 
       
-----------------------------------------客户管理----------------------------------------
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

14:客户--修改
       URL	:     customer/update
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
        URL	:     customer/list
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

 