package hello.core.lifecycle;

// 실제로 네트워크에 연결하는 것은 아니고 예제코드임. (빈 생명주기 콜백 테스트를 위한 단순 로그 출력)

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class NetworkClient {

    private String url;

    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
        connect();
        call("초기화 연결 메시지");
    }

    public void setUrl(String url) {
        this.url = url;
    }

    // 서비스 시작 시 호출
    @PostConstruct
    public void connect() {
        System.out.println("connect = " + url);
    }

    public void call(String message) {
        System.out.println("call " + url + " message = " + message);
    }

    // 서비스 종료 시 호출
    @PreDestroy
    public void disconnect() {
        System.out.println("close: " + url);
    }


}
