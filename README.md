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
📁 sparta-scheduleApp <br>
ㄴ📁 src <br>
&nbsp;&nbsp; ㄴ📁 main <br>
&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 java/com/example/spartascheduleapp <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 dto <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 entity <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 repository <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 controller <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 service <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 impl <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 ScheduleService <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 UserService <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 SpartaScheduleAppApplication.java<br>
&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📁 resources <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ㄴ📄 application.properties <br> 



## 🔎 트러블 슈팅
https://iammu.tistory.com/42
