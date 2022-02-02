package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName = " + beanDefinitionName);
            System.out.println("object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames(); // 모든 bean의 이름을 담는다
        for (String beanDefinitionName : beanDefinitionNames) { // 하나씩 확인한다
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); // 해당하는 이름에 bean 정의를 꺼낸다

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { // 직접 등록한 빈이면
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("beanDefinitionName = " + beanDefinitionName);
                System.out.println("object = " + bean);
            }
        }
    }
}
