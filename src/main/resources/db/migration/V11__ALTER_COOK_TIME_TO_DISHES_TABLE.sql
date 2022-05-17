ALTER TABLE dishes ADD cooking_time INT;

UPDATE dishes set cooking_time=2 where (id=34 or id=35 or id=36);
UPDATE dishes set cooking_time=5 where (id=31 or id=32 or id=33);
UPDATE dishes set cooking_time=7 where (id=1 or id=2 or id=3 or id=21);
UPDATE dishes set cooking_time=10 where (id=4 or id=5 or id=6);
UPDATE dishes set cooking_time=15 where (id=19 or id=20 or id=24);
UPDATE dishes set cooking_time=20 where (id=7 or id=8 or id=9 or id=10 or id=11 or id=12 or id=22 or id=23);
UPDATE dishes set cooking_time=25 where (id=13 or id=14 or id=15 or id=15 or id=17 or id=18 or id=25 or id=26 or id=27 or id=28 or id=29 or id=30);
