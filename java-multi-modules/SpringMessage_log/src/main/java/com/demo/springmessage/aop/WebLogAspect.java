package com.demo.springmessage.aop;


import com.demo.springmessage.dao.OperationDao;
import com.demo.springmessage.pojo.Operation;
import com.demo.springmessage.pojo.User;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class WebLogAspect {
    private final Logger logger = LoggerFactory.getLogger(WebLogAspect.class);

    @Autowired
    OperationDao operationDao;

    @Pointcut("@annotation(com.demo.springmessage.aop.MyLog)")
    public void annotationLog() {
    }

    @Around("annotationLog()")
    public Object aroundLog(ProceedingJoinPoint pjd){
        //保存日志
        Operation operation = new Operation();
        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) pjd.getSignature();
        //获取切入点所在方法
        Method method = signature.getMethod();

        MyLog myLog = method.getAnnotation(MyLog.class);
        if (myLog != null){
            String value = myLog.value();
            operation.setOp_type(value);
        }

        //获取操作开始时间
        long startTime = System.currentTimeMillis();
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        User user = null;
        user = (User) request.getSession().getAttribute("user");
        if (user != null) {

            operation.setOp_user_id(user.getId());
            operation.setOp_user_name(user.getUsername());
        }else {
            //请求的参数，这么写因为只有登录操作session里没有user
            Object[] args = pjd.getArgs();
            operation.setOp_user_name((String) args[0]);
        }
        Object result = null;
        try {
            //执行目标方法，并且获得它的返回值
            result = pjd.proceed();
            if (result != null){
                operation.setResult("成功");
            }
            if (result.toString() == "false"){
                operation.setResult("失败");
            }
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        long endTime = System.currentTimeMillis();
        operation.setCost_time(endTime - startTime);
        operationDao.insertOperationLog(operation);
        return result;
    }
}