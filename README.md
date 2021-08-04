# 개발 환경

>	Java 8(JDK 1.8)</br>
>	Gradle 4.10

# 학습 내용
> * 서버 템플릿 엔진과 클라이언트 템플릿 엔진 차이 </br>
> Mustach는 둘 다 사용할 수 있는데, 이번 프로젝트에서 서버 템플릿 엔진으로 사용함
>
> * js 객체 선언으로 브라우저 전역 변수 충돌 문제 회피
>
> * JPA/Hibernate/Spring Data Jpa 관계 및 차이</br>
> 이번 프로젝트에서는 Spring Data Jpa 사용으로 RDBMS를 객체지향적으로 관리
>* JPA의 더티체킹을 활용해 Update시 쿼리 없이 데이터(테이블) 수정
> * JPA Auditing을 이용하여 모든 테이블에 공통 컬럼 추가로 등록/수정 시간 자동화
>
> * OAuth2를 활용한 소셜 로그인 구현
> * 세션 저장소로 DB 사용 -> 의존성 설정만으로 JPA로 인해 테이블이 자동 생성
> 
> * AWS EC2 인스턴스 생성 및 탄력적 IP 연결
> * EC2 인스턴스 접근위한 pem키 생성 및 puTTY위한 ppk 변환
> * 리눅스 서버 구축
> 
> * AWS RDS MariaDB 생성
> * 운영 환경에 맞는 파라미터 설정(타임존, Character Set, Max Connection)
> * EC2, 로컬과 연결을 위한 보안 그룹 설정
> 
> * AWS EC2 서버 활용해 프로젝트 배포
> * Linux shell 스크립트 작성
> * 프로젝트(EC2)와 AWS RDS 연동