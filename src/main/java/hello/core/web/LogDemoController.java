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
//    private final ObjectProvider<MyLogger> myLoggerProvider; // DL을 위함
    private final MyLogger myLogger; // 프록시를 통해 바로 DL 가능

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) { // request
        String requestURL = request.getRequestURI().toString();

//        MyLogger myLogger = myLoggerProvider.getObject(); // Provider에서 사용
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId"); // 서비스
        return "OK"; // response
    }
}
