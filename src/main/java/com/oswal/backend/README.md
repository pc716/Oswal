# Backend Documentations

http://10.194.114.209:8080

## POST /transactions/start_transaction

send a request with the Bearer token in the header and a Payment json object [link](https://developer.paypal.com/docs/api/payments/#payment_create)

POST /transactions/finalize_transaction/{recipient}

send a request with the execute link and the payer_id

POST /login

send a request with a email and password key value pair {'email':email, 'password':password}

PUT /cash_check

send a request with email and amount {'email':email, 'amount':amount}

GET /get_balance/{email}

send a request for user balance

