package com.memo.back.infrastructure.log;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Aspect
@Slf4j
@Component
public class RequestLogger {
  private static Map<String, String> getParams(HttpServletRequest request) {
    Map<String, String> jsonObject = new LinkedHashMap<>();
    Enumeration<String> params = request.getParameterNames();
    while (params.hasMoreElements()) {
      String param = params.nextElement();
      String replaceParam = param.replaceAll("\\.", "-");
      jsonObject.put(replaceParam, request.getParameter(param));
    }
    return jsonObject;
  }

  @Pointcut("execution(*)")
  public void all() {}

  @Pointcut("execution(* com.memo.back..*Controller.*(..))")
  public void controller() {}

  @Around("all()")
  public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    try {
      Object result = joinPoint.proceed();
      return result;
    } finally {
      long end = System.currentTimeMillis();
      long timeinMs = end - start;
      log.info("{} | time = {}ms", joinPoint.getSignature(), timeinMs);
    }
  }

  @Around("controller()")
  public Object loggingBefore(ProceedingJoinPoint joinPoint) throws Throwable {
    HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    String controllerName = joinPoint.getSignature().getDeclaringType().getName();
    String methodName = joinPoint.getSignature().getName();
    Map<String, Object> params = new HashMap<>();

    try {
      String decodedURI = URLDecoder.decode(request.getRequestURI(), "UTF-8");

      params.put("controller", controllerName);
      params.put("method", methodName);
      params.put("params", getParams(request));
      params.put("log_time", System.currentTimeMillis());
      params.put("request_uri", decodedURI);
      params.put("http_method", request.getMethod());
    } catch (Exception e) {
      log.error("LoggerAspect error", e);
    }

    log.info("[{}] {}", params.get("http_method"), params.get("request_uri"));
    log.info("method: {}.{}", params.get("controller") ,params.get("method"));
    log.info("params: {}", params.get("params"));

    Object result = joinPoint.proceed();

    return result;
  }
}
