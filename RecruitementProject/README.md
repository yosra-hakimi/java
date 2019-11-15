# RH Fiche Candidat Byblos

## Installation

Step 1. Clone the project from the link below: [link](https://gitlab.com/mmakni/talanrecruitment) <br/>

Step 2. Open Eclipse go to the menu File  --> Import -->  Existing Maven Project  load the project and Click "Finish" <br/>

Step 3. Right click on the project --> Run As --> Maven install and the Build should be success <br/>

Step 4. Open pgAdmin create a new dataase with the same name specified in application.properties <br/>

Step 5. Run the project As Spring Boot application and the database will be created automatically <br/>

Step 6. In pgAdmin select the database, Right click on Query Tools and Execute the SQL script for database initiation <br/>

## Usage 
### REST API

Before testing any API you must login with an email and a password :

HTTP METHOD	     | URI | Action | Input | Ouput
| -------------- | ----| ------ | ----- |-----|
| POST | http://localhost:8080/login  |login|{username=email, password=Talan123}|Headers:Authorization: Bearer JWT|


#### Description of "REST API User" :

 
HTTP METHOD	     | URI | Action | Input | Ouput
| -------------- | ----| ------ | ----- |-----|
| GET | http://localhost:8080/users | gett all users | ---- | list of users|
| GET | http://localhost:8080/users/{mail} | get user by mail | mail | profile|
| POST | http://localhost:8080/users  |create user |user|user created successfully|
| POST | http://localhost:8080/users/user |update one user |user |user is updated successfully|
| DELETE | http://localhost:8080/users/{mail}|delete user by mail |mail user|user is deleted|
#### Create User
```json
{
    # here json for create User
}
```
#### Update Update User
```json
{
    # here json for update User
} 
```

#### Description of " REST API Profile" :

HTTP METHOD	     | URI | Action | Input | Ouput
| -------------- | ----| ------ | ----- |-----|
| GET | http://localhost:8080/profiles | get all profiles | ---- | list of profiles|
| GET | http://localhost:8080/profiles/{name} | get profile by name | name | profile|
| POST | http://localhost:8080/profiles  |create profile |profile|profile created successfully|
| POST | http://localhost:8080/profiles/profile |update one profile |profile |profile is updated successfully|
| DELETE | http://localhost:8080/profiles/{name}|delete profile by name|Id profile|profile is deleted|

#### Create Profile
```json
{
    # here json for create profile
}
```
#### Update Profile
```json
{
    # here json for update profile
} 
```

#### Description of "REST API Role" :

HTTP METHOD	     | URI | Action | Input | Ouput
| -------------- | ----| ------ | ----- |-----|
| GET | http://localhost:8080/roles | gett all roles | ---- | list of roles|
| GET | http://localhost:8080/roles/{name} | get role by name | name | role|
| POST | http://localhost:8080/roles  |create role |role|role created successfully|
| POST | http://localhost:8080/roles/role |update one role |role |role is updated successfully|
| DELETE | http://localhost:8080/roles/{name}|delete role|Id role|role is deleted|

#### Create Role
```json
{
    # here json for create role
}
```
#### Update Role
```json
{
    # here json for update role
} 
```


### Description of "REST API Interview"

HTTP METHOD	     | URI | Action | Input | Ouput
| -------------- | ----| ------ | ----- |-----|
| GET | http://localhost:8080/applications/interviews/{mail} | get interviews by candidate Email | ---- | list of interview| 
| GET | http://localhost:8080/interviews | get all interviews | ---- | list of Interview |

HTTP METHOD	     | URI | Action | Input | Ouput
| -------------- | ----| ------ | ----- |-----|
| GET | http://localhost:8080/applications/{mail}/interviews | get interviews by candidate Email | ---- | list of interview| 
| GET | http://localhost:8080/interviews | get all interviews | ---- | list of Interview |

#### Description of "REST API" Candidate :


|HTTP METHOD| URI | Action | Input | Ouput |
|-----------| ----| ------ | ----- |------ |
| GET | http://localhost:8080/candidates/{mail} | Get Candidate By Mail | Mail | Candidate |   
| POST | http://localhost:8080/candidates | Create Candidate | [Candidate](#createCandidate) | Candidate | 
| POST | http://localhost:8080/candidates/update | Update Candidate | [Candidate](#createCandidate) | Candidate |


### createCandidate
```json
{
        "statut": "a recevoir",
        "civility": "Monsieur",
        "firstName": "Abdellaziz",
        "lastName": "hammami",
        "phoneNumber": "48587878",
        "mail": "aziz.hammami@yahoo.com",
        "nationality": "tounsi",
        "dateOfBithday": "1969-12-31T23:00:00.000+0000",
        "typeIdentityPiece": "passport",
        "expirationIdentityPiece": "2049-12-31T23:00:00.000+0000",
        "numIdentityPiece": "54zfezf",
        "dateFirstExperience": "2009-12-31T23:00:00.000+0000",
        "entreprise": "SOGIP",
        "application": {
            "id": 2,
            "manager": {
                "id": 3,
                "mail": "ons.mahsni@yahoo.com",
                "password": "$2a$10$oyVZYuJcQWxDMcQnIFgFqOFdPhOpMteVK8sZ3eNbVgvv.1Nxhl6fy",
                "firstName": "ons",
                "lastName": "mahsni",
                "phoneNumber": "4545454",
                "nationality": "tunisienne",
                "dateOfBithday": "2000-12-31T23:00:00.000+0000",
                "profile": {
                    "id": 2,
                    "profileName": "backOfficeManager",
                    "role": {
                        "id": 2,
                        "roleName": "MANAGER_BO"
                    }
                }
            },
            "source": "cooptant",
            "cooptedBy": {
                "id": 2,
                "mail": "ahmed.riahi@yahoo.com",
                "password": "$2a$10$oyVZYuJcQWxDMcQnIFgFqOFdPhOpMteVK8sZ3eNbVgvv.1Nxhl6fy",
                "firstName": "ahmed",
                "lastName": "riahi",
                "phoneNumber": "4545454",
                "nationality": "tunisienne",
                "dateOfBithday": "2000-12-31T23:00:00.000+0000",
                "profile": {
                    "id": 3,
                    "profileName": "manager",
                    "role": {
                        "id": 3,
                        "roleName": "MANAGER"
                    }
                }
            },
            "applicationDate": "2017-12-31T23:00:00.000+0000",
            "disponibilityDate": "2019-06-19T22:00:00.000+0000",
            "geographicalWish": "france",
            "searchedPosition": "ingénieur Java",
            "interview": [
                {
                    "interviewDate": "2019-07-01",
                    "interviewType": "Technique",
                    "businessUnit": "PHP",
                    "jobOffer": "none",
                    "opinion": "good",
                    "comment": "bon",
                    "nextStep": "null",
                    "statut": "validé",
                    "currentRemuneration": 1300,
                    "desiredRemuneration": 2000,
                    "interviewWith": {
                        "id": 1,
                        "mail": "mouna.makni@yahoo.com",
                        "password": "$2a$10$oyVZYuJcQWxDMcQnIFgFqOFdPhOpMteVK8sZ3eNbVgvv.1Nxhl6fy",
                        "firstName": "mouna",
                        "lastName": "makni",
                        "phoneNumber": "4545454",
                        "nationality": "tunisienne",
                        "dateOfBithday": "2000-12-31T23:00:00.000+0000",
                        "profile": {
                            "id": 3,
                            "profileName": "manager",
                            "role": {
                                "id": 3,
                                "roleName": "MANAGER"
                            }
                        }
                    },
                    "date": "2019-07-20"
                }
            ],
            "document": []
        },
        "diploma": {
            "id": 2,
            "formation": "BacPlus5",
            "actuelPost": "actuel post",
            "university": {
                "id": 2,
                "universityName": "ENIT"
            }
        }
    }
```    
#### Update Candidate
```json
{
    # here json for update candidate
} 
```
### Description of "REST API UploadFiles" :

HTTP METHOD	     | URI | Action | Input | Ouput
| -------------- | ----| ------ | ----- |-----|
| POST | http://localhost:8080/uploadMultipleFiles|create files|files|list of files|
| POST | http://localhost:8080/uploadMultipleDocs|create documents|docs|list of documents|
| GET| http://localhost:8080/downloadDocument/{documentId}|get documents|docs|list of documents|
| GET| http://localhost:8080/downloadFile/{fileId}|get cv|cv|cv|

#### upload File
```json
{
    # here json for upload file
} 
```


## Routes