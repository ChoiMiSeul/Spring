package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class LogDemoController {
    private final LogDemoService logDemoService;
    private final ObjectProvider<MyLogger> myLoggerProvider; //myLogger를 찾을 수 있는 의존성 주입됨

    @RequestMapping("log-demo") //log-demo 요청이 오면
    @ResponseBody //view화면 없이 문자 반환
    //자바에서 제공하는 기능으로 고객 요청 정보 받을 수 있음
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString(); //고객이 어떤 url로 요청했는지
        MyLogger myLogger = myLoggerProvider.getObject();
        myLogger.setRequestURL(requestURL); //myLogger에 url정보 넣기

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
