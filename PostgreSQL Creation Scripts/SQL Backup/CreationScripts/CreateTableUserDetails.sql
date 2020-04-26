-- Table: users.user_details

-- DROP TABLE users.user_details;

CREATE TABLE users.user_details
(
    _id bigint NOT NULL,
    CONSTRAINT user_details_pkey PRIMARY KEY (_id)
)

TABLESPACE pg_default;

ALTER TABLE users.user_details
    OWNER to postgres;