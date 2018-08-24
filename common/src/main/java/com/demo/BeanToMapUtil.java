
package com.demo;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * JavaBean 与 Map之间互转的工具类
 * 底层实际上依赖于fastJson
 */
public class BeanToMapUtil {
    /**
     * 将一个 Map 对象转化为一个 JavaBean
     *
     * @param type 要转化的类型
     * @param map  包含属性值的 map
     * @return 转化出来的 JavaBean 对象
     */
    public static <T> T convertMap(Map map, Class<T> type) {
        if (map != null && map.size() > 0) {
            return JSON.parseObject(JSON.toJSONString(map), type);
        } else {
            return null;
        }
    }

    /**
     * 将一个 JavaBean 对象转化为一个 Map
     *
     * @param bean 要转化的JavaBean 对象
     * @return 转化出来的 Map 对象
     */
    public static Map convertBean(Object bean) {
        if (bean != null) {
            return JSON.parseObject(JSON.toJSONString(bean), HashMap.class);
        } else {
            return null;
        }
    }
}
