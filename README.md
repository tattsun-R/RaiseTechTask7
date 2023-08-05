#  概要
HTTPメソッドのGET/POST/PATCH/DELETEのリクエストを扱えるControllerを
実装しました。\
GETリクエストにおいて、クエリ文字列で生年月日も受け取れるようにしています。\

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
