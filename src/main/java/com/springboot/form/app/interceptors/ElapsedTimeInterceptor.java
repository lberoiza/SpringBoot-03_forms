package com.springboot.form.app.interceptors;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Primary
@Component("ElapsedTimeInterceptor")
public class ElapsedTimeInterceptor implements HandlerInterceptor {

  private static final Logger logger = LoggerFactory.getLogger(ElapsedTimeInterceptor.class);

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    logger.info("ElapsedTimeInterceptor: preHandle() getting in ...");

    if (request.getMethod().equalsIgnoreCase("post")) {
      return true;
    }

    if (handler instanceof HandlerMethod) {
      HandlerMethod hMethod = (HandlerMethod) handler;
      logger.info(String.format("Calling Method '%s'", hMethod.getMethod().getName()));
    }

    long startTime = System.currentTimeMillis();
    request.setAttribute("startTime", startTime);

    Random random = new Random();
    Integer delay = random.nextInt(100); // Delay 100 milliseconds
    Thread.sleep(delay);
    return true;
  }

  @Override
  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
      ModelAndView modelAndView) throws Exception {

    long endTime = System.currentTimeMillis();
    Object startTimeObj = request.getAttribute("startTime");
    Long elapsedTime = null;
    String elapsedTimeStr = null;

    if (startTimeObj != null) {
      elapsedTime = endTime - (Long) startTimeObj;
      elapsedTimeStr = String.format("Elapsed Time: %d miliseconds", elapsedTime);
    }

    if (handler instanceof HandlerMethod && modelAndView != null) {
      modelAndView.addObject("elapsedTime", elapsedTime);
      modelAndView.addObject("elapsedTimeStr", elapsedTimeStr);
    }

    logger.info(elapsedTimeStr);
    logger.info("ElapsedTimeInterceptor: postHandle() getting out ...");

  }

}
