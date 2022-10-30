package com.eatingApple.controller;

import com.eatingApple.entity.userEntity;
import com.eatingApple.req.userReq;
import com.eatingApple.req.UserSaveReq;
import com.eatingApple.resp.commonResp;
import com.eatingApple.resp.pageResp;
import com.eatingApple.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;
    @GetMapping("/getlist")
    public commonResp getList(userReq userReq){

        commonResp<pageResp<userEntity>> resp = new commonResp<>();
        pageResp<userEntity> listResp = userService.getlist(userReq);
        resp.setContent(listResp);
        return resp;
    }

    @DeleteMapping("/delete/{id}")
    public commonResp delete(@PathVariable long id){
        commonResp<userEntity> resp = new commonResp<>();
        userService.delete(id);
        resp.setSuccess(true);

        return resp;
    }

    @PostMapping("/create")
    public commonResp save(@RequestBody List<UserSaveReq> userSaveReq){
        commonResp<userEntity> resp = new commonResp<>();
         resp = userService.save(userSaveReq.get(0));
//        resp.setSuccess(true);
        return resp;
    }
    @PutMapping("/update")
    @ResponseBody
    public commonResp update(@RequestBody List<UserSaveReq> userSaveReq){
        commonResp<userEntity> resp = new commonResp<>();
        resp = userService.update(userSaveReq.get(0));
//        resp.setSuccess(true);
        return resp;
    }
}
