#  概要
HTTPメソッドのGET/POST/PATCH/DELETEのリクエストを扱えるControllerを
実装しました。\
GETリクエストにおいて、クエリ文字列で生年月日も受け取れるようにしています。
# 動作確認
## GETリクエスト
ステータスコード200を確認しました。\
```curl --location 'http://localhost:8080/profiles?name=yamada%20taro&birthdate=1988-09-21'```
![getresponse](https://github.com/tattsun-R/RaiseTechTask7/assets/138351540/86fdc06e-cd8a-410a-8b88-d53d0d6fce43)

## POSTリクエスト
ステータスコード201を確認しました。\
```curl --location --request PATCH 'http://localhost:8080/profiles/1' \
--header 'Content-Type: application/json' \
--data '{
"name": "Ichiro Matsumoto",
"birthDate":"2000-03-27"
}'
```
![postresponse](https://github.com/tattsun-R/RaiseTechTask7/assets/138351540/70937c79-0e7a-4eee-9f6d-97b1bc666654)
## PATCHリクエスト
ステータスコード200を確認しました。\
```
curl --location --request PATCH 'http://localhost:8080/profiles/1' \
--header 'Content-Type: application/json' \
--data '{
"name": "Ichiro Matsumoto",
"birthDate":"2000-03-27"
}'
```
![taskpatchresponse](https://github.com/tattsun-R/RaiseTechTask7/assets/138351540/6e6fa5c3-6306-4277-a4cf-6128a3783dbd)
## DELETEリクエスト
ステータスコード204を確認しました。
```curl --location --request DELETE 'http://localhost:8080/profiles/1'```
![taskdeleteresponse](https://github.com/tattsun-R/RaiseTechTask7/assets/138351540/98804a9d-64bf-4f44-b08b-b2837147ad20)


# 備考
## バリデーションについて
`@NotBlank`や`@Size`など使ってみたかったのですが、
`implementation 'org.springframework.boot:spring-boot-starter-validation'`
を記述してもうまく動かず断念しました。\

## 実装にあたって
生年月日をクエリ文字列で受け取れるようにした際に、一度String型で変数宣言しないとうまく動かず、
あとからLocalDate型に変換していることで、少し読みづらいような気がしています。\
また、以下の例のようにクエリ文字列が指定されていないにも関わらず、ダミーデータを返すのはどうなんだろうと思いましたが、
練習と思って割り切ってます。

例1\
```curl --location 'http://localhost:8080/profiles'``` \
例2\
```curl --location 'http://localhost:8080/profiles?name=&birthdate='``` \
\
レスポンス
```
[
    {
        "name": "Taro Inaba",
        "birthDate": "2004-09-23"
    },
    {
        "name": "Ichiro Matsumoto",
        "birthDate": "2000-03-27"
    }
]```
