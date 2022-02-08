# boostcourse

# Issue
1.Ajax(Post) 이후, Spring(Redirect) 전송이 HEADER의 Request URL로만 들어감, 그래서 Request Method: POST가 남아있음 스프링 내부 코드를 통한 해결 방법은 아직 모르겠다.
우회하는 방법으로 Ajax(Post) 이후, 성공 하면 window.location.replace('http://localhost:8080/basic-v2/HOME'); 사용해서 넘겨줌 (PRG 방식처럼)
  
