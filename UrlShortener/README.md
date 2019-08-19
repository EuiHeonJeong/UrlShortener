## Url Shortener
URL 을 입력받아 짧게 줄여주고, Shortening 된 URL 을 입력하면 원래 URL 로 리다이렉트하는 프로그램

## 설치 방법 (Installation)
- localhost에서 was 구동 
- 포트 : 8080
- 개발환경 : 자바, 스프링부트

## 사용 방법 (Usage)
- 프로그램 실행 후 url에 http://localhost:8080/index 입력
- url을 입력 후에 변환 버튼을 클릭하면 단축 url이 생성
- 이동 버튼을 클릭하여 해당 페이지로 이동

## 문제해결 전략
- BASE62 알고리즘 사용
- 입력된 주소에 대해서 COUNT를 부여하고, 그 카운트에 62를 나눈 나머지값을 이용하여 문자를 추출
- 8자리를 맞추되 빈 공간에는 0을 채움
- 페이지 이동 및 url 처리를 위해서 RestConroller와 Controller 활용





