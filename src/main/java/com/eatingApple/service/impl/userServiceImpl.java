package com.eatingApple.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.eatingApple.entity.userEntity;
import com.eatingApple.mapper.userMapper;
import com.eatingApple.req.UserSaveReq;
import com.eatingApple.req.userReq;
import com.eatingApple.resp.commonResp;
import com.eatingApple.resp.pageResp;
import com.eatingApple.service.UserService;
import com.eatingApple.util.CopyUtil;
import com.eatingApple.util.SnowFlakeUtil;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class userServiceImpl extends ServiceImpl<userMapper, userEntity> implements UserService {

    @Autowired
    private userMapper userMapper;

    @Resource
    private SnowFlakeUtil snowFlake;

    @Override
    public pageResp<userEntity> getlist(userReq userReq) {
        QueryWrapper<userEntity> userEntityQueryWrapper = new QueryWrapper<>();
        if (!ObjectUtils.isEmpty(userReq.getName())) {
            userEntityQueryWrapper.lambda().eq(userEntity::getName, userReq.getName());
        }
        if (!ObjectUtils.isEmpty(userReq.getPhone())) {
            userEntityQueryWrapper.lambda().eq(userEntity::getPhone, userReq.getPhone());
        }
        if (!ObjectUtils.isEmpty(userReq.getCity())) {
            userEntityQueryWrapper.lambda().eq(userEntity::getCity, userReq.getCity());
        }
//        System.out.println("筛选sql语句====================");
//        userEntityQueryWrapper.lambda().eq(userEntity::getSex,"男" );
//        List<userEntity> userEntities = userMapper.selectList(userEntityQueryWrapper);
//        for (userEntity u : userEntities) {
//            System.out.println(u.toString());
//        }

        Page<userEntity> page = new Page<>(userReq.getPage(), userReq.getSize());
        IPage<userEntity> userEntityIPage = userMapper.selectPage(page, userEntityQueryWrapper);
        pageResp<userEntity> pageResp = new pageResp<>();
        pageResp.setTotal(userEntityIPage.getTotal());
        pageResp.setList(userEntityIPage.getRecords());
        return pageResp;
    }

    @Override
    public void delete(long id) {
        userMapper.deleteById(id);
    }

    @SneakyThrows
    @Override
    public commonResp save(UserSaveReq req) {
        commonResp<userEntity> resp = new commonResp<>();
        QueryWrapper<userEntity> wrapper = new QueryWrapper<>();
        userEntity entity = CopyUtil.copy(req, userEntity.class);
        if (ObjectUtils.isEmpty(req.getId())) {
            entity.setId(snowFlake.getNextId());
            userMapper.insert(entity);
        } else {

            wrapper.lambda().eq(userEntity::getId, req.getId());
            List<userEntity> userEntities = userMapper.selectList(wrapper);
            int size = userEntities.size();
            if (size == 1) {
                resp.setSuccess(false);
            } else {
                userMapper.updateById(entity);
                resp.setSuccess(true);
            }
        }
        return resp;
    }

    @SneakyThrows
    @Override
    public commonResp<userEntity> update(UserSaveReq req) {
        commonResp<userEntity> resp = new commonResp<>();
        QueryWrapper<userEntity> wrapper = new QueryWrapper<>();

        userEntity entity = CopyUtil.copy(req, userEntity.class);
        //System.out.println(entity); //打印修改的数据
        userMapper.updateById(entity);
        return resp;
    }


}
