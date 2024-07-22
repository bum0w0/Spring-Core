package hello.core.singleton;

public class StatefulService {
/*
      싱글톤 주의점
      특정 클라이언트에 의존적인 필드가 있으면 안된다.
      특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다.
      스프링 빈의 필드에 공유 값을 설정하면 큰 장애가 발생할 수 있음.
 */

    public int order(String name, int price) {
        System.out.println("name = " + name + " price = " + price);
        // 싱글톤 방식에서 객체는 무상태(stateless)로 설계
        return price;
    }
}
