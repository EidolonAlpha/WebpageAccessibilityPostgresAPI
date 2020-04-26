-- Table: users.css_rule_sets

-- DROP TABLE users.css_rule_sets;

CREATE TABLE users.css_rule_sets
(
    _id bigint NOT NULL,
    css_rule_set character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT css_rule_sets_pkey PRIMARY KEY (_id)
)

TABLESPACE pg_default;

ALTER TABLE users.css_rule_sets
    OWNER to postgres;