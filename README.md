# 📆 일정 관리 앱 프로젝트 2
스파르타 내일배움캠프 Spring Boot 숙련 프로젝트 <br>
Spring Boot를 마스터해보자 👩‍💻

## 🛠️ 프로젝트 소개
Spring Boot 기반의 일정관리 어플리케이션입니다.

## 🛠️ 기술 스택
**프레임워크** : Spring Boot 3.4.4 <br>
**데이터베이스** : MySQL / JPA <br>
**빌드 도구** : Gradle-Groovy<br>
**언어** : Java 17 <br>

## 🛠️ API
📕 일정 api
기능 | METHOD | URL | request | response/상태코드
-- | -- | -- | -- | --
일정 생성 | POST | /schedules | { “writer” : String,<br> “title” : String,<br> “content” : String } | 201 Created : 생성 성공<br>  { “id” : long,<br>  “writer” : String,<br> “title” : String,<br> “content” : String, }
전체 일정 조회 | GET | /schedules |   | 200 OK : 조회 성공<br> { “id” : long, <br> “writer” : String, <br> “title” : String,<br> “content” : String, }
단일 일정 조회 | GET | /schedules/{id} |   | 200 OK : 조회 성공<br> { “id” : long,<br> “writer” : String,<br> “title” : String,<br> “content” : String, }
일정 수정 | PATCH | /schedules/{id} | { “title” : String,<br> “content” : String } | 200 OK : 수정 성공 <br> { “id” : long, <br> “writer” : String,<br> “title” : String,<br> “content” : String, }
일정 삭제 | DELETE | /schedules/{id} |   | 200 OK : 삭제 성공

📕 유저관리 API
기능 | METHOD | URL | request | response/상태코드
-- | -- | -- | -- | --
회원가입 | POST | /users/signup | { “username” : String,<br> “email” : String,<br> “password” : String } | 201 Created : 생성 성공<br>  { “id” : long,<br> “username” : String,<br> “email” : String }
특정 회원 조회 | GET | /users/{id} |   | 200 OK : 조회 성공<br> { “username” : String,<br> “email” : String }
비밀번호 수정 | PATCH | /users/{id} | { "oldPassword" :  String,<br> "newPassword" : String } | 200 OK : 수정 성공
회원 삭제 | DELETE | /users/{id} |   | 200 OK : 삭제 성공

## 🛠️ ERD
<img width="202" alt="Image" src="https://github.com/user-attachments/assets/c1a1c678-eb17-4f5f-ad31-cb7ff45b61ae" /> <br>
단방향 user 1 : schedule n

## 🛠️ SQL
<img width="765" alt="Image" src="https://github.com/user-attachments/assets/cbae78f6-ab59-4667-8dd6-35d83235552a" />

## 🗂️ 주요 패키지 구성
&nbsp;&nbsp;&nbsp;&nbsp; 📁 spartascheduleapp <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📁 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 ScheduleController : 일정 관련 컨트롤러 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 UserController : 유저 관련 컨트롤러 <br> 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📁 dto <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📁 schedule : 일정 관련 dto <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 CreateScheduleRequestDto : 일정생성(C) 요청  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 ScheduleRequestDto : 일정 수정(U) 요청 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 ScheduleResponseDto : 일정 생성(C), 조회(R), 수정(U) 응답 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📁 user <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 SignupRequestDto : 회원가입(C) 요청 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 SignupResponseDto : 회원가입(C) 응답 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 UpdatePasswordRequestDto : 비밀번호 변경(U) 요청 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 UserResponseDto : 특정유저 조회(R) 응답  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📁 entity <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 BaseEntity : 생성일, 수정일 관련 엔티티 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 Schedule : 일정 엔티티 (BaseEntity 상속받음) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 User : 유저 엔티티 (BaseEntity 상속받음) <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📁 repository <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 ScheduleRepository <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 UserRepository <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📁 service <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📁 impl <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 ScheduleServiceImpl : 일정 서비스 계층 구현체  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 UserServiceImpl : 유저 서비스 계층 구현체  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 ScheduleService : 일정 서비스 인터페이스 <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 UserService : 유저 서비스 인터페이스<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 SpartaScheduleAppApplication.java<br>
&nbsp;&nbsp;&nbsp;&nbsp; 📁 resources <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 📄 application.properties <br> 



## 🔎 트러블 슈팅
https://iammu.tistory.com/42
