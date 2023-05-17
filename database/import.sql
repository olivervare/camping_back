-- Role table
insert into public.role (id, name) values (default, 'admin');
insert into public.role (id, name) values (default, 'customer');

-- User table
insert into public."user" (id, role_id, username, password, status) values (default, 1, 'admin', '123', 'A');
insert into public."user" (id, role_id, username, password, status) values (default, 2, 'rain', '123', 'A');
insert into public."user" (id, role_id, username, password, status) values (default, 2, 'matkaja', '123', 'A');
insert into public."user" (id, role_id, username, password, status) values (default, 2, 'ants', '123', 'D');

-- Role table
insert into public.county (id, name) values (default, 'Harjumaa');
insert into public.county (id, name) values (default, 'Hiiumaa');
insert into public.county (id, name) values (default, 'Ida-Virumaa');
insert into public.county (id, name) values (default, 'Lääne-Virumaa');
insert into public.county (id, name) values (default, 'Jõgevamaa');
insert into public.county (id, name) values (default, 'Järvamaa');
insert into public.county (id, name) values (default, 'Läänemaa');
insert into public.county (id, name) values (default, 'Põlvamaa');
insert into public.county (id, name) values (default, 'Pärnumaa');
insert into public.county (id, name) values (default, 'Raplamaa');
insert into public.county (id, name) values (default, 'Saaremaa');
insert into public.county (id, name) values (default, 'Tartumaa');
insert into public.county (id, name) values (default, 'Valgamaa');
insert into public.county (id, name) values (default, 'Viljandimaa');
insert into public.county (id, name) values (default, 'Võrumaa');

-- Contact table
insert into public.contact (id, user_id, first_name, last_name, email, phone_no, image) values (default, 1, 'Andres', 'Admin', 'admin@mail.ee', '+3725566777', null);
insert into public.contact (id, user_id, first_name, last_name, email, phone_no, image) values (default, 2, 'Rain', 'Süür', 'rain@mail.ee', '+43009004352', null);
insert into public.contact (id, user_id, first_name, last_name, email, phone_no, image) values (default, 3, 'Mati', 'Matkaja', 'matkaja@mail.ee', '+37245063454', null);
insert into public.contact (id, user_id, first_name, last_name, email, phone_no, image) values (default, 4, 'Ants', 'Passiivne', 'ants@mail.ee', null, null);

-- Location table
insert into public.location (id, county_id, address, longitude, latitude) values (default, 1, 'Matkaplatsi 4, Aegviidu', 59.286220, 25.612050);

-- Listing table
insert into public.listing (id, owner_user_id, location_id, name, description, additional_info, price, status) values (default,
    2, 1, 'Aegviidu külastuskeskus', 'See on üks väga äge telkimisplats. Siin on kõik vajalik olemas - on päikest, on vihma. ' ||
                                     'Kõik on lageda taeva all! Oled heldesti oodatud.', 'Telkida saab', 23, 'A');

-- Feature table
insert into public.feature (id, name) values (default, 'Lõkkeplats/grillplats');
insert into public.feature (id, name) values (default, 'Kämpinguauto koht');
insert into public.feature (id, name) values (default, 'Telgi laenutus');
insert into public.feature (id, name) values (default, 'Joogivesi');
insert into public.feature (id, name) values (default, 'Elekter');
insert into public.feature (id, name) values (default, 'Pesemisvõimalus');
insert into public.feature (id, name) values (default, 'WC/DC');

-- Listing feature tabel
insert into public.listing_feature(id, listing_id, feature_id, is_selected) values (default, 1, 1, true);
insert into public.listing_feature(id, listing_id, feature_id, is_selected) values (default, 1, 2, false);
insert into public.listing_feature(id, listing_id, feature_id, is_selected) values (default, 1, 3, false);
insert into public.listing_feature(id, listing_id, feature_id, is_selected) values (default, 1, 4, true);
insert into public.listing_feature(id, listing_id, feature_id, is_selected) values (default, 1, 5, true);
insert into public.listing_feature(id, listing_id, feature_id, is_selected) values (default, 1, 6, true);
insert into public.listing_feature(id, listing_id, feature_id, is_selected) values (default, 1, 7, true);

-- Image table
insert into public.image(id, listing_id, data) values (default, 1, null);
insert into public.image(id, listing_id, data) values (default, 1, null);

-- Review table
insert into public.review(id, listing_id, user_id, score, comment) values (default, 1, 1, 5, 'Väga hea host ja kohvi pakuti ka.');
insert into public.review(id, listing_id, user_id, score, comment) values (default, 1, 3, 5, 'OK koht');
insert into public.review(id, listing_id, user_id, score, comment) values (default, 1, 4, 4, null);