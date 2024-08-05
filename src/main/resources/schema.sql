CREATE TABLE event (
    id INT AUTO_INCREMENT PRIMARY KEY,
    event_name VARCHAR(255),
    event_date DATE,
    event_time TIME,
    event_location VARCHAR(255) ,
    available_tickets INT
);
