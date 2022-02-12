# boostcourse

# Issue
1. Ajax(Post) 이후, Spring(Redirect) 전송이 HEADER의 Request URL로만 들어감, 그래서 Request Method: POST가 남아있음 스프링 내부 코드를 통한 해결 방법은 아직 모르겠다.
우회하는 방법으로 Ajax(Post) 이후, 성공 하면 window.location.replace('http://localhost:8080/basic-v2/HOME'); 사용해서 넘겨줌 (PRG 방식처럼)
  
2. 자바스크립트 함수 추가 후, HTMLButtonElement.onclick 발생하면 중복오류라서 함수 추가 한 부분 없애고 다시 시도하기

3. Ajax로 방향 이동 하면서, DB에 저장하는거 까지는 가능하지만 새로고침을 하지 않고는 html에 데이터를 알려주기 어려워서, javascript에서 createElement로 할까 고민중... 일단, DB update sql 추가 컨셉은 조금 헷갈리니 createElement로 UI만 완성하고 생각하자.

4. document.append 등을 이용해서 칸을 움직이고 상태를 변경하면서 동시에 DB에 데이터를 저장하고 싶었지만 1번 실행 이외에 여러 번 동작하면, URL 새로고침 없이 DB에 변경된 상태등을 실시간으로 전송 하지 못하는 상태다. 일단 이 정도로 끝
