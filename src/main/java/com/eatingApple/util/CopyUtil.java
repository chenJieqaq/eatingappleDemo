package com.eatingApple.util;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CopyUtil {
    @SuppressWarnings("all")
    public static <T> T copy(Object fromBean, Class<T> clz)
        throws InstantiationException, IllegalAccessException {
        if (fromBean == null || clz == null) {
            return null;
        }
        T result = clz.newInstance();
        BeanUtils.copyProperties(fromBean, result);
        return result;
    }

    public static <T> List<T> copy(Collection<?> fromBeans, Class<T> cls)
        throws InstantiationException, IllegalAccessException {
        if (CollectionUtils.isEmpty(fromBeans) || null == cls) {
            return null;
        }
        List<T> list = new ArrayList<>();
        for (Object fromBean : fromBeans) {
            T t = copy(fromBean, cls);
            if (t != null) {
                list.add(t);
            }
        }
        return list;
    }
}
