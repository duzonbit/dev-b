# Spring Boot (Back-End)
## maven dependency
1. spring-boot-starter-web  
1. spring-boot-starter-data-jpa  
1. mysql-connector-java  
```
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.1.7.RELEASE</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```
+ parent
>>spring-boot-starter-parent
Spring Boot 최상위 module로서 여러가지 스프링의 기본 의존 관계를 포함  
부모인 spring-boot-dependencies에게 상속을 받음  
dependencies를 선언할때 버전을 명시할 필요가 없음  
## Controller -> Service -> Repository -> MySQL
## Controller
REST 형식으로 Controller제작  
게시판
>@RestController  
@CrossOrigin("origin-allowed=*")  
@RequestMapping(value = "/bbs")  
LIST  
>@GetMapping(value = { "", "/", "/{index}" })  
public Page<BbsModel> list(@PathVariable Optional<Integer> index)  
READ
>@GetMapping(value = { "/read/{index}" })  
public BbsModel read(@PathVariable int index)  
CREATE
>@RequestMapping(value = "/", method = RequestMethod.POST)  
public Map<String, String> insert(@RequestBody BbsModel bbsModel)  
UPDATE
>@RequestMapping(value = "/{idx}", method = RequestMethod.PUT)  
public Map<String, String> update(@RequestBody BbsModel bbsModel,@PathVariable Optional<Integer> idx)  
DELETE
>@RequestMapping(value = "/{idx}", method = RequestMethod.DELETE)  
public Map<String, String> delete(@RequestBody BbsModel bbsModel,@PathVariable Optional<Integer> idx)  
## REST란
### REST의 정의
1. “Representational State Transfer” 의 약자
    + 자원을 이름(자원의 표현)으로 구분하여 해당 자원의 상태(정보)를 주고 받는 모든 것을 의미한다.
    + 즉, 자원(resource)의 표현(representation) 에 의한 상태 전달
        - 자원(resource)의 표현(representation)
            * 자원: 해당 소프트웨어가 관리하는 모든 것
            * -> Ex) 문서, 그림, 데이터, 해당 소프트웨어 자체 등
            * 자원의 표현: 그 자원을 표현하기 위한 이름
            * -> Ex) DB의 학생 정보가 자원일 때, ‘students’를 자원의 표현으로 정한다.
        - 상태(정보) 전달
            * 데이터가 요청되어지는 시점에서 자원의 상태(정보)를 전달한다.
            * JSON 혹은 XML를 통해 데이터를 주고 받는 것이 일반적이다.
    + 월드 와이드 웹(www)과 같은 분산 하이퍼미디어 시스템을 위한 소프트웨어 개발 아키텍처의 한 형식
        - REST는 기본적으로 웹의 기존 기술과 HTTP 프로토콜을 그대로 활용하기 때문에 웹의 장점을 최대한 활용할 수 있는 아키텍처 스타일이다.
        - REST는 네트워크 상에서 Client와 Server 사이의 통신 방식 중 하나이다.
### REST의 구체적인 개념
1. HTTP URI(Uniform Resource Identifier)를 통해 자원(Resource)을 명시하고, HTTP Method(POST, GET, PUT, DELETE)를 통해 해당 자원에 대한 CRUD Operation을 적용하는 것을 의미한다.
    + 즉, REST는 자원 기반의 구조(ROA, Resource Oriented Architecture) 설계의 중심에 Resource가 있고 HTTP Method를 통해 Resource를 처리하도록 설계된 아키텍쳐를 의미한다.
    + 웹 사이트의 이미지, 텍스트, DB 내용 등의 모든 자원에 고유한 ID인 HTTP URI를 부여한다.
    + CRUD Operation
        - Create : 생성(POST)
        - Read : 조회(GET)
        - Update : 수정(PUT)
        - Delete : 삭제(DELETE)
### REST가 필요한 이유
1. ‘애플리케이션 분리 및 통합’  
1. ‘다양한 클라이언트의 등장’  
1. 최근의 서버 프로그램은 다양한 브라우저와 안드로이폰, 아이폰과 같은 모바일 디바이스에서도 통신을 할 수 있어야 한다.  
1. 이러한 멀티 플랫폼에 대한 지원을 위해 서비스 자원에 대한 아키텍처를 세우고 이용하는 방법을 모색한 결과, REST에 관심을 가지게 되었다.  
### REST API란
1. API(Application Programming Interface)란  
    + 데이터와 기능의 집합을 제공하여 컴퓨터 프로그램간 상호작용을 촉진하며, 서로 정보를 교환가능 하도록 하는 것
1. REST API의 정의
    + REST 기반으로 서비스 API를 구현한 것
    + 최근 OpenAPI(누구나 사용할 수 있도록 공개된 API: 구글 맵, 공공 데이터 등), 마이크로 서비스(하나의 큰 애플리케이션을 여러 개의 작은 애플리케이션으로 쪼개어 변경과 조합이 가능하도록 만든 아키텍처) 등을 제공하는 업체 대부분은 REST API를 제공한다.
### REST API 설계 기본 규칙
1. URI는 정보의 자원을 표현해야 한다.
    + resource는 동사보다는 명사를, 대문자보다는 소문자를 사용한다.
    + resource의 도큐먼트 이름으로는 단수 명사를 사용해야 한다.
    + resource의 컬렉션 이름으로는 복수 명사를 사용해야 한다.
    + resource의 스토어 이름으로는 복수 명사를 사용해야 한다.
        - Ex) GET /Member/1 -> GET /members/1
1. 자원에 대한 행위는 HTTP Method(GET, PUT, POST, DELETE 등)로 표현한다.  
    + URI에 HTTP Method가 들어가면 안된다.
        - Ex) GET /members/delete/1 -> DELETE /members/1
    + URI에 행위에 대한 동사 표현이 들어가면 안된다.(즉, CRUD 기능을 나타내는 것은 URI에 사용하지 않는다.)
        - Ex) GET /members/show/1 -> GET /members/1
        - Ex) GET /members/insert/2 -> POST /members/2
    + 경로 부분 중 변하는 부분은 유일한 값으로 대체한다.(즉, :id는 하나의 특정 resource를 나타내는 고유값이다.)
        - Ex) student를 생성하는 route: POST /students
        - Ex) id=12인 student를 삭제하는 route: DELETE /students/12
