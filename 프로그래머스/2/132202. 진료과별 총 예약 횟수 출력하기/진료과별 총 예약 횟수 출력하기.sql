-- 2022년 5월에 예약한 환자 수를 
-- 진료과 코드 별
-- 진료과 코드 / 5월예약건수
-- 진료과별 예약한 환자 수를 기준 오름차순, 진료과 코드 기준 오름차순

SELECT MCDP_CD AS "진료과코드", COUNT(MCDP_CD) AS "5월예약건수"
FROM APPOINTMENT
WHERE TO_CHAR(APNT_YMD, 'YYYY-MM-DD') LIKE '2022-05%'
GROUP BY MCDP_CD
ORDER BY "5월예약건수", MCDP_CD
