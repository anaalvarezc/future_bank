
CREATE SEQUENCE notification_seq;
CREATE TABLE notifications
(
    id_notification bigint DEFAULT NEXTVAL('notification_seq'),
	id_tx bigint,
    message character varying COLLATE pg_catalog."default",
    operation character varying COLLATE pg_catalog."default",
    CONSTRAINT notifications_pkey PRIMARY KEY (id_notification)
)



CREATE SEQUENCE transaction_seq;

CREATE TABLE tx_times
(
    end_date timestamp(4) without time zone,
    start_date timestamp(4) without time zone,
    id_transaction bigint DEFAULT NEXTVAL('transaction_seq'),
    operation character varying COLLATE pg_catalog."default",
    total_time bigint,
    notified boolean,
    CONSTRAINT transaction_pkey PRIMARY KEY (id_transaction)
)
