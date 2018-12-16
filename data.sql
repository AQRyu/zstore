INSERT INTO zstore.roles (id,name) VALUES 
(1,'ADMIN')
,(2,'CUSTOMER')
,(3,'MERCHANT');

INSERT INTO zstore.users (id,address,city,email,enabled,expired_date,name,password,phone,role_id) VALUES 
(4,'550 West 29th Street','New York','customer1@gmail.com',1,NULL,'customer1','$2a$10$DBUbDqNn24x2EONQ8g0i7eaYxNoe/NbxH.KMDzGPsVumbNN.EZw1u','2126291020',2)
,(5,'67 Liberty street','New York','customer2@gmail.com',1,NULL,'customer2','$2a$10$CSlgpMSKMuNrrRmf0KUSi.HxJkqWkfpFpEa8YEgBvmTTdaB79ZsBK','2126999999',2)
,(6,'200 Pearl street','New York','aqryuz@gmail.com',1,NULL,'aqryuz','$2a$10$8Cvbj5Kn3gyzcpl68S79PuNJbJM3MStph1X49DL4bs5fyVv3g9fnC','2126999999',2)
,(7,'2-18 Maiden Ln','New York','merchant1@gmail.com',1,NULL,'merchant1','$2a$10$u7UjeQn4ZWB/OaOseGLl5.xJcCCqhTLKt6GvszFK4neyZdqgmmH3K','0903838700',3)
,(8,'102 West street','New York','merchant2@gmail.com',1,NULL,'merchant2','$2a$10$7yj3iPoOAm53zAx.4aQTNuNMEgxzsbzIWd7kiumgUErNM5dwhhniq','0913090903',3)
,(9,NULL,NULL,'admin1@gmail.com',1,NULL,'admin1','$2a$10$30kODujFoWi79qzH.5KOy.HosBtgGXBRYxv.NNmUiJSI2Dl0LYe5K',NULL,1)
,(10,NULL,NULL,'admin2@gmail.com',1,NULL,'admin2','$2a$10$5jNc5kaP8p39iPygb4iqT.vYOcj7hzrVjDZyXNrpheWX21ZscSRIK',NULL,1)
;

INSERT INTO zstore.products (id,created_date,deleted,last_modified_date,category,description,image_name,name,price,sale_price,status,created_by,last_modified_by) VALUES 
(11,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','<p><strong>Clothes Type:</strong> Hoodies</p>Style: Casual
Pattern Type: Snowman
Material: Polyester
Shirt Length: Regular
Sleeves Length: Full
Weight: 0.4890kg
Package: 1 x Hoodie','men1.png','Geometry Pattern Pullover Hoodie - Ruby',5.00,5.00,'new',7,7)
,(14,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','Plaid shirt with a super soft feeling. Features a classic collar, long sleeves, a chest pocket and a button-up front.
Shirts Type: Casual Shirts
Sleeves Length: Full
Collar: Turn-down Collar
Fit Type: Regular
Material: Cotton,Polyester,Viscose
Weight: 0.4100kg
Package: 1 x Shirt','men2.png','Plaid Print Pocket Button Up Shirt - Sea Green',10.00,10.00,'new',7,7)
,(17,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','Shirts Type: Casual Shirts
Sleeves Length: Full
Collar: Hooded 
Fit Type: Regular 
Material: Cotton,Polyester 
Weight: 0.4000kg 
Package: 1 x Shirt','men3.png','Plaid Drawstring Hooded Shirt - Blue',8.00,5.00,'best seller',7,7)
,(20,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','women','Style: Casual 
Collar: Crew Collar 
Sleeves Length: Short 
Material: Cotton,Polyester 
Pattern Type: Striped 
Weight: 0.1900kg 
Package: 1 x T-Shirt','women10.png','Striped Cropped T-Shirt - Fire Engine Red',10.00,9.00,'best seller',7,7)
,(23,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','Shirts Type: Casual Shirts 
Sleeves Length: Full 
Collar: Turn-down Collar 
Material: Cotton 
Weight: 0.5000kg 
Package: 1 x Shirt','men4.png','Long Sleeves Jarcquard Denim Mens Shirt - Blue',10.00,9.00,'best seller',8,8)
,(25,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','Shirts Type: Casual Shirts 
Occasionss: Beach,Casual,Holiday 
Sleeves Length: Short 
Collar: Turn-down Collar 
Fit Type: Regular 
Material: Polyester 
Weight: 0.2000kg 
Package: 1 x Shirt','men5.png','Flowers Printed Short Sleeve Shirt - Butterfly Blue',10.00,9.00,'new',7,7)
,(27,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','Shirts Type: Casual Shirts 
Sleeves Length: Full 
Collar: Hooded 
Fit Type: Regular 
Material: Polyester 
Weight: 0.3900kg 
Package: 1 x Shirt','men6.png','Casual Striped Hooded Shirt - Black',10.00,9.00,'new',7,7)
,(29,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','Shirts Type: Casual Shirts 
Sleeves Length: Full 
Collar: Turn-down Collar 
Fit Type: Regular 
Material: Polyester 
Weight: 0.2500kg 
Package: 1 x Shirt','men7.png','Retro Newspaper Print Button Up Shirt - White',10.00,9.00,'new',7,7)
,(31,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','Shirts Type: Casual Shirts 
Sleeves Length: Full 
Collar: Turn-down Collar 
Fit Type: Regular 
Material: Cotton,Polyester 
Weight: 0.2000kg 
Package: 1 x Shirt','men8.png','Rose Flowers Print Casual Shirt - Black',10.00,9.00,'new',8,8)
,(33,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','men','Shirts Type: Casual Shirts 
Occasionss: Casual 
Sleeves Length: Full 
Collar: Turn-down Collar 
Fit Type: Regular 
Material: Cotton 
Weight: 0.2900kg 
Package: 1 x Shirt','men9.png','Button Fly Long Sleeves Striped Shirt - Midnight Blue',10.00,9.00,'new',7,7)
;
INSERT INTO zstore.products (id,created_date,deleted,last_modified_date,category,description,image_name,name,price,sale_price,status,created_by,last_modified_by) VALUES 
(35,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','women','Style: Casual 
Shirt Length: Regular 
Collar: Round Collar 
Sleeves Length: Full 
Material: Polyester,Spandex 
Elasticity: Elastic 
Decoration: Tie 
Pattern Type: Striped 
Seasons: Autumn,Spring,Winter 
Weight: 0.2500kg 
Package: 1 x T-shirt','women1.png','Tie Striped T-shirt - Red',10.00,9.00,'new',7,7)
,(38,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','women','A cropped tee featuring multicolored stripes, a ribbed knit construction, a form-fitting silhouette, and a cropped length. Pair with high waisted denim bottoms for a complete look.
Style: Fashion 
Collar: Round Collar 
Sleeves Length: Short 
Material: Cotton,Polyacrylic,Polyurethane 
Pattern Type: Striped 
Weight: 0.2100kg 
Package: 1 x Tee','women2.png','Striped Ribbed Cropped Tee - Multi',10.00,9.00,'new',8,8)
,(41,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','women','This casual short-sleeved tee emphasizes a classic round collarline and abstract face printed pattern at the front. Wear it with denim shorts for a casual simple look.
Style: Casual 
Collar: Round Collar 
Sleeves Length: Short 
Material: Cotton 
Pattern Type: Print 
Weight: 0.2500kg 
Package: 1 x Tee','women3.png','Printed Short Sleeves Tee - Black',10.00,9.00,'new',7,7)
,(44,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','women','Style: Casual 
Collar: Round Collar 
Sleeves Length: Three Quarter 
Material: Cotton,Polyester 
Pattern Type: American Flag,Letter 
Seasons: Spring,Summer 
Weight: 0.1800kg 
Package: 1 x Tee','women4.png','American Flag Print Tee - Gray Goose',10.00,9.00,'new',7,7)
,(46,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','women','Crafted from comfy fabric, this trendy tee with round collar features letter print, color block design and asymmetric hemline.
Style: Fashion 
Collar: Round Collar 
Sleeves Length: Short 
Material: Polyester 
Pattern Type: Letter,Patchwork 
Weight: 0.2600kg 
Package: 1 x Tee','women5.png','Letter Print Contrast Asymmetric Tee - White And Black',10.00,9.00,'new',8,8)
,(48,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000','women','This casual short-sleeved tee with a classic round collarline features a comfy knitted fabric, contrasting striped graphic pattern throughout, and an alluring cropped length which shows your slimming waist. Wear it with denim shorts for a stylish look.
Style: Casual 
Shirt Length: Crop Top 
Collar: Round Collar 
Sleeves Length: Short 
Material: Polyester 
Pattern Type: Striped 
Seasons: Spring ','women6.png','Striped Knitted Tee - Medium Sea Green',10.00,9.00,'new',7,7)
;

INSERT INTO zstore.variants (id,created_date,deleted,last_modified_date,quantity,`size`,created_by,last_modified_by,product_id) VALUES 
(12,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',5,'L',7,7,11)
,(13,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',10,'XXL',7,7,11)
,(15,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',5,'S',7,7,14)
,(16,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',10,'M',7,7,14)
,(18,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,17)
,(19,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'M',7,7,17)
,(21,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,20)
,(22,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'M',7,7,20)
,(24,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',8,8,23)
,(26,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,25)
;
INSERT INTO zstore.variants (id,created_date,deleted,last_modified_date,quantity,`size`,created_by,last_modified_by,product_id) VALUES 
(28,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,27)
,(30,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,29)
,(32,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',8,8,31)
,(34,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,33)
,(36,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,35)
,(37,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'M',7,7,35)
,(39,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',8,8,38)
,(40,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'M',8,8,38)
,(42,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,41)
,(43,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'M',7,7,41)
;
INSERT INTO zstore.variants (id,created_date,deleted,last_modified_date,quantity,`size`,created_by,last_modified_by,product_id) VALUES 
(45,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,44)
,(47,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',8,8,46)
,(49,'2018-12-16 16:49:34.000',0,'2018-12-16 16:49:34.000',100,'S',7,7,48)
;

INSERT INTO zstore.orders (id,created_date,deleted,last_modified_date,customer_address,customer_city,customer_name,customer_phone,quantity,total,created_by,last_modified_by) VALUES 
('cjyv05bp','2018-12-15 23:33:37.000',0,'2018-12-15 23:33:37.000','93 Wall Street','New York','customer2','2126999999',1,9.00,6,6)
;

INSERT INTO zstore.orders (id,created_date,deleted,last_modified_date,customer_address,customer_city,customer_name,customer_phone,quantity,total,created_by,last_modified_by) VALUES 
('9dh6tepj','2018-12-16 16:10:02.000',0,'2018-12-16 16:10:02.000','200 Pearl street','New York','aqryuz','2126999999',2,15.00,6,6)
;

INSERT INTO zstore.order_lines (id,price,quantity,status,merchant_id,order_id,variant_id) VALUES 
(909,9.00,1,'Pending',5,'cjyv05bp',20)
;

INSERT INTO zstore.order_lines (id,price,quantity,status,merchant_id,order_id,variant_id) VALUES 
(1022,10.00,1,'Pending',7,'9dh6tepj',15)
,(2455,5.00,1,'Pending',7,'9dh6tepj',12)
;