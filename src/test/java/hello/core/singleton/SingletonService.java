package hello.core.singleton;

public class SingletonService {
    //자기 자신을 내부의 프라이빗으로 하나 가지고 있는 것
    //클래스 레벨에 올라가기 때문에 딱 하나만 존재
    private  static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){ //생성자 막아 외부에서 객체 생성되지 않도록 함

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
