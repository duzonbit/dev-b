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

