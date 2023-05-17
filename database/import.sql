/* ------------- USER PACKAGE ------------- */
/*role*/
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'admin');
INSERT INTO public.role (id, name) VALUES (DEFAULT, 'customer');

/*user*/
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 1, 'admin', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'rain', '123', 'A');
INSERT INTO public."user"(id, role_id, username, password, status)
VALUES (DEFAULT, 2, 'matkaja', '123', 'A');

INSERT INTO public."user"(id, role_id, username, password, status) VALUES (DEFAULT, 2, 'ants', '123', 'D');

/*contact*/
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 1, 'Admin', 'Admin', 'admin@mail.ee', '111222333', null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 2, 'Rain', 'Müür', 'rain@mail.ee', '222333444', null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 3, 'Matka', 'Sell', 'matka@mail.ee', '333222111', null);
INSERT INTO public.contact(id, user_id, first_name, last_name, email, phone_no, image) VALUES (DEFAULT, 4, 'Ants', 'Passiivne', 'ants@mail.ee', null, null);


/* ------------- LISTING PACKAGE ------------- */
/*county*/
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Harjumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Hiiumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Ida-Virumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Jõgevamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Järvamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Lääne-Virumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Põlvamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Pärnumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Raplamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Saaremaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Tartumaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Valgamaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Viljandimaa');
INSERT INTO public.county(id, name) VALUES (DEFAULT, 'Võrumaa');


/*location*/
INSERT INTO public.location(id, county_id, address, longitude, latitude) VALUES (DEFAULT, 1, 'Matkaplatsi 4, Aegviidu', 59.286220, 25.612050);


/*listing*/
INSERT INTO public.listing (id, owner_user_id, location_id, name, description, additional_info, price, status) VALUES (DEFAULT, 2, 1, 'Aegviidu külastuskeskus', 'See on üks väga äge telkimisplats. Siin on kõik vajalik olemas - on päikest on vihma. ' ||
                                                                                                                                                                 'Kõik on lageda taeva all! Oled heldesti oodatud.', 'Telkida saab', 23, 'A');

/*features*/
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Lõkkeplats/grillplats');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Kämpinguauto koht');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Telgi laenutus');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Joogivesi');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Elekter');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'Pesemisvõimalus');
INSERT INTO public.feature (id, name) VALUES (DEFAULT, 'WC/DC');


/*listing_features*/
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 1, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 2, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 3, false);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 4, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 5, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 6, true);
INSERT INTO public.listing_feature(id, listing_id, feature_id, is_selected) VALUES (DEFAULT, 1, 7, true);


/*image*/
INSERT INTO public.image(id, listing_id, data) VALUES (DEFAULT, 1, E'\\x000800');
INSERT INTO public.image(id, listing_id, data) VALUES (DEFAULT, 1, E'\\x000800');


/* ------------- REVIEW PACKAGE ------------- */
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 1, 1, 5, 'Väga hea host ja kohvi pakuti ka.');
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 1, 3, 3, 'OK koht');
INSERT INTO public.review(id, listing_id, user_id, score, comment) VALUES (DEFAULT, 1, 4, 4, null);


/* ------------- BOOKING PACKAGE ------------- */


