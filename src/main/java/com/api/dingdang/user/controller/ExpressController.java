package com.api.dingdang.user.controller;

import com.api.dingdang.user.dto.req.express.ExpressQueryReqDTO;
import com.api.dingdang.user.dto.req.express.ExpressRecordQueryReqDTO;
import com.api.dingdang.user.dto.req.express.ExpressReqDTO;
import com.api.dingdang.user.dto.req.express.ExpressUpdateReqDTO;
import com.api.dingdang.user.dto.resp.express.ExpressQueryResp;
import com.api.dingdang.user.dto.resp.express.ExpressRecordQueryResp;
import com.api.dingdang.user.utils.JsonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@Api(tags="快件管理模块")
@RequestMapping(value = "/express")
public class ExpressController {


    @PostMapping("/add")
    @ApiOperation(value = "快件入库")
    public JsonResponse add(@RequestBody ExpressReqDTO expressReqDTO){
        return JsonResponse.success();
    }


    @PutMapping("/update")
    @ApiOperation(value = "快件出库")
    public JsonResponse update(@RequestBody ExpressUpdateReqDTO expressUpdateReqDTO){
        return JsonResponse.success();
    }


    @PostMapping("/list")
    @ApiOperation(value = "快件查询")
    public JsonResponse list(@RequestBody ExpressQueryReqDTO expressQueryReqDTO){
        List<ExpressQueryResp> list=new ArrayList<>();
        ExpressQueryResp expressQueryResp=new ExpressQueryResp();
        expressQueryResp.setId(1);
        expressQueryResp.setExpressNo("1000001");
        expressQueryResp.setMobile("13871805288");
        expressQueryResp.setPickupNo("A-1001");
        expressQueryResp.setRemark("已取");

        ExpressQueryResp expressQueryResp1=new ExpressQueryResp();
        expressQueryResp1.setId(1);
        expressQueryResp1.setExpressNo("1000002");
        expressQueryResp1.setMobile("13871805289");
        expressQueryResp1.setRemark("已取");
        expressQueryResp1.setPickupNo("A-1002");

        list.add(expressQueryResp);
        list.add(expressQueryResp1);
        return JsonResponse.success(list);
    }



    @PostMapping("/notice/list")
    @ApiOperation(value = "快件发送记录查询")
    public JsonResponse noticeList(@RequestBody ExpressRecordQueryReqDTO expressRecordQueryReqDTO){
        List<ExpressRecordQueryResp> list=new ArrayList<>();
        ExpressRecordQueryResp expressRecordQueryResp=new ExpressRecordQueryResp();
        expressRecordQueryResp.setId(1);
        expressRecordQueryResp.setExpressNo("1000001");
        expressRecordQueryResp.setPickupNo("A-1001");
        expressRecordQueryResp.setMobile("13871805288");
        expressRecordQueryResp.setAccount("account");
        expressRecordQueryResp.setTemplateId(1);


        ExpressRecordQueryResp expressRecordQueryResp1=new ExpressRecordQueryResp();
        expressRecordQueryResp.setId(2);
        expressRecordQueryResp.setExpressNo("1000002");
        expressRecordQueryResp.setMobile("13871805289");
        expressRecordQueryResp.setPickupNo("A-1002");
        expressRecordQueryResp.setAccount("account1");
        expressRecordQueryResp.setTemplateId(12);

        list.add(expressRecordQueryResp);
        list.add(expressRecordQueryResp1);
        return JsonResponse.success(list);
    }

}
