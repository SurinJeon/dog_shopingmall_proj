-- 계정 권한 부여
drop user 'user_shoppingmall'@'localhost';

grant all 
   on shoppingmall.* 
   to 'user_shoppingmall'@'localhost' identified by 'rootroot';
