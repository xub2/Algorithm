-- 코드를 입력하세요
-- 출력 : ID / 이름 / 성별 / 생년월일
-- 필터링 : 생일 3월 && 여성 // 전화번호 NULL 이면 출력 제외 
-- 정렬 : 회원 ID 기준 오름차순
SELECT MEMBER_ID, MEMBER_NAME, GENDER, TO_CHAR(DATE_OF_BIRTH, 'YYYY-MM-DD')
FROM MEMBER_PROFILE
WHERE TO_CHAR(DATE_OF_BIRTH, 'MM') = '03' AND GENDER = 'W' AND TLNO IS NOT NULL
ORDER BY MEMBER_ID