USE `hb_student_tracker`;

CREATE TABLE `instructor_details` (
    `id` int (11) NOT NULL AUTO_INCREMENT,
    `youtube_channel` varchar(128) default null,
    `hobby` varchar(45) default null,
    primary key (`id`)
);

CREATE TABLE `instructor` (
    `id` int (11) NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) default null,
    `last_name` varchar(45) default null,
    `email` varchar(45) default null,
    `instructor_detail_id` int(11) default null,
    primary key (`id`)
);