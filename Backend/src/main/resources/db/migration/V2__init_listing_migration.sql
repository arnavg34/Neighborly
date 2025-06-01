CREATE TABLE listing (
                         id UUID PRIMARY KEY,
                         title VARCHAR(255) NOT NULL,
                         description TEXT NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         user_id UUID NOT NULL,
                         created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

                         CONSTRAINT fk_listing_user FOREIGN KEY (user_id) REFERENCES users(id)
);