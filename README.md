# RHttpClient
動作確認はしてますがおかしいところがありそうな HttpClient です。

Maven にも置いてます。

# Usage
```Java
// 接続する URL のログを表示するかどうか (デフォルトは true)
RHttpClient.setShowLog(boolean);

// 表示するログに時間を表示するかどうか (デフォルトは true)
RHttpClient.setShowTime(boolean);

// UserAgent リクエストプロパティを設定 (デフォルトは "Mozilla/5.0")
RHttpClient.setUserAgent(userAgent);

// 文字エンコーディングの設定 (デフォルトは "UTF-8")
RHttpClient.setUserAgent(charset);

// 接続
RHttpClient.raw("https://api.simplyrin.net/hello.txt")
```

# Maven
- Repository
```XML
  <repositories>
    <repository>
      <id>net.simplyrin</id>
      <name>api</name>
      <url>https://api.simplyrin.net/maven/</url>
    </repository>
  </repositories>
```

- Dependency
```XML
  <dependencies>
    <dependency>
      <groupId>net.simplyrin.httpclient</groupId>
      <artifactId>RHttpClient</artifactId>
      <version>1.2-SNAPSHOT</version>
    </dependency>
  </dependencies>
```
`1.2-SNAPSHOT` で動作がおかしい場合は `1.1-SNAPSHOT` を使用してください。
