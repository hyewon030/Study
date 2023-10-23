🏕️ 자바 스프링 게시판 만들기

 + 스프링 게시판

  - 프로젝트명 : SpringBoard

  - top-level package : web

  - 스프링프레임워크 버전 : 5.3.30

  - Java 버전 : 11

🏕️스프링프레임워크 버전 설정?
- pom.xml 파일에서 버전을 바꾼다

🏕️한글 utf-8 설정?
web.xml에서 utf-8 설정
	<!-- POST 전달 데이터의 한글 인코딩 설정 필터 : UTF-8 -->
	<filter>
		<filter-name>encodingFilter</filter-name>
		<filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
		<init-param>
			<param-name>encoding</param-name>
			<param-value>UTF-8</param-value>
		</init-param>
	</filter>

	<filter-mapping>
		<filter-name>encodingFilter</filter-name>
		<url-pattern>/*</url-pattern>
	</filter-mapping>

🏕️java 버전 설정?
    
