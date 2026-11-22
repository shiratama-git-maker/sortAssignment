# ソート実装課題

## 開発環境
- OS: Windows
- Java: amazon-corretto jdk25.0.5_1
- 文字コード: ソースファイル／UTF-8、バッチファイル／Shift-JIS (CP932)

## フォルダ構成
```
sortAssignment
├─ compile.bat
├─ run.bat
├─ README.md
└─ sort
   ├─ bin
   │  ├─ Common.java
   │  ├─ MergeSort.java
   │  └─ QuickSort.java
   └─ src
       ├─ Common.class
       ├─ MergeSort.class
       └─ QuickSort.class
```

## バッチファイルの使い方
<dl>
  <dt>compile.bat</dt>
      <dd>srcフォルダ内のjavaソースをすべてコンパイル</dd>
  <dt>run.bat</dt>
      <dd>実行するソート、昇順／降順、ソート対象文字列の入力を求め、対象のソートをキック</dd>
</dl> 
