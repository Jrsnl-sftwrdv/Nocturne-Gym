CREATE TABLE membership_plans (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL UNIQUE,
    duration_value INT NOT NULL,
    duration_unit VARCHAR(20) NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    created_at DATETIME(6) NOT NULL,
    CONSTRAINT chk_duration_positive CHECK (duration_value > 0),
    CONSTRAINT chk_price_not_negative CHECK (price >= 0)
);