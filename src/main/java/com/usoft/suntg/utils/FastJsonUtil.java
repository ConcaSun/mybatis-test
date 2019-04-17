package com.usoft.suntg.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * @author suntg
 * @date ${date}
 */
public class FastJsonUtil {

    private static final Feature DEFAULT_PARSER_FEATURE = Feature.DisableCircularReferenceDetect;
    private static final SerializerFeature DEFAULT_SERIALIZER_FEATURE = SerializerFeature.DisableCircularReferenceDetect;

    public static final String toJson(Object object) {
        return JSON.toJSONString(object, DEFAULT_SERIALIZER_FEATURE);
    }

    public static final <T> T fromJson(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz, DEFAULT_PARSER_FEATURE);
    }

    public static final <T> List<T> fromJsonArray(String jsonString, Class<T> clazz) {
        return JSON.parseArray(jsonString, clazz);
    }

}
