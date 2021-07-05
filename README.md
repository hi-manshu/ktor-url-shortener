### Ktor URL Shortner
[![Twitter](https://img.shields.io/badge/Follow-Twitter-1DA1F2.svg)](https://twitter.com/hi_man_shoe)

This project is a implementation for creating Short URL using Ktor + Kotlin + MongoDB

![alt text](https://github.com/hi-manshu/ktor-url-shortener/blob/main/art/arch-design-url-short.jpg)

### Usage

It contains two routes if you want to implement it in Client side.

> ```POST - /v1/url```
>

```json

This takes the request,


{
    "url":"your_long_url"
}

```

> ```GET - /{url}```
>

```json

This will take the short URL as path param and will redirect you to the main original URL

```
#### Frontend
It also has a frontend module built using `kotlin.html` and you can find it in `frontendRouting`
### Points

* By passing a valid URL we can create a short URL of 6 alpha-numerics.
* If validates the URL before creating the short URL
* If the provided URL is present in the Database, it will return back the initial Short URL created in place of creating
  a new one.
* When the GET short URL is called, we also update the hit count to that short URL.

### How to run the project?
* Clone the project. 
* Make sure MongoDB is installed.
* Start the MongoDB 
* Play around with the project.

### To read more about it
* [System Design: Build URL Shortening Service using Ktor (Part-1)](https://himanshoe.com/build-url-shortening-service-using-ktor-part-1)
* [System Design: Build URL Shortening Service using Ktor (Part-2)](https://himanshoe.com/build-url-shortening-service-using-ktor-part-2)
* [System Design: Build URL Shortening Service using Ktor (Part-3)](https://himanshoe.com/build-url-shortening-service-using-ktor-part-3)
* [System Design: Build URL Shortening Service using Ktor (Part-4)](https://himanshoe.com/building-url-shortening-service-frontend)
