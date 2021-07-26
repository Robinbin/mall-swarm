package com.macro.mall.common.util;

import com.macro.mall.common.api.ResultCode;
import com.macro.mall.common.exception.MallServiceException;

public class CountUtil {

    public static int handleCount(int count) {
        if (count > 0) {
            return count;
        } else {
            throw new MallServiceException(ResultCode.FAILED);
        }
    }

    private CountUtil() {
        throw new IllegalStateException("Utility class");
    }
}
