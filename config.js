var paypal = require('paypal-rest-sdk');

paypal.configure({
	'mode': 'sandbox', //sandbox or live
	'client_id': 'AUxbkPsELaJ3lZfpuO4QjbxPbXLbP5XErB3oDr4NuLZkSuqFkwpqhVJPiH0fsTIZzKr-t3T1kzpUCbtC',
	'client_secret': 'ELUEEDIlXssTUIpYpj_2SJ-kAfLZXliJs3Tul7OPOq2uXgQEm-Yp9vBEWj4s-7x_9kyH0KdOyTwxhQA4'
});