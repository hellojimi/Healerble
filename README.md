# 운동 지식 공유 서비스; Healerble

Healerble은 건강이라는 health와 이용자에게 맞춤형 정보를 제공해 선별된 정보만 얻게 되는 현상인 filter bubble의 합성어로,

자신만의 운동 팁이나 루틴, 식단을 공유하고 질문이나 고민을 등록해서 사용자 간 소통할 수 있는 운동 지식 기반 커뮤니티 서비스입니다.

## 프로젝트 기능 및 설계
### 회원 기능
- 회원가입
  - 이메일(아이디), 비밀번호, 닉네임을 입력받음
    - 아이디는 unique 해야하며, 회원가입시 일반적으로 USER(일반 사용자) 권한을 가짐 
    - 비밀번호는 영문 대소문자, 숫자, 특수문자를 포함한 8~20자로 구성
    - 닉네임은 2~10자이며, 특수문자를 제외한 한글, 알파벳 대소문자, 숫자로 구성
  - 아이디 및 닉네임 중복 확인
  - 회원은 관리자와 일반 사용자로 구분
- 로그인
  - 회원가입 여부 확인
  - 아이디 비밀번호 일치 여부 확인
- 마이페이지
  - 회원 정보 조회
  - 회원 정보 수정
    - 닉네임 및 비밀번호만 수정 가능
    - 닉네임 중복 확인
  - 회원 탈퇴 
  - 작성한 게시글 조회, 수정, 삭제
- 관리자
  - 사용자 및 게시글 관리
### 게시글 관리 기능
- 게시글 검색
  - 검색된 게시글의 기본 정렬은 최신순이며, 페이지네이션(pagination) 형식을 따름
  - 게시글의 제목에 찾고자 하는 키워드가 포함된 게시물이 출력됨
- 게시글 조회
  - 카테고리별로 게시글 조회(Q&A, 고민있어요, 크루 모집)
  - 각 게시글의 기본 정렬은 최신순이며, 페이지네이션(pagination) 형식을 따름
- 특정 게시글 조회
  - 게시글 제목, 내용, 작성자, 작성일시, 좋아요 수, 댓글 출력
- 게시글 등록 및 수정
  - 로그인한 사용자 및 관리자만 가능
  - 게시글 제목 글자수는 최대 100자이며, 제목과 내용이 공백 혹은 빈칸일 수 없음
- 게시글 삭제
  - 로그인한 사용자 및 관리자만 가능
### 댓글 기능
- 댓글 조회
  - 특정 게시글 조회시 댓글 목록도 함께 조회됨
  - 댓글은 최신순으로 정렬
- 댓글 작성, 수정, 삭제
  - 로그인한 사용자 및 관리자만 가능
  - 댓글 작성 및 수정시 최대 글자수는 5,000자
  - 게시글 삭제 시 해당 댓글도 같이 삭제됨
### 좋아요 기능
- 로그인한 사용자는 게시글에 좋아요를 누를 수 있음
## ERD
![erd_Healerble](https://github.com/user-attachments/assets/0a093c74-f647-4088-af08-b6a070758315)
## Tech Stack
<div align=center> 
  <img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
  <img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
  <img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"> 
  <img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
</div>
