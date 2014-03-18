# Roles
# INSERT INTO role (`id`, `role_name`) VALUES (1, "ROLE_BPC");
# INSERT INTO role (`id`, `role_name`) VALUES (2, "ROLE_PROMOTOR");
# INSERT INTO role (`id`, `role_name`) VALUES (3, "ROLE_STUDENT");

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
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (1, "B0001", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (2, "B0003", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (3, "B0005", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (4, "B0006", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (5, "B0007", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (6, "B0008", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (7, "B0009", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (8, "B0010", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (9, "B0011", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (10, "B0012", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (11, "B0013", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (12, "B0014", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (13, "B0015", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (14, "B0016", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (15, "B0017", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (16, "B0018", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (17, "B0019", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (18, "B0020", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (19, "B0021", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (20, "B0022", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (21, "B0023", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (22, "B0024", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (23, "B0025", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (24, "B0026", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (26, "B0028", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (28, "B0030", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (30, "B0032", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (31, "B1001", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (32, "B1002", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (33, "B1003", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (34, "B1004", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (35, "B1005", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (36, "B1006", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (37, "B1007", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (38, "B1008", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (39, "B1009", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (40, "B1010", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (41, "B1011", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (42, "B1012", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (43, "B1013", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (44, "B1014", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (45, "B1015", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (46, "B1016", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (47, "B1017", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (48, "B1018", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (49, "B1019", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (50, "B1020", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (51, "B1021", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (52, "B1022", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (53, "B1023", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (54, "B1024", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (55, "B1025", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (56, "B1026", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (57, "B1027", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (58, "B1028", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (59, "B1029", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (60, "B1030", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (61, "B1032", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (62, "B2001", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (63, "B2002", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (64, "B2003", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (65, "B2004", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (66, "B2005", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (67, "B2006", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (68, "B2007", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (69, "B2008", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (70, "B2009", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (71, "B2010", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (72, "B2011", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (73, "B2012", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (74, "B2013", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (75, "B2014", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (76, "B2015", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (77, "B2016", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (78, "B2017", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (79, "B2018", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (80, "B2019", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (81, "B2020", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (82, "B2021", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (83, "B2022", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (84, "B2023", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (85, "B2024", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (86, "B2025", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (87, "B2026", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (88, "B2028", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (89, "B3001", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (90, "B3002", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (91, "B3003", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (92, "B3004", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (93, "B3005", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (94, "B3006", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (95, "B3007", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (96, "B3008", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (97, "B3009", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (98, "B3010", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (99, "B3011", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (100, "B3012", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (101, "B3013", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (102, "B3014", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (103, "B3015", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (104, "B3016", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (105, "B3017", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (106, "B3018", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (107, "B3019", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (108, "B3020", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (109, "B3021", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (110, "B3022", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (111, "B3023", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (112, "B3024", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (113, "B3025", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (114, "B3026", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (115, "B3027", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (116, "B3028", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (117, "B3029", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (118, "B3030", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (119, "B3032", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (120, "B3034", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (121, "B3036", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (122, "B3038", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (123, "B3040", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (124, "B4001", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (125, "B4002", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (126, "B4003", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (127, "B4004", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (128, "B4005", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (129, "B4006", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (130, "B4007", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (131, "B4008", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (132, "B4009", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (133, "B4010", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (134, "B4011", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (135, "B4012", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (136, "B4013", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (137, "B4014", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (138, "B4015", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (139, "B4016", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (140, "B4017", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (141, "B4018", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (142, "B4019", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (143, "B4020", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (144, "B4021", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (145, "B4022", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (146, "B4023", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (147, "B4024", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (148, "B4025", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (149, "B4026", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (150, "B4028", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (151, "B4030", 1);
INSERT INTO location (`id`, `classroom`, `campus_id`) VALUES (152, "B4032", 1);

# -- EXAMPLE DATA FOR TESTING -- #

# suggestions
INSERT INTO suggestion (`id`, `subject`, `researchdomain_id`) VALUES (1, "Encryptie dinges", 1);
INSERT INTO suggestion (`id`, `subject`, `researchdomain_id`) VALUES (2, "Bloemen!", 2);

# user: Bert van Vreckem - BPC
INSERT INTO bpcoordinator (`id`, `created_on`, `email`, `enabled`, `first_name`, `last_ip`, `last_name`, `password`,`salt`, `updated_on`) VALUES (1, NOW(), "bert.vanvreckem@hogent.be", 1, "Bert", "127.0.0.1", "Van Vreckem", "test123", "privatesalt", NOW()); 
# INSERT INTO user_role (`user_id`, `role_id`) VALUES (1, 1);

# user: Johan Van Schoor - Promotor
INSERT INTO promotor (`id`, `amount_of_students`, `created_on`, `email`, `enabled`, `first_name`, `last_ip`, `last_name`, `password`,`salt`, `updated_on`) VALUES (1, 0, NOW(), "johan.vanschoor@hogent.be", 1, "Johan", "127.0.0.1", "Van Schoor", "test123", "privatesalt", NOW()); 
# INSERT INTO user_role (`user_id`, `role_id`) VALUES (2, 2);

# user: Irina Malfait - Promotor
INSERT INTO promotor (`id`, `amount_of_students`, `created_on`, `email`, `enabled`, `first_name`, `last_ip`, `last_name`, `password`,`salt`, `updated_on`) VALUES (2, 0, NOW(), "irina.malfait@hogent.be", 1, "Irina", "127.0.0.1", "Malfait", "test123", "privatesalt", NOW()); 
# INSERT INTO user_role (`user_id`, `role_id`) VALUES (3, 2);

# user: Maxim Geerinck - STUDENT
INSERT INTO student (`id`, `created_on`, `email`, `enabled`, `first_name`, `last_ip`, `last_name`, `password`,`salt`, `updated_on`, `suggestion_id`) VALUES (1, NOW(), "maximgeerinck@hotmail.com", 1, "Maxim", "127.0.0.1", "Geerinck", "test123", "privatesalt", NOW(), 1); 
# INSERT INTO user_role (`user_id`, `role_id`) VALUES (4, 3);

# user: Logan Dupont - STUDENT
INSERT INTO student (`id`, `created_on`, `email`, `enabled`, `first_name`, `last_ip`, `last_name`, `password`,`salt`, `updated_on`, `suggestion_id`) VALUES (2, NOW(), "logandupont@hotmail.com", 1, "Logan", "127.0.0.1", "Dupont", "test123", "privatesalt", NOW(), 2); 
# INSERT INTO user_role (`user_id`, `role_id`) VALUES (5, 3);

# planning, door BPC
INSERT INTO planning (`id`, `allowed_to_view`, `start_time`, `end_time`, `visible`, `bpcoordinator_id`) VALUES (1, 1, NOW() - INTERVAL 1 DAY, NOW() + INTERVAL 1 DAY, 1, 1);
INSERT INTO presentation (`id`, `location_id`, `planning_id`, `timeframe_id`, `presentator_id`, `date`) VALUES (1, 1, 1, 1, 1, CURDATE());
INSERT INTO presentation (`id`, `location_id`, `planning_id`, `timeframe_id`, `presentator_id`, `date`) VALUES (2, 1, 1, 4, 2, CURDATE() + INTERVAL 1 DAY);

