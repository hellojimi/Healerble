# 운동 지식 공유 서비스; Healerble

Healerble은 건강이라는 health와 이용자에게 맞춤형 정보를 제공해 선별된 정보만 얻게 되는 현상인 filter bubble의 합성어로,

자신만의 운동 팁이나 루틴, 식단을 공유하고 질문이나 고민을 등록해서 사용자 간 소통할 수 있는 운동 지식 기반 커뮤니티 서비스입니다.

## 프로젝트 기능 및 설계
### 회원 기능
- 회원가입
  - 이메일(아이디), 비밀번호, 이름, 전화번호를 입력받음
  - 아이디는 unique 해야하며, 회원가입시 일반적으로 USER(일반 사용자) 권한을 가진다.
  - 아이디 중복 체크
  - 회원은 관리자와 일반 사용자로 구분
- 로그인
  - 회원가입 여부 확인
  - 아이디 비밀번호 일치 여부 확인
- 마이페이지
  - 회원 정보 조회
  - 회원 정보 수정
    - 이름
    - 전화번호
    - 비밀번호
  - 회원 탈퇴 
  - 게시글 CRUD
- 관리자
  - 사용자 및 게시글 관리
### 게시글 관리 기능
- 게시글 검색
- 게시글 조회
  - 카테고리별 게시글 조회(Q&A, 지식공유, 커뮤니티)
  - 각 게시글의 기본 정렬은 최신순
- 특정 게시글 조회
- 게시글 수정 및 삭제
  - 로그인한 사용자 및 관리자만 가능
### 댓글 기능
- 댓글 조회
  - 특정 게시글 조회시 댓글 목록도 함께 조회된다.
  - 댓글은 최신순으로 정렬
- 댓글 작성, 수정, 삭제
  - 로그인한 사용자 및 관리자만 가능
### 좋아요 기능
- 로그인한 사용자는 게시글에 좋아요를 누를 수 있다.
## ERD
## Tech Stack
<div align=center> 
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
</div>
