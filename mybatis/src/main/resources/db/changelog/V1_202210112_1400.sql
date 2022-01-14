create schema security_schema;
create schema todo_core;

CREATE TABLE security_schema.users
(
    id              bigserial   NOT NULL,
    active          bool NULL,
    email           varchar(60) NULL,
    secret_password varchar(70) NULL,
    first_name      varchar(70) NOT NULL,
    last_name       varchar(70) NOT NULL,
    access_token    varchar(255) NULL,

    CONSTRAINT users_pk PRIMARY KEY (id)
);

CREATE TABLE security_schema.roles
(
    id    bigserial NOT NULL,
    title varchar(255) NULL,
    CONSTRAINT roles_pk PRIMARY KEY (id)
);

CREATE TABLE security_schema.users_roles
(
    user_id bigserial NOT NULL,
    role_id bigserial NOT NULL,
    CONSTRAINT users_roles_pk PRIMARY KEY (user_id, role_id)
);

CREATE TABLE todo_core.tasks
(
    id    bigserial NOT NULL,
    title varchar(255) NOT NULL,
    do_date timestamp NOT NULL,
    done_status bool default false,
    user_id bigserial NOT NULL,
    CONSTRAINT tasks_pk PRIMARY KEY (id)
);
ALTER TABLE todo_core.tasks ADD CONSTRAINT tasks_users_fk FOREIGN KEY (user_id) REFERENCES security_schema.users(id)