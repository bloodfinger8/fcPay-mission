
INSERT INTO FC_PAY (user_id, amount, id, created_at, updated_at)
VALUES ('jaewoo', '5000', 1, '2023-01-01 00:00:00', '2023-01-01 00:00:00');

INSERT INTO ACCOUNT (user_id, amount, bank_name, bank_code, account_number, account_status, id, created_at, updated_at)
VALUES ('jaewoo', '5000', '신한은행', '001', '110-123-456789', 'ACTIVE', 1, '2023-01-01 00:00:00', '2023-01-01 00:00:00');

INSERT INTO COMMISSION_RATE ( id, rate, created_at, updated_at)
VALUES (1, '0.1', '2023-01-01 00:00:00', '2023-01-01 00:00:00');
INSERT INTO FRANCHISEE (name, address, phone_number, id, commission_rate_id ,created_at, updated_at)
VALUES ('A프랜차이즈', '서울시 강남구', '010-1234-5678', 1, 1, '2023-01-01 00:00:00', '2023-01-01 00:00:00');

INSERT INTO PAYMENT (payment_status, user_id, franchisee_id, amount, id, created_at, updated_at)
VALUES ('PAYMENT_REQUESTED', 'jaewoo', 1, '5000', 1, '2023-01-01 00:00:00', '2023-01-01 00:00:00');

