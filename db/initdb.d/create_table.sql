create table account (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    updated_at datetime(6) not null,
    account_number varchar(255),
    account_status enum ('ACTIVE','PAUSE'),
    amount bigint not null,
    bank_code varchar(255),
    bank_name varchar(255),
    user_id varchar(255),
    primary key (id)
) engine=InnoDB;

create table commission_rate (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    updated_at datetime(6) not null,
    rate float(53) not null,
    primary key (id)
) engine=InnoDB;

create table fc_pay (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    updated_at datetime(6) not null,
    amount bigint,
    user_id varchar(255),
    version integer not null,
    primary key (id)
) engine=InnoDB;

create table firm_banking_history (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    updated_at datetime(6) not null,
    amount bigint not null,
    firm_banking_type enum ('PAY_TO_ACCOUNT','PAY_CHARGING'),
    receiver varchar(255),
    result bit not null,
    sender varchar(255),
    primary key (id)
) engine=InnoDB;

create table franchisee (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    updated_at datetime(6) not null,
    address varchar(255),
    name varchar(255),
    phone_number varchar(255),
    commission_rate_id bigint,
    primary key (id)
) engine=InnoDB;

create table payment (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    updated_at datetime(6) not null,
    amount bigint not null,
    franchisee_id bigint not null,
    payment_status enum ('PAYMENT_REQUESTED','PAYMENT_COMPLETED','PAYMENT_FAIL'),
    user_id varchar(255),
    primary key (id)
) engine=InnoDB;

create table slip (
    id bigint not null auto_increment,
    created_at datetime(6) not null,
    updated_at datetime(6) not null,
    amount bigint,
    franchisee_id bigint not null,
    user_id varchar(255),
    primary key (id)
) engine=InnoDB;

alter table franchisee drop index UK_hine0vrgr6h1fnjw7l6cdhj5j;

alter table franchisee add constraint UK_hine0vrgr6h1fnjw7l6cdhj5j unique (commission_rate_id);

alter table franchisee add constraint FK9leuho0lpmp0jvvkhm3r89qgf foreign key (commission_rate_id) references commission_rate (id);



INSERT INTO FC_PAY (id, user_id, amount, version, created_at, updated_at)
VALUES (1, 'jaewoo', '5000', 1, '2023-01-01 00:00:00', '2023-01-01 00:00:00');

INSERT INTO COMMISSION_RATE ( id, rate, created_at, updated_at)
VALUES (1, '0.1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');

INSERT INTO FRANCHISEE (name, address, phone_number, id, commission_rate_id ,created_at, updated_at)
VALUES ('A프랜차이즈', '서울시 강남구', '010-1234-5678', 1, 1, '2023-01-01 00:00:00', '2023-01-01 00:00:00');

INSERT INTO PAYMENT (payment_status, user_id, franchisee_id, amount, id, created_at, updated_at)
VALUES ('PAYMENT_REQUESTED', 'jaewoo', 1, '5000', 1, '2023-01-01 00:00:00', '2023-01-01 00:00:00');
