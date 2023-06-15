INSERT INTO product_entity (pro_id, pro_price, pro_category, pro_name, pro_type)
VALUES (111, 45000.0, 'electronics', 'lenovo yoga', 'laptop'),
       (222, 25000.0, 'home appliances', 'lg washing machine', 'washing machine'),
       (333, 60000.0, 'electronics', 'hp pavilion 360', 'laptop'),
       (444, 1200.0, 'clothing', 'us polo assn', 't-shirt'),
       (555, 350.0, 'furniture', 'neelkamal bean bag', 'sofa set');


INSERT INTO charges (del_charges, discount, gst, pro_category)
VALUES (350.0, 15.0, 18.0, 'electronics'),
       (800.0, 22.0, 24.0, 'home appliances'),
       (0.0, 40.0, 12.0, 'clothing'),
       (300.0, 10.0, 18.0, 'furniture');

