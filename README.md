BankingApp

BankingApp is used to register customer accounts and perform transaction. 

Installation

Use Maven to build the application

mvn clean install

Upon successfully packaging the app, Use the command to start the application

mvn spring-boot:run

Endpint used to determine whether the service is Up or Not

a)	Register a Customer with a BankAccount

Method: POST

http://localhost:8080/bankApp/customer/

Input Json:

{
   "cif":"C100001",
   "name":"Irfan",
   "dateOfBirth":"1990-01-20",
   "onboardingDate":"2020-06-19",
   "phoneNumber":"01128662653",
   "bankAccounts":[
      {
      	"accountNumber":"A200001",
         "openingDate":"2020-06-20",
         "balance":1000,
         "status":1
      },
      {
      	"accountNumber":"A200002",
         "openingDate":"2020-06-20",
         "balance":5000,
         "status":1
      }
   ]
}

b)	Query all BankAccounts of a Customer with a particular openingDate

http://localhost:8080/bankApp/account?cif=C100001&openingDate=2020-06-19

Output:
[
    {
        "accountNumber": "A200002",
        "openingDate": "2020-06-19",
        "balance": 5000.00,
        "status": 1
    },
    {
        "accountNumber": "A200001",
        "openingDate": "2020-06-19",
        "balance": 1000.00,
        "status": 1
    }
]

c)	Query all Customers opening a BankAccount on a particular openingDate

http://localhost:8080/bankApp/customer/?openingDate=2020-06-20

Output:

[
    {
        "cif": "C100001",
        "name": "Irfan",
        "dateOfBirth": "1990-01-20",
        "onboardingDate": "2020-06-19",
        "phoneNumber": "01128662653",
        "bankAccounts": [
            {
                "accountNumber": "A200001",
                "openingDate": "2020-06-19",
                "balance": 1000.00,
                "status": 1
            },
            {
                "accountNumber": "A200002",
                "openingDate": "2020-06-19",
                "balance": 5000.00,
                "status": 1
            }
        ]
    }
]

d)	Create a Transaction

Method: POST

http://localhost:8080/bankApp/transaction

Input Json:
{
   "amount":5000,
   "time":"2020-06-20T12:25:43.511Z",
   "status":1,
   "currency":"MYR",
   "bankAccount":{
      "accountNumber":"A200001"
   }
}

e)	Query all Transactions of a particular Customer
http://localhost:8080/bankApp/transaction?cif=C100001

Output Json:
[
    {
        "tranId": 1,
        "amount": 5000.00,
        "time": "2020-06-20T12:25:43.511+00:00",
        "status": 1,
        "currency": "MYR",
        "bankAccount": {
            "accountNumber": "A200001",
            "openingDate": "2020-06-19",
            "balance": 1000.00,
            "status": 1
        }
    }
]




