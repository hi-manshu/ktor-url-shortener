### Ktor URL Shortner

This project is a implementation for creating Short URL using Ktor + Kotlin + MongoDB

### Usage

It contains two routes if you want to implement it in Client side.

> POST - /v1/url
> 
```json

This takes the request,


{
    "url":"your_long_url"
}

```
> ```POST - /{url}```
>
```json

This will take the short URL as path param and will redirect you to the main original URL

```