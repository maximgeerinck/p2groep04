# Time frames
INSERT INTO timeframe (`id`, `start_time`, `end_time`) VALUES (1, "08:15:00", "09:15:00");
INSERT INTO timeframe (`id`, `start_time`, `end_time`) VALUES (2, "09:15:00", "10:15:00");
INSERT INTO timeframe (`id`, `start_time`, `end_time`) VALUES (3, "10:30:00", "12:30:00");
INSERT INTO timeframe (`id`, `start_time`, `end_time`) VALUES (4, "13:30:00", "14:30:00");
INSERT INTO timeframe (`id`, `start_time`, `end_time`) VALUES (5, "14:30:00", "15:30:00");
INSERT INTO timeframe (`id`, `start_time`, `end_time`) VALUES (6, "15:45:00", "16:45:00");
INSERT INTO timeframe (`id`, `start_time`, `end_time`) VALUES (7, "16:45:00", "17:45:00");

# Campussen
INSERT INTO campus VALUES (1, "Voskenslaan 270 9000 Gent", "Campus Schoonmeersen");
INSERT INTO campus VALUES (2, "Arbeidstraat 14 9300 Aalst", "Campus Aalst");
INSERT INTO campus VALUES (3, "Henleykaai 84, 9000 Gent", "Campus Mercator");

# Research domains
INSERT INTO researchdomain VALUES (1, "Programmeren");
INSERT INTO researchdomain VALUES (2, "Chemie");
INSERT INTO researchdomain VALUES (3, "Mechanica");
INSERT INTO researchdomain VALUES (4, "Talen");

# Locations
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (1, "B1001", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (2, "B1002", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (3, "B1003", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (4, "B1004", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (5, "B1005", 1);



# -- EXAMPLE DATA FOR TESTING -- #
INSERT INTO user (`id`, `amount_of_students`, `created_on`, `email`, `enabled`, `first_name`, `last_ip`, `last_name`, `password`,`salt`, `updated_on`) VALUES (1, 0, NOW(), "maximgeerinck@hotmail.com", 1, "Maxim", "127.0.0.1", "Geerinck", "test123", "privatesalt", NOW()); 
INSERT INTO planning (`id`, `allowed_to_view`, `start_time`, `end_time`, `visible`, `user_id`) VALUES (1, 1, "2014-03-09 11:05:18", "2014-04-09 11:05:17", 1, 1);

INSERT INTO presentation (`id`, `location_id`, `planning_id`, `timeframe_id`, `user_id`, `date`) VALUES (1, 1, 1, 1, 1, "2014-03-09");
