package hello.core.singleton;

public class SingletonService {
    
    // 자기자신을 static으로 선언해서 가지고있는것이다. 
    // static은 메모리에 하나만 올라간다.
    // 이렇게 만든 인스턴스 하나만 만들게 한다.
    private static final SingletonService instance = new SingletonService();
    
    public static SingletonService getInstance() {
        return instance; // 항상 같은 인스턴스만 반환한다.
    }

    private SingletonService() {
        // 이렇게 private로 선언하면 다른 파일에서 생성 호출을 막는다.
    }

    public void logic() {
        System.out.println("싱글톤 객체 로진 호출");
    }
}
