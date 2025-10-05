package com.qianlou.admin.converter;

import com.qianlou.model.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class StringToBaseEnumConverterFactory implements ConverterFactory<String, BaseEnum> {
    /**
     * String -> TargetType implements BaseEnum
     * 字符串转 BaseEnum的子类
     */
    @Override
    public <T extends BaseEnum> Converter<String, T> getConverter(Class<T> targetType) {
        return new Converter<String, T>() {
            @Override
            public T convert(String source) {
                // Class有一个API：getEnumConstants()  用来获取枚举常量值
                return Arrays.stream(targetType.getEnumConstants())
                        .filter(t -> source.equals(t.getCode() + ""))
                        .findFirst()
                        .orElseThrow(IllegalArgumentException::new);
            }
        };
    }
}