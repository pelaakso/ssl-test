Jos haluat kääntää:

`javac -cp commons-io-2.4.jar CopyUrlToFile.java`

Voit downloadaa käännetyn version tästä:

```
curl -L -o CopyUrlToFile.class "https://github.com/pelaakso/ssl-test/blob/master/CopyUrlToFile.class?raw=true"
curl -L -o commons-io-2.4.jar "https://github.com/pelaakso/ssl-test/blob/master/commons-io-2.4.jar?raw=true"
```

Aja:

`java -cp commons-io-2.4.jar:. CopyUrlToFile https://... dump.xml`

Saat enemmän lokitusta antamalla `-Djavax.net.debug=taso`, missä taso on `all` tai `ssl`. Tasolla `all` tulee sitten kaikki verkkoliikenne, joten harkitse sen käyttämistä ison tiedoston yhteydessä.

`java -Djavax.net.debug=ssl -cp commons-io-2.4.jar:. CopyUrlToFile https://... dump.xml`

Tässä repossa oleva `CopyUrlToFile.class` käännetty Java7:lla.

