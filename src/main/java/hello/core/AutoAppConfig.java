package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        basePackages = "hello.core", // 등록하고자 하는 base_dir를 지정한다.
//        basePackageClasses = AutoAppConfig.class, // 이런방식으로 찾을 수 있다.
        // 지정하지 않으면 이 파일이 있는 위치가 base_dir이 된다.
        // 보통 프로젝트 최상단 위치에 두는것이 좋다.
        // SprintBoot에서는 CoreApplication에 이미 componentScan이 등록되어있다.


        // 예제로 AppConfig를 썻기때문에 아래에 이를 뺀다.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 뺄것 지정
)
public class AutoAppConfig {

}
