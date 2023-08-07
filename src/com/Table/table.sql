-- user_type
CREATE TABLE user_type(
    id serial PRIMARY KEY,
    user_type VARCHAR(50) not null
);

-- user
CREATE TABLE "user"(
    id serial PRIMARY KEY,
    first_name VARCHAR(255) not null,
    last_name VARCHAR(255) not null,
    gender CHAR(1),
    email VARCHAR(250) not null,
    phone_number VARCHAR(50),
    profile_url_img VARCHAR(255),
    nationality VARCHAR(255),
    birthdate DATE,
    password VARCHAR(255) not null,
    id_user_type int REFERENCES user_type(id) not null,
    CHECK (gender='M' Or gender='F')
);

-- reservation
CREATE TABLE reservation(
    id serial PRIMARY KEY,
    arrival TIMESTAMP not null,
    departure TIMESTAMP not null,
    date_reservation TIMESTAMP not null,
    id_user int REFERENCES "user"(id) not null,
    check (arrival < departure and date_reservation <= arrival) 
);

-- paiement
CREATE TABLE paiement(
    id serial PRIMARY KEY,
    date_paiement TIMESTAMP not null,
    method_paiement VARCHAR(100) not NULL,
    amount_paid DOUBLE PRECISION not null,
    id_reservation int REFERENCES reservation(id) not null,
    CHECK (method_paiement= 'mobile_money' OR method_paiement = 'cash')
);

-- hotel
CREATE TABLE hotel(
    id serial PRIMARY KEY,
    hotel_name VARCHAR(100) not null,
    adress VARCHAR(255) not null,
    city VARCHAR(255) not null,
    state VARCHAR(255),
    phone_number VARCHAR(100) not null
);

-- media
CREATE TABLE media(
    id serial PRIMARY KEY,
    url_media VARCHAR(255) not null UNIQUE
);

--have_media
CREATE TABLE have_media(
    id serial PRIMARY KEY,
    id_hotel INT REFERENCES hotel(id) not null,
    id_media INT REFERENCES media(id) not null
);

-- resto
CREATE TABLE resto(
    id serial PRIMARY KEY,
    speciality VARCHAR(255) not null,
    resto_url_img VARCHAR(255),
    description text,
    id_hotel INT REFERENCES hotel(id) not null
);

-- promotion
CREATE TABLE promotion(
    id serial PRIMARY KEY,
    start_date date not null,
    end_date date not null,
    reduction DOUBLE PRECISION not null,
    description text,
    check (start_date <= end_date) 
);

-- have_promotion
CREATE TABLE have_promotion(
    id serial PRIMARY KEY,
    id_hotel int REFERENCES hotel(id) not null,
    id_promotion int REFERENCES promotion(id) not null
);

-- room_type
CREATE TABLE room_type(
    id serial PRIMARY KEY,
    type VARCHAR(100) not null unique
);

-- room
CREATE TABLE room(
    id serial PRIMARY KEY,
    room_category VARCHAR(100) not null,
    room_name VARCHAR(100),
    room_url_image VARCHAR(255),
    description text,
    price_per_night DOUBLE PRECISION,
    price_per_hour DOUBLE PRECISION,
    id_room_type int REFERENCES room_type(id) not null,
    id_hotel int REFERENCES hotel(id) not null
);

-- room_content
CREATE TABLE room_content(
    id serial PRIMARY KEY,
    content_name VARCHAR(100) not null,
    content_url_img VARCHAR(250)
);

-- room_contain
CREATE TABLE room_contain(
    id serial PRIMARY KEY,
    id_room int REFERENCES room(id) not null,
    id_room_content int REFERENCES room_content(id) not null
);

-- reservation_contain
CREATE TABLE reservation_contain(
    id serial PRIMARY KEY,
    room_quantity int not null,
    id_reservation int REFERENCES reservation(id) not null,
    id_room int REFERENCES room(id) not null
);

-- bookmarks
CREATE TABLE bookmarks(
    id serial PRIMARY KEY,
    bookmark_name VARCHAR(255),
    id_room int REFERENCES room(id) not null,
    id_user int REFERENCES "user"(id) not null
);

-- give_room_feedback
CREATE TABLE give_room_feedback(
    id serial PRIMARY KEY,
    text_body text,
    date_feedback date not null,
    note int not null,
    id_room int REFERENCES room(id) not null,
    id_user int REFERENCES "user"(id) not null,
    check (note >=0 and note<=5)
);

-- give_hotel_feedback
CREATE TABLE give_hotel_feedback(
    id serial PRIMARY KEY,
    text_body text,
    date_feedback date not null,
    note int not null,
    id_hotel int REFERENCES hotel(id) not null,
    id_user int REFERENCES "user"(id) not null,
    check (note >=0 and note<=5)
);


-- partnership
CREATE TABLE partnership(
    id serial PRIMARY KEY,
    date_proposition TIMESTAMP,
    partnership_type VARCHAR(200) not null,
    is_accepted BOOLEAN not null,
    message TEXT
);

-- have_proposition
CREATE TABLE have_proposition(
    id serial PRIMARY KEY,
    id_hotel int REFERENCES hotel(id) not null,
    id_partnership int REFERENCES partnership(id) not null
);

-- propose
CREATE TABLE propose(
    id serial PRIMARY KEY,
    id_user int REFERENCES "user"(id) not null,
    id_partnership int REFERENCES partnership(id) not null
);
