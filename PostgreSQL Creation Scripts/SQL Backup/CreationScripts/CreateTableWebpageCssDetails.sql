-- Table: users.webpage_css_details

-- DROP TABLE users.webpage_css_details;

CREATE TABLE users.webpage_css_details
(
    _id bigint NOT NULL,
    url character varying(255) COLLATE pg_catalog."default",
    css_rule_set_id bigint NOT NULL,
    user_id bigint NOT NULL,
    CONSTRAINT webpage_css_details_pkey PRIMARY KEY (_id),
    CONSTRAINT css_rule_set_id FOREIGN KEY (css_rule_set_id)
        REFERENCES users.css_rule_sets (_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)

TABLESPACE pg_default;

ALTER TABLE users.webpage_css_details
    OWNER to postgres;