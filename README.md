### Ktor URL Shortner

This project is a implementation for creating Short URL using Ktor + Kotlin + MongoDB

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

### Points
* By passing a valid URL we can create a short URL of 6 alpha-numerics.
* If validates the URL before creating the short URL
* If the provided URL is present in the Database, it will return back the initial Short URL created in place of creating a new one.
* When the GET short URL is called, we also update the hit count to that short URL.