* [General info](#general-info)
* [Technologies](#technologies)
* [Database Schema](#database)
* [Setup](#setup)
* [Application view](#application-view)
* [Description of the endpoints](#description-of-the-endpoints)

## General info
<details>
<summary>Click here to see general information about <b>Engineering-Thesis-REST-API</b>!</summary>
Engineering-Thesis-REST-API will be sharing a data to my Engineering Thesis android application on theme Learning children foreign  languages via inner simple games.
</details>

## Technologies
<ul>
<li>Java</li>
<li>Spring Boot</li>
<li>Spring Security</li>
<li>Swagger</li>
<li>Hibernate</li>
<li>Lombok</li>
<li>Junit</li>
<li>Mockito</li>
</ul>

## Database
<img src="https://user-images.githubusercontent.com/32364525/159165200-35c22e40-231b-43e0-9c97-430d735b1520.png">

## Setup
Clone the repo
```git clone https://github.com/R3venge1337/Engineering-Thesis-REST-API.git```

## Application view
<img src="https://user-images.githubusercontent.com/32364525/159160324-f0db4e2a-3871-4dcf-abd7-4f03a1a9399e.png" >

## Description of the endpoints
<p>For sorting using params
  page=1
  size=10
  sortField=name
  sortDirection=ASC
  adding them to endpoints fetching huge amount of data from database e.g
</p>

```
https://localhost:443/api/children?page=1&size=10&sortField=name&sortDirection=ASC
```

### Account
<details>
<summary> Account Filter Form </summary>
{
    "login": "",
    "email":"",
    "createdDate": "",
    "isActive": true,
    "role": "ROLE_ADMIN"
}
</details>


<details>
<summary>Create Account Form </summary>
  {
        "name": "revenge",
        "password": "zaq1@wsx",
        "email": "test3@test.com",
        "active": true,
        "role": {
            "name": "ROLE_TEACHER"
        }
}
</details>

<details>
<summary>Update Account Form </summary>
  {
    "name": "revenge",
    "password": "zaq1@wsx",
    "email":"test3@test.com",
    "active": true,
    "role": {
        "name":"ROLE_ADMIN"
    }
}
</details>

| Path                         | Method   | How it works?                                                                                                                 |
| ---------------------------- | -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /accounts                    | `GET`    | Fetch all accounts, able is filtering by `AccountFilterForm`, Pagination and sorting were also used                           |
| /accounts?expiredAge=XYZ     | `GET`    | Finds all accounts exceeding the age specified by the parameter  "ExpiredAge"                                                 |
| /accounts                    | `POST`   | Add account. Requires a body with data for the new element, using `CreateAccountForm`                                         |
| /accounts/uuid               | `PUT`    | Update account by  `uuid` and requires a body with data for updating element, using `UpdateAccountForm`                       |
| /accounts/uuid               | `DELETE` | Delete account by  `uuid`                                                                                                     |


### Role
<details>
<summary> Role Filter Form </summary>
{
    "name": ""
}
</details>

<details>
<summary>Create Role Form </summary>
{
    "name": "ROLE_ADMIN"
}
</details>

<details>
<summary>Update Role Form </summary>
  {
    "name": "ROLE_ADMIN"
  }
</details>

| Path                         | Method   | How it works?                                                                                                                 |
| ---------------------------- | -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /roles                       | `GET`    | Fetch all roles, able is filtering by `RoleFilterForm` Pagination and sorting were also used                                  |
| /roles/uuid                  | `GET`    | Find role by `uuid`                                                                                                           |
| /roles                       | `POST`   | Add role. Requires a body with data for the new element, using `CreateRoleForm`                                               |
| /roles/uuid                  | `PUT`    | Update role by  `uuid` and requires a body with data for updating element, using `UpdateRoleForm`                             |
| /roles/uuid                  | `DELETE` | Delete role by  `uuid`                                                                                                        |

### Teacher
<details>
<summary>Create Teacher Form </summary>
{
    "name": "Adam",
    "surname": "Kowalski",
    "profession": "English teacher",
    "city": "Warsaw",
    "yearOfBirth": 2000,
    "account": {
        "name": "testujem2",
        "password": "zaq1WSX@",
        "email": "testing@test.com",
        "active": true,
        "role": {
            "name": "ROLE_TEACHER"
        }
    },
    "language": {
        "name": "English"
    }
}
</details>

<details>
<summary>Update Teacher Form </summary>
  {
    "name": "Marek",
    "surname": "Kowalski",
    "profession": "Angielski",
    "city": "Poznań",
    "yearOfBirth": 2000,
    "account": {
        "name": "marek23",
        "password": "zaq1@WSX",
        "email": "test@test.com",
        "active": true,
        "role": {
            "name": "ROLE_TEACHER"
        }
    },
    "language": {
        "name": "English"
    }
}
</details>

| Path                         | Method   | How it works?                                                                                                                 |
| ---------------------------- | -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /teachers                    | `GET`    | Fetch all teachers, able is filtering by `FilterForm` Pagination and Sorting were also used                                   |
| /teachers?languageName=XYZ   | `GET`    | Find all teachers who are learning specific language by param `languageName`                                                  |
| /teachers/uuid               | `GET`    | Find teacher by `uuid`                                                                                                        |
| /teachers/uuid/accounts      | `GET`    | Find teacher by `uuid` and additional account information assigned to him                                                     |
| /teachers                    | `POST`   | Add teacher. Requires a body with data for the new element, using `CreateTeacherForm`                                         |
| /teachers/uuid               | `PUT`    | Update teacher by  `uuid` and requires a body with data for updating element, using `UpdateTeacherForm`                       |
| /teachers/uuid               | `DELETE` | Delete teacher by  `uuid`                                                                                                     |


### Children
<details>
<summary> Child Filter Form </summary>
{
    "name": "",
    "surname": "",
    "city": "",
    "yearOfBirth": 2000
}
</details>
<details>
<summary>Create Child Form </summary>
{
    "name": "Adam",
    "surname": "Zimny",
    "city": "Warszawa",
    "yearOfBirth": 2000,
    "account": {
        "name": "testujem2",
        "password": "zima27123!",
        "email": "testing@test.com",
        "active": true,
        "role": {
            "name": "ROLE_CHILD"
        }
    }
}
</details>

<details>
<summary>Update Child Form </summary>
  {
    "name": "Adam",
    "surname": "Zimny",
    "city": "Warszawa",
    "yearOfBirth": 2000,
    "account": {
        "name": "testujem2",
        "password": "zima27123!",
        "email": "testing@test.com",
        "active": true,
        "role": {
            "name": "ROLE_CHILD"
        }
    }
}
</details>

| Path                         | Method   | How it works?                                                                                                                 |
| ---------------------------- | -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /children                    | `GET`    | Fetch all children, able is filtering by `ChildFilterForm`, Pagination and Sorting were also used                             |
| /children/uuid               | `GET`    | Find child by `uuid`                                                                                                          |
| /children/uuid/accounts      | `GET`    | Find child by `uuid` and additional account information assigned to him                                                       |
| /children                    | `POST`   | Add child. Requires a body with data for the new element, using `CreateChildForm`                                             |
| /children/uuid               | `PUT`    | Update child by  `uuid` and requires a body with data for updating element, using `UpdateChildForm`                           |
| /children/uuid               | `DELETE` | Delete child by  `uuid`                                                                                                       |


### Categories
<details>
<summary> Category Filter Form </summary>
{
    "language": "",
    "createdDate": ""
}
</details>

<details>
<summary>Create Category Form </summary>
  {
    "name": ""
  }
</details>

<details>
<summary>Update Category Form </summary>
  {
    "name": ""
  }
</details>

| Path                         | Method   | How it works?                                                                                                                 |
| ---------------------------- | -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /categories                  | `GET`    | Fetch all categories, able is filtering by `CategoryFilterForm`, Pagination and Sorting were also used                        |
| /categories/uuid             | `GET`    | Find category by `uuid`                                                                                                       |
| /categories/teachers/uuid    | `GET`    | Find all categories assigned to teacher by his `uuid`                                                                         |
| /categories/teachers/uuid    | `POST`   | Assign categories to teacher by his `uuid`                                                                                    |
| /categories                  | `POST`   | Add category. Requires a body with data for the new element, using `CreateCategoryForm`                                       |
| /categories/uuid             | `PUT`    | Update category by  `uuid` and requires a body with data for updating element, using `UpdateCategoryForm`                     |
| /categories/uuid             | `DELETE` | Delete category by  `uuid`                                                                                                    |


### Languages
<details>
<summary> Language Filter Form </summary>
  {
    "name": ""
  }
</details>

<details>
<summary>Create Language Form </summary>
  {
    "name": "English"
 }
</details>

<details>
<summary>Update Language Form </summary>
  {
    "name": "English"
  }
</details>

| Path                         | Method   | How it works?                                                                                                                 |
| ---------------------------- | -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /languages                   | `GET`    | Fetch all languages, able is filtering by `LanguageFilterForm`, Pagination and Sorting were also used                         |
| /languages/uuid              | `GET`    | Find language by `uuid`                                                                                                       |
| /languages                   | `POST`   | Add language. Requires a body with data for the new element, using `CreateLanguageForm`                                       |
| /languages/uuid              | `PUT`    | Update language by  `uuid` and requires a body with data for updating element, using `UpdateLanguageForm`                     |
| /languages/uuid              | `DELETE` | Delete language by  `uuid`                                                                                                    |


### Words
<details>
<summary> Word Filter Form </summary>
  {
    "name": "",
    "category": "",
    "language": ""
}
</details>

<details>
<summary>Create Word Form </summary>
  {
    "name": "",
    "downloadUri": ""
}
</details>

<details>
<summary>Update Word Form </summary>
  {
    "name": "",
    "downloadUri": ""
  }
</details>

| Path                               | Method   | How it works?                                                                                                                 |
| -----------------------------------| -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /words                             | `GET`    | Fetch all words, able is filtering by `WordFilterForm`, Pagination and Sorting were also used                                 |
| /words/categories?categoryName=XYZ | `GET`    | Find all words assigned to specific category `categoryName=XYZ`                                                               |
| /words                             | `POST`   | Add word. Requires a body with data for the new element, using `CreateWordForm`                                               |
| /words/uuid                        | `PUT`    | Update word by  `uuid` and requires a body with data for updating element, using `UpdateWordeForm`                            |
| /words/uuid                        | `DELETE` | Delete word by  `uuid`                                                                                                        |

### Audios
<details>
<summary> Audio Filter Form </summary>
{
    "filename":""
}
</details>

<details>
<summary>Update Audio Form </summary>

  {
    "downloadUri": ""
  }

</details>

| Path                               | Method   | How it works?                                                                                                                 |
| -----------------------------------| -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /audios                            | `GET`    | Fetch all audios, able is filtering by `AudioFilterForm`, Pagination and Sorting were also used                               |
| /audios/downloadFile/{fileName:.+} | `GET`    | Able to download file by filename passed in path                                                                              |
| /audios/uuid                       | `GET`    | Find audio file by `uuid`                                                                                                     |
| /audios?file                       | `POST`   | Add audio file. Requires a body with data for the new element, using MultipartFile as param                                   |
| /audios/uuid                       | `PUT`    | Update audio by  `uuid` and requires a body with data for updating element, using `UpdateWordeForm`                           |
| /audios/uuid                       | `DELETE` | Delete audio by  `uuid`                                                                                                       |


### Images
<details>
<summary> Image Filter Form </summary>
 
{
    "filename":""
}

</details>

<details>
<summary>Update Image Form </summary>

  {
    "downloadUri": ""
  }

</details>

| Path                               | Method   | How it works?                                                                                                                 |
| -----------------------------------| -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /images                            | `GET`    | Fetch all images, able is filtering by `ImageFilterForm`, Pagination and Sorting were also used                               |
| /images/downloadFile/{fileName:.+} | `GET`    | Able to download file by filename passed in path                                                                              |
| /images/uuid                       | `GET`    | Find image file by `uuid`                                                                                                     |
| /images?file                       | `POST`   | Add image file. Requires a body with data for the new element, using MultipartFile as param                                   |
| /images/uuid                       | `PUT`    | Update image by  `uuid` and requires a body with data for updating element, using `UpdateWordeForm`                           |
| /images/uuid                       | `DELETE` | Delete image by  `uuid`                                                                                                       |


### Games
<details>
<summary> Game Filter Form </summary>
{
    "name": ""
}

</details>

<details>
<summary>Create Game Form </summary>
 {
    "name": ""
}

</details>

<details>
<summary>Update Game Form </summary>
  {
    "name": ""
}
</details>

| Path                               | Method   | How it works?                                                                                                                 |
| -----------------------------------| -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /games                             | `GET`    | Fetch all games, able is filtering by `GameFilterForm`, Pagination and Sorting were also used                                 |
| /games/uuid                        | `GET`    | Find game by `uuid`                                                                                                           |
| /games                             | `POST`   | Add game. Requires a body with data for the new element, using `CreateGameForm`                                               |  
| /games/uuid                        | `PUT`    | Update game by  `uuid` and requires a body with data for updating element, using `UpdateGameForm`                             |
| /games/uuid                        | `DELETE` | Delete game by  `uuid`                                                                                                        |

### Gameplay
<details>
<summary> Gameplay Filter Form </summary>
{
    "name": ""
}
</details>

<details>
<summary>Create Gameplay Form </summary>
 {
    "name": ""
}
</details>

<details>
<summary>Update Gameplay Form </summary>
  {
    "name": ""
}
</details>

| Path                               | Method   | How it works?                                                                                                                 |
| -----------------------------------| -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /matches                           | `GET`    | Fetch all matches, able is filtering by `GameplayFilterForm`, Pagination and Sorting were also used                           |
| /matches/uuid                      | `GET`    | Find match by `uuid`                                                                                                          |
| /matches                           | `POST`   | Add match. Requires a body with data for the new element, using `CreateGameplayForm`                                          |  
| /matches/uuid                      | `PUT`    | Update match by  `uuid` and requires a body with data for updating element, using `UpdateGameplayForm`                        |
| /matches/uuid                      | `DELETE` | Delete match by  `uuid`                                                                                                       |

### Statistics Type
<details>
<summary> Statistic Filter Form </summary>
{
    "name": ""
}
</details>

<details>
<summary>Create Statistic Form </summary>
 {
    "name": ""
}
</details>

<details>
<summary>Update Statistic Form </summary>
  {
    "name": ""
}
</details>

| Path                               | Method   | How it works?                                                                                                                 |
| -----------------------------------| -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /statistics                        | `GET`    | Fetch all statistics, able is filtering by `StatisticFilterForm`, Pagination and Sorting were also used                       |
| /statistics/uuid                   | `GET`    | Find statistic by `uuid`                                                                                                      |
| /statistics                        | `POST`   | Add statistic. Requires a body with data for the new element, using `CreateStatisticForm`                                     |  
| /statistics/uuid                   | `PUT`    | Update statistic by  `uuid` and requires a body with data for updating element, using `UpdateStatisticForm`                   |
| /statistics/uuid                   | `DELETE` | Delete statistic by  `uuid`                                                                                                   |

### Statistics Result
<details>
<summary> Statistic Result Filter Form </summary>
{
    "type":""
}
</details>

<details>
<summary>Create Statistic Result Form </summary>
 {
    "result": "",
    "type":""
}
</details>

<details>
<summary>Update Statistic Result Form </summary>
  {
    "result": "",
    "type":""
}
</details>

| Path                               | Method   | How it works?                                                                                                                 |
| -----------------------------------| -------- | ----------------------------------------------------------------------------------------------------------------------------- |
| /statistics/statisticResults       | `GET`    | Fetch all statistics results, able is filtering by `StatisticResultFilterForm`, Pagination and Sorting were also used         |
| /statistics/statisticResults/uuid  | `GET`    | Find statistic result by `uuid`                                                                                               |
| /statistics/statisticResults       | `POST`   | Add statistic result. Requires a body with data for the new element, using `CreateStatisticResultForm`                        |  
| /statistics/statisticResults/uuid  | `PUT`    | Update statistic result by  `uuid` and requires a body with data for updating element, using `UpdateStatisticResultForm`      |
| /statistics/statisticResults/uuid  | `DELETE` | Delete statistic result by  `uuid`                                                                                            |

