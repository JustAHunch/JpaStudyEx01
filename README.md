# [JpaStudyEx01]
## 1. JPA 구동방식
![image](https://user-images.githubusercontent.com/71360101/93285714-82739700-f810-11ea-9998-49104f9de866.png)
#### * 특징
* **Entity MangerFactory**는 하나만 생성해서 애플리케이션 전체에서 공유
* **Entity Manager**는 쓰레드간에 공유X (create, close)
* JPA의 모든 데이터 변경은 **트랜잭션** 안에서 실행
* JPA 는 SQL을 추상화한 **JPQL**이라는 객체 지향 쿼리 언어 제공
<hr>

## 2. JPQL
* Table이 아닌 Entity Object를 대상으로하는 객체지향 쿼리
* 가장 단순한 조회 방법
    * EntityManager.find()
    * 객체 그래프 탐색(a.getB().getC())
* 조건부 조회
  > SQL
    ``` roomsql
        select * from TBL_MEMBER where userage > 20
    ```
  > JPQL
  ``` java
      List<Member> result = em.createQuery("select m from Member as m where m.age > 20", Member.class)
      .getResultList();
  ```
  > Member.java
    ``` java
        @Entity
        @Table(name = "TBL_MEMBER")
        public class Member {
            @Id
            @Column(name = "userid")
            private Long id;
        
            @Column(name = "username")
            private String name;
  
            @Column(name = "userage")
            private Integer age;
        }
    ```
#### * 특징
* **Entity Object**중심의 개발(Table에 직접 query문을 날리지 않기 때문에 특정 데이터베이스 SQL에 비종속적으로 프로그램이 설계 가능)
* 모든 DB data를 객체로 변환해서 검색하는 것은 불가능
* Application이 필요한 Data만 DB에서 불러오려면 결국 검색 조건이 포함된 SQL이 필요
  
<hr>
