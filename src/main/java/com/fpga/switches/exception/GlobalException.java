package com.fpga.switches.exception;

import com.fpga.switches.pojo.Result;
import com.fpga.switches.pojo.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName GlobalException
 * @Description 全局异常
 * @Author YuZhiHui
 * @Date 2021/1/6 9:55
 */
@RestControllerAdvice
@Slf4j
public class GlobalException {
    /**
     * 捕获全局异常，处理所有不可知的异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    Object handleException(Exception e, HttpServletRequest request) {
        if (e instanceof NettyException) {
            log.error("url {}, nettymsg {}", request.getRequestURL(), e.getMessage());
        }
        log.error("url {}, msg {}", request.getRequestURL(), e.getMessage());
        return new Result(StatusCode.SYSERROR,"系统错误",e.getMessage());
    }
}
