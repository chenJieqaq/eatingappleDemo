package com.eatingApple.service;

import com.eatingApple.entity.userEntity;
import com.eatingApple.req.UserSaveReq;
import com.eatingApple.req.userReq;
import com.eatingApple.resp.commonResp;
import com.eatingApple.resp.pageResp;

public interface UserService {

    pageResp<userEntity> getlist(userReq userReq);

    void delete(long id);

    commonResp save(UserSaveReq userSaveReq);

    commonResp<userEntity> update(UserSaveReq userSaveReq);
}
