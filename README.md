# 구현 사항 정리

### Holiday(Enum)
-[x] 모든 휴일들을 상수로 가지고 있어야 한다.
-[x] int 로 월과 숫자를 받았을 경우 holiday인지 판별할 수 있는 static 매서드가 필요할 것 같다. 

### 근무자 (Worker)
-[x] 근무자는 String 이름 필드로 이루어져 있으며 getter를 열어두자. 최대 5자입니다.
-[x] equals 오버라이딩을 하여 같음을 비교한다.

### 근무자들 (Workers)
-[x] List<Worker>
-[ ] 근무로직 추가 필요 !!
-[ ] 전의 근무자를 받는 경우와 안받는 경우를 따로 2개로 만들자. 
-[x] 중복되는 사람이 없어야 하며, 길이에 대한 validation을 두어야 한다.
-[x] 기본적으로 List<String>을 받아서 변환하도록 설계를 하자.

### 날짜(Date)
-[x] 필드는 4개가 있다. 월, 일, 월의 끝 일, 요일.
-[x] 기본적으로 월과 요일만 입력을 받고 다음 날짜로 이동을 하는 매서드가 필요하다.
-[x] 쉬는 날인지 아닌지 출력할 수 있어야 한다.
-[x] 다음날이 있는지 출력할 수 있어야 한다. -> 31에서 loop이 걸리니 오늘 가능한지로..
-[x] 평일인데 쉬는 날인지 확인할 수 있어야한다? -> 서비스에서 하도록 하자.
-[x] 월과 일에 대한 validation이 필요합니다. 요일은 애초에 handler에서 있는지 확인할듯 

### 요일(DayOfWeek) - Enum
-[x] 입력받은 한국어 요일 String에 대해서 Enum으로 돌려줄 수 있어야 한다.
-[x] 다음 요일을 돌려줄 수 있어야 한다.
-[x] String을 받았을 경우 Enum에 존재하는 것인지 반환해야 한다. ->Validator에서 쓰일 것. 

### InputHandler & View
-[x] 5,월 (숫자,한글로 입력을 받아야 한다.) -> 월은 존재하는 월이 맞는지 확인해야 한다.
-[x] 사원의 이름을 받을 수 있어야 한다. , 로 구분된 이름들을 받으면 될 것 같다.

### 서비스
-[ ] 평일 근무표, 휴일 근무표, 그리고 날짜가 있어야 한다. 이것들을 전부 받아줘야 한다.
-[ ] 각각의 날마다 일기록을 출력해서 List<WorkScheduleDto>를 모아서 outputView로 날려주기로 하자.
-[ ] while 스케줄링이 필요한 동안 -> 쉬는날인지 아닌지 물어본다 -> 알맞은 근무표 인원 일시킨다 -> 날짜를 다음날로 넘겨준다. -> previous 일하는 사람 들고 있기.
-[ ] 최종적으로 Dto 날려줌. 

### 일기록 (WorkScheduleDto)
-[ ] 월, 일, 요일, 평일x 휴일인지 여부, 그리고 근무자 이렇게 5개의 필드를 가지고 있자.

---
# 내용 정리


### 순번
- 휴일과 평일의 순번은 다르게 운영될 수 있다. 순서는 서로 다를 수 있다.
- 다만 평일에 한번 휴일에 한번 되어야 하며 중복되게 2번 들어가고 이러면 안된다.
- 비상 근무는 연속으로 2일 근무할 수 없다.
- 근무자는 연속해서 2일 근무를 할 수 없다. 그저 순서가 뒤에 사람이랑 바뀌는 것이다.

### 근무자
- 이름의 닉네임은 중복되면 안되며 최대 5자로 유지할 수 있어야 한다.
- 근무자는 최소 5명에서 35명까지만 가능하다

### 주말 이외에 법정 공휴일이 지정되어 있다.

### 입출력의 형태
```
비상 근무를 배정할 월과 시작 요일을 입력하세요> 5,월
평일 비상 근무 순번대로 사원 닉네임을 입력하세요> 준팍,도밥,고니,수아,루루,글로,솔로스타,우코,슬링키,참새,도리
휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> 수아,루루,글로,솔로스타,우코,슬링키,참새,도리,준팍,도밥,고니

5월 1일 월 준팍
5월 2일 화 도밥
5월 3일 수 고니
5월 4일 목 수아
```
### 입력
- 연도 고려 x 2월은 28일까지만 있다.
- 월과 시작 요일을 입력받으며 이름을 순서대로 입력받는다. 그러면 월의 첫번째 요일부터 쭉쭉 생긴다.
- 월과 요일에 대한 입력이 올바르지 않다면 다시 입력.
- (주의) 휴일이 ㅈ같아도 평일부터 다시 입력 받아야 한다 !! ErrorCatcher를 밖에다 써야 하는 상황.

### 출력
평일 이면서 법정 공휴일인 경우에 요일 뒤에 (휴일) 표기를 해야한다.
