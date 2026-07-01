-- 코드를 입력하세요
-- 동물의 종 / 이름 / 성별 / 중성화 여부
-- 이름이 없으면 No name
SELECT ANIMAL_TYPE, NVL(NAME, 'No name'), SEX_UPON_INTAKE
FROM ANIMAL_INS
ORDER BY ANIMAL_ID