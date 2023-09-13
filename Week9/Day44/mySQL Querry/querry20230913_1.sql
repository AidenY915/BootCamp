use sample;
select * from sample72_x, sample72_y;
DESC 상품;
DESC 재고수;

SELECT * FROM 상품 INNER JOIN 재고수 ON 상품.상품코드 = 재고수.상품코드
WHERE 상품.상품분류 = '식료품';

DESC 상품2; 
DESC 메이커;
SELECT 상품2.상품명, 메이커.메이커명 FROM 상품2 INNER JOIN 메이커 ON 상품2.메이커코드 = 메이커.메이커코드;

SELECT * FROM 상품 AS S1 INNER JOIN 상품 AS S2 ON S1.상품명 = S2.상품명; -- 테이블 별칭은 ''안씀!!

 SELECT * FROM 상품3 LEFT JOIN  재고수 ON 상품3.상품코드 = 재고수.상품코드 WHERE 상품3.상품분류='식료품';