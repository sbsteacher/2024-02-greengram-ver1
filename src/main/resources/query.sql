-- user 테이블
DROP TABLE user;
CREATE TABLE USER (
      user_id BIGINT AUTO_INCREMENT PRIMARY KEY
    , uid VARCHAR(30) UNIQUE NOT NULL
    , upw VARCHAR(100) NOT NULL
    , nick_name VARCHAR(30)
    , pic VARCHAR(70)
    , created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , updated_at DATETIME ON UPDATE CURRENT_TIMESTAMP
);

-- feed 테이블
DROP TABLE feed;
CREATE TABLE feed (
      feed_id BIGINT AUTO_INCREMENT PRIMARY KEY
    , writer_user_id BIGINT NOT NULL
    , contents VARCHAR(1000)
    , location VARCHAR(30)
    , created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , updated_at DATETIME ON UPDATE CURRENT_TIMESTAMP
    , FOREIGN KEY (writer_user_id) REFERENCES user(user_id)
);

-- feed_pics 테이블
CREATE TABLE feed_pics(
      feed_pic_id BIGINT AUTO_INCREMENT PRIMARY KEY
    , feed_id BIGINT NOT NULL
    , pic VARCHAR(70) NOT NULL
    , created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
    , FOREIGN KEY (feed_id) REFERENCES feed(feed_id)
);
