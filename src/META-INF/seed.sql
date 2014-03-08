# Time frames
INSERT INTO timeframe (`ID`, `endTime`, `startTime`) VALUES 
    (1, "08:15:00", "09:15:00"),
    (2, "09:15:00", "10:15:00"),
    (3, "10:30:00", "12:30:00"),
    (4, "13:30:00", "14:30:00"),
    (5, "14:30:00", "15:30:00"),
    (6, "15:45:00", "16:45:00"),
    (7, "16:45:00", "17:45:00");

# Campussen
INSERT INTO campus (`id`, `adres`, `name`) VALUES 
    (1, "Voskenslaan 270 9000 Gent", "Campus Schoonmeersen"),
    (2, "Arbeidstraat 14 9300 Aalst", "Campus Aalst"),
    (3, "Henleykaai 84, 9000 Gent", "Campus Mercator");

# Locations
INSERT INTO location (`classroom`, `Locationid`) VALUES
    ("B1001", 1), ("B1002", 1), ("B1003", 1), ("B1004", 1), ("B1005", 1), ("B1006", 1), ("B1007", 1), ("B1008", 1), ("B1009", 1), ("B1010", 1), ("B1011", 1), ("B1012", 1),
    ("B2001", 1), ("B2002", 1), ("B2003", 1), ("B2004", 1), ("B2005", 1), ("B2006", 1), ("B2007", 1), ("B2008", 1), ("B2009", 1), ("B2010", 1), ("B2011", 1), ("B2012", 1),
    ("B3001", 1), ("B3002", 1), ("B3003", 1), ("B3004", 1), ("B3005", 1), ("B3006", 1), ("B3007", 1), ("B3008", 1), ("B3009", 1), ("B3010", 1), ("B3011", 1), ("B3012", 1),
    ("B4001", 1), ("B4002", 1), ("B4003", 1), ("B4004", 1), ("B4005", 1), ("B4006", 1), ("B4007", 1), ("B4008", 1), ("B4009", 1), ("B4010", 1), ("B4011", 1), ("B4012", 1);

# Research domains
INSERT INTO researchdomain (`id`, `name`) VALUES
    (1, "Programmeren"),
    (2, "Chemie"),
    (3, "Mechanica"),
    (4, "Talen");