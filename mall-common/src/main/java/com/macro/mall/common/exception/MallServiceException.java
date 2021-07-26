package com.macro.mall.common.exception;

import com.macro.mall.common.api.IErrorCode;

public class MallServiceException extends RuntimeException {

    private final transient IErrorCode errorCode;

    public MallServiceException(final IErrorCode errorCode) {
        super(errorCode.getMessage());

        this.errorCode = errorCode;
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
