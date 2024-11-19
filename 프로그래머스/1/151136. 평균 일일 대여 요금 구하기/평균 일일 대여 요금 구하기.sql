-- 코드를 입력하세요
SELECT  (SELECT ROUND(AVG(DAILY_FEE),0)
                                                FROM CAR_RENTAL_COMPANY_CAR
                                                WHERE CAR_TYPE = 'SUV') AS AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
WHERE CAR_TYPE = 'SUV'
GROUP BY CAR_TYPE;
