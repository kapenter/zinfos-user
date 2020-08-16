package com.zinfos.user.mapstruct;

import com.zinfos.user.vo.UserDO;
import com.zinfos.user.vo.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapStruct {

    //为客户端提供对映射器实现的访问。
    UserMapStruct INSTANCE = Mappers.getMapper( UserMapStruct.class );

    UserDO dto2do(UserDO userDO, UserDTO userDTO);
}
