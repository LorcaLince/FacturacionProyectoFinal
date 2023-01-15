package com.proyecto.crud.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class ClienteAspect {

    @Pointcut("execution(* org.proyecto.crud.controller.ClienteController.*(..))")
    public void logMethod() {
    }

    @Before("logMethod()")
    public void doBefore(JoinPoint joinPoint) {
        System.out.println("LOG BEFORE POINT CUT===================================");
        //Obtenemos el objeto HttpServletRequest que tiene los datos relacionados en el request
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();  //Obtenemos los objetos de  request
        String url = request.getRequestURL().toString();   //Obtenemos la url invocada
        String ip = request.getRemoteAddr();     //Obtenemos la direcion ip del objeto requerido
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        //Obtenemos el nombre del metodo del request del objeto solicitado
        Object[] args = joinPoint.getArgs();     //Obtenemos los parametros del request del objeto solicitado
//        RequestLog requestLog=new RequestLog(url,ip,classMethod,args);
        System.out.println("Request: " + url + ip + classMethod);
        System.out.println("IP: " + ip);
        System.out.println("ClassMethod: " + classMethod);
        System.out.println("args: " + args);
    }

    //Define como completar la ejecucion
    @After("log()")
    public void doAfter(){
        System.out.println("------------doAfter-----------------------");
    }

    //Define el metodo para los valores devueltos por el Controller y loguea por consola
    @AfterReturning(returning = "result",pointcut = "log()")
    public void doAfterReturning(Object result){
        System.out.println("------------doAfterReturning-----------------------");
        System.out.println("Result : " +result);
    }

}