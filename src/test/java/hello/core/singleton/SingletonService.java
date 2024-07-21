package hello.core.singleton;

// 싱글톤 패턴
public class SingletonService {

    // 1. static 영역에 객체 인스턴스가 딱 1개 생성
    private static final SingletonService instance = new SingletonService();

    // 2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    public static SingletonService getInstance() {
        // 항상 같은 인스턴스 반환
        return instance;
    }

    // 3. 생성자를 private으로 선언하여 외부에서 new 키워들르 통해 객체 생성을 하지 못하게 한다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
