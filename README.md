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