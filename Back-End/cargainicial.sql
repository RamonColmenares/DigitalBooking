
INSERT INTO cities(id, name, name_country) VALUES (1, 'Dubai','United Arab Emirates');
INSERT INTO cities(id, name, name_country) VALUES (2, 'Cancún','Mexico');
INSERT INTO cities(id, name, name_country) VALUES (3, 'Estambul','Turkey');
INSERT INTO cities(id, name, name_country) VALUES (4, 'New York','United States of America');
INSERT INTO cities(id, name, name_country) VALUES (5, 'Miami','United States of America');
INSERT INTO cities(id, name, name_country) VALUES (6, 'Paris','France');
INSERT INTO cities(id, name, name_country) VALUES (7, 'Doha','Qatar');
INSERT INTO cities(id, name, name_country) VALUES (8, ' Londres','England');
INSERT INTO cities(id, name, name_country) VALUES (9, 'Cairo','Egypt');
INSERT INTO cities(id, name, name_country) VALUES (10, 'Madrid','Spain');

INSERT INTO categories(id, title, description, url_image) VALUES (1, 'Hotels','807.105 hoteles', 'https://images.unsplash.com/photo-1618773928121-c32242e63f39');
INSERT INTO categories(id, title, description, url_image) VALUES (2, 'Departments','807.105 hoteles', 'https://images.unsplash.com/photo-1522708323590-d24dbb6b0267');
INSERT INTO categories(id, title, description, url_image) VALUES (3, 'Hostels','807.105 hoteles', 'https://images.unsplash.com/photo-1555854877-bab0e564b8d5');
INSERT INTO categories(id, title, description, url_image) VALUES (4, 'Bed and Breakfast','807.105 hoteles', 'https://images.unsplash.com/photo-1566073771259-6a8506099945');

INSERT INTO type_of_policies(id, title, description) VALUES (1, 'Rule','Rules and Policy');
INSERT INTO type_of_policies(id, title, description) VALUES (2, 'HealthAndSecurity','Health and security policy');
INSERT INTO type_of_policies(id, title, description) VALUES (3, 'Cancelation','Cancelation policy');

INSERT INTO products(id, name, description, category_id, city_id,policy_id) VALUES (1, 'Trendy Upgraded Studio Apartment in JLT', 'Key View is excited to welcome you to this trendy upgraded studio apartment in JLT. This unique place has a style all its own. Perfectly situated, you are minutes drive away from the lively Dubai Marina, JBR beach and exclusive Palm Jumeirah.', 2, 1,1);
INSERT INTO images(id, title, url, product_id) VALUES (1, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-583283319784519248/original/25feb7bc-2fb3-42a8-b338-7d9e16566481.jpeg?im_w=1200', 1);
INSERT INTO images(id, title, url, product_id) VALUES (2, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-583283319784519248/original/5865e119-d6fe-4a78-9571-dc575a54bea3.jpeg?im_w=1440', 1);
INSERT INTO images(id, title, url, product_id) VALUES (3, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-583283319784519248/original/bb25e802-6050-487a-8fd7-88381086feb1.jpeg?im_w=1440', 1);
INSERT INTO images(id, title, url, product_id) VALUES (4, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-583283319784519248/original/5350bd5f-7164-4369-940d-d011cc6cdf8a.jpeg?im_w=1440', 1);
INSERT INTO images(id, title, url, product_id) VALUES (5, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-583283319784519248/original/dfbdfd80-4a5b-4bbb-9927-1bcda935a843.jpeg?im_w=1440', 1);
INSERT INTO images(id, title, url, product_id) VALUES (6, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-583283319784519248/original/dd00caa6-bde4-4045-bcf3-ad56aeff90cb.jpeg?im_w=1440', 1);

INSERT INTO products(id, name, description, category_id, city_id,policy_id) VALUES (2, 'House in front of the eco-park and near the sea', 'Maximum stay for 2 people in 1 room available for visits, 2 full bathrooms. Living room (entertainment space with access to Netflix), kitchen - dining room. It also has a public balcony with a view of the mangrove, as well as garage space for 1 car.', 3, 2,1);
INSERT INTO images(id, title, url, product_id) VALUES (7, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-52134498/original/25067e40-cd87-4085-966c-a18d413eaadf.png?im_w=1200', 2);
INSERT INTO images(id, title, url, product_id) VALUES (8, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-52134498/original/8ba93337-35e3-4b42-92b3-feb01d1f4d89.png?im_w=1440', 2);
INSERT INTO images(id, title, url, product_id) VALUES (9, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-52134498/original/2db43d35-444f-4c25-bca5-aa1fe21ae493.jpeg?im_w=1440', 2);
INSERT INTO images(id, title, url, product_id) VALUES (10, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-52134498/original/b6311410-9517-4dd9-a395-28664ee86115.jpeg?im_w=1440', 2);

INSERT INTO products(id, name, description, category_id, city_id) VALUES (3, 'Tripple room 4', 'Our newly opened hotel is only 5 minutes walking distance from Yenikapi metro Aksaray tram stops. Our hotel is protected by the latest security camera systems. It is one of the quietest streets in Aksaray.', 1, 3);
INSERT INTO images(id, title, url, product_id) VALUES (11, '', 'https://a0.muscache.com/im/pictures/a55511b9-55e5-459d-a4b3-b23b61c05470.jpg?im_w=1200', 3);
INSERT INTO images(id, title, url, product_id) VALUES (12, '', 'https://a0.muscache.com/im/pictures/57351fa0-c4b8-4425-a33a-54fe27a7a2a5.jpg?im_w=1440', 3);
INSERT INTO images(id, title, url, product_id) VALUES (13, '', 'https://a0.muscache.com/im/pictures/e2085d66-a5fe-42f7-bc87-4d85ac0aed33.jpg?im_w=1440', 3);
INSERT INTO images(id, title, url, product_id) VALUES (14, '', 'https://a0.muscache.com/im/pictures/5beca85b-fdf5-4a93-bcd8-f7b342ed33a0.jpg?im_w=1440', 3);
INSERT INTO images(id, title, url, product_id) VALUES (15, '', 'https://a0.muscache.com/im/pictures/08cf8011-5f6b-4b81-9b59-7b42d8c98f39.jpg?im_w=1440', 3);

INSERT INTO products(id, name, description, category_id, city_id) VALUES (4, 'Room in hotel hosted by Millennium Downtown', 'Experience the stunning architecture of The Oculus and explore the One World Observatory and 9/11 Memorial Museum. Stay at the heart of the Financial District with unobstructed panoramas of Lower Manhattan from City View rooms.', 1, 4);
INSERT INTO images(id, title, url, product_id) VALUES (16, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-53843545/original/0d909786-f531-48da-8008-b4ae698c5193.jpeg?im_w=1200', 4);
INSERT INTO images(id, title, url, product_id) VALUES (17, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-53843545/original/4d99541e-e285-4444-9bde-fae3d713e988.jpeg?im_w=1440', 4);
INSERT INTO images(id, title, url, product_id) VALUES (18, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-53843545/original/dcd05cd5-7087-4f44-91a9-852be02222ba.jpeg?im_w=1440', 4);
INSERT INTO images(id, title, url, product_id) VALUES (19, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-53843545/original/ef3c461f-6e9a-4eec-9d97-58b61867835c.jpeg?im_w=1440', 4);
INSERT INTO images(id, title, url, product_id) VALUES (20, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-53843545/original/e182835d-5aad-4849-b508-274670639cda.jpeg?im_w=1440', 4);
INSERT INTO images(id, title, url, product_id) VALUES (21, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-53843545/original/d7bfb7c8-e04f-4dd3-b09b-3f065b91a680.jpeg?im_w=1440', 4);

INSERT INTO products(id, name, description, category_id, city_id) VALUES (5, 'Celeste House Perfect for Couples 1 BR APT', 'Allow us to welcome you to the cosiest house in all the area!! Known for its creative international restaurants, colorful street murals, and fruit stands, the Caribbean-style also has a thriving arts scene.', 2, 5);
INSERT INTO images(id, title, url, product_id) VALUES (22, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-50268340/original/6e8fc363-28eb-4c29-8673-cfc0e6b7a4f1.jpeg?im_w=1200', 5);
INSERT INTO images(id, title, url, product_id) VALUES (23, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-50268340/original/3f7cbe54-ec9f-4891-a216-5d7bd7d714bd.jpeg?im_w=1440', 5);
INSERT INTO images(id, title, url, product_id) VALUES (24, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-50268340/original/104da658-d2ac-45ad-abf1-e672da4e4dc9.jpeg?im_w=1440', 5);
INSERT INTO images(id, title, url, product_id) VALUES (25, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-50268340/original/2266f72b-61ca-4330-88f4-261e9bc55b45.jpeg?im_w=1440', 5);
INSERT INTO images(id, title, url, product_id) VALUES (26, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-50268340/original/a377563e-b98f-4b63-b611-3188d4003857.jpeg?im_w=1440', 5);

INSERT INTO products(id, name, description, category_id, city_id) VALUES (6, 'Bright studio near the quays of the Seine', 'Between Paris and La Défense and a few steps from the banks of the Seine, Residhome Paris Asnières Park is located in the renovated Les Grésillons district. Ideal for business or leisure stays.', 2, 6);
INSERT INTO images(id, title, url, product_id) VALUES (27, '', 'https://a0.muscache.com/im/pictures/07bdd0f0-72e1-434f-84e3-f9a05bfe4c26.jpg?im_w=1200', 6);
INSERT INTO images(id, title, url, product_id) VALUES (28, '', 'https://a0.muscache.com/im/pictures/977e2f45-3405-47b0-91aa-964006e02b6d.jpg?im_w=1440', 6);
INSERT INTO images(id, title, url, product_id) VALUES (29, '', 'https://a0.muscache.com/im/pictures/8c9a9e60-2636-4512-b742-fe7a726af3b1.jpg?im_w=1440', 6);
INSERT INTO images(id, title, url, product_id) VALUES (30, '', 'https://a0.muscache.com/im/pictures/54a11569-abdd-4bc7-bd2e-4b9de5110e66.jpg?im_w=1440', 6);
INSERT INTO images(id, title, url, product_id) VALUES (31, '', 'https://a0.muscache.com/im/pictures/aa5f25f2-e955-4c7c-bc53-7d02aa9217fc.jpg?im_w=1440', 6);

INSERT INTO products(id, name, description, category_id, city_id) VALUES (7, 'Luxury VIP Bedroom SEA VIEW + Private Bath in Doha', 'Great Location in the Center of Doha at a walking distance from Doha City Center and Beach with a stunning Sea View Room.', 1, 7);
INSERT INTO images(id, title, url, product_id) VALUES (32, '', 'https://a0.muscache.com/im/pictures/01852baa-c59e-403f-a757-abe633ad0dcf.jpg?im_w=1200', 7);
INSERT INTO images(id, title, url, product_id) VALUES (33, '', 'https://a0.muscache.com/im/pictures/b58f65d6-39a9-469d-b1d7-ed277ba0f801.jpg?im_w=1440', 7);
INSERT INTO images(id, title, url, product_id) VALUES (34, '', 'https://a0.muscache.com/im/pictures/2e214d16-a2de-40b4-a436-22361e7176ef.jpg?im_w=1440', 7);
INSERT INTO images(id, title, url, product_id) VALUES (35, '', 'https://a0.muscache.com/im/pictures/0203cb55-9e93-4bff-953b-60bb2e4600f7.jpg?im_w=1440', 7);
INSERT INTO images(id, title, url, product_id) VALUES (36, '', 'https://a0.muscache.com/im/pictures/9054f1be-e6f6-49d4-afa4-6c22805d9245.jpg?im_w=1440', 7);

INSERT INTO products(id, name, description, category_id, city_id) VALUES (8, 'Welcoming comfortable room for one.', 'Comfortable, stylish room located close to fast links into central London. Walking distance from Bakerloo and overground services from Willesden Junction. Bed only.', 4, 8);
INSERT INTO images(id, title, url, product_id) VALUES (37, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-581859131080535622/original/5b588337-49d8-483e-acb2-99ae7ffef48b.jpeg?im_w=1200', 8);
INSERT INTO images(id, title, url, product_id) VALUES (38, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-581859131080535622/original/023ea60a-0dd4-43e9-8592-ed02f40de6e1.jpeg?im_w=1440', 8);
INSERT INTO images(id, title, url, product_id) VALUES (39, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-581859131080535622/original/576c197f-c366-417e-9dd3-0779eb672825.jpeg?im_w=1440', 8);
INSERT INTO images(id, title, url, product_id) VALUES (40, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-581859131080535622/original/37f8e0d3-f8ba-4d65-acb5-62d48b4c77d0.jpeg?im_w=1440', 8);

INSERT INTO products(id, name, description, category_id, city_id) VALUES (9, 'Lemon Spaces At The Nile - 2 BR Apartment', 'This 2-bedroom space is directly overlooking the Nile having panorama windows from both sides where you can see the pyramids from one of them. Natural light goes through all areas of the space.', 2, 9);
INSERT INTO images(id, title, url, product_id) VALUES (41, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-591796484647067266/original/5a520ff0-5163-4262-aaaf-dc781cd744c4.jpeg?im_w=1200', 9);
INSERT INTO images(id, title, url, product_id) VALUES (42, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-591796484647067266/original/62357363-395d-4069-8321-47dd174d8a8e.jpeg?im_w=1440', 9);
INSERT INTO images(id, title, url, product_id) VALUES (43, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-591796484647067266/original/9c342c12-355a-4df8-afe5-64aa1201d13c.jpeg?im_w=1440', 9);
INSERT INTO images(id, title, url, product_id) VALUES (44, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-591796484647067266/original/b48c51e0-3765-439f-bf84-d956bf9319d7.jpeg?im_w=1440', 9);
INSERT INTO images(id, title, url, product_id) VALUES (45, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-591796484647067266/original/631e73fa-70b0-4100-bbcd-d203705f5b3c.jpeg?im_w=1440', 9);

INSERT INTO products(id, name, description, category_id, city_id) VALUES (10, 'Single room - private [Atocha- Sol]', 'Private single room in calle atocha, equipped with full private bathroom, hair dryer, TV , air conditioning, safe suitable for laptops, high speed WIFI, access lock with keypad and card.', 4, 10);
INSERT INTO images(id, title, url, product_id) VALUES (46, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-52728535/original/12a56105-db02-43a9-bd34-ed24c627d649.jpeg?im_w=1200', 10);
INSERT INTO images(id, title, url, product_id) VALUES (47, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-52728535/original/8546a5c0-1992-4488-b9c6-96b7387f40ae.jpeg?im_w=1440', 10);
INSERT INTO images(id, title, url, product_id) VALUES (48, '', 'https://a0.muscache.com/im/pictures/miso/Hosting-52728535/original/e2098357-72e7-41e1-83f4-7a7da8ff4a27.jpeg?im_w=1440', 10);

-- INSERT INTO images(id, title, url, product_id) VALUES (, '', '', );
-- INSERT INTO products(id, description, name, category_id, city_id) VALUES (, '', '', , );
