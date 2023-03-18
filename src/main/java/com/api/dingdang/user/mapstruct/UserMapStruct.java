package com.api.dingdang.user.mapstruct;

import com.api.dingdang.user.dto.req.user.UserLoginReqDTO;
import com.api.dingdang.user.dto.req.user.UserReq;
import com.api.dingdang.user.module.User;
import com.api.dingdang.user.vo.UserDO;
import com.api.dingdang.user.vo.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapStruct {

    //为客户端提供对映射器实现的访问。
    UserDO dto2do(UserDTO userDTO);

    User req2do(UserReq userReq);

    User loginReq2do(UserLoginReqDTO userLoginReqDTO);

}
