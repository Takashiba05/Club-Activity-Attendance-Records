# Club Activity Attendance Records

部活動向けの出席管理システムです。

## 概要

部員の出席・欠席を日付ごとに管理できるWebアプリケーションです。

## 主な機能

- メンバー登録
- ログイン機能
- 出席登録
- 欠席登録
- 出欠データ削除
- 日付ごとの出席管理
- 出席状況の変更
- MariaDBへのデータ保存
- 出席履歴管理

## 使用技術

### フロントエンド

- HTML
- CSS
- JavaScript

### バックエンド

- Spring Boot
- Spring Data JPA

### データベース

- MariaDB
- HeidiSQL

## システム構成

HTML / CSS / JavaScript
            ↓
         Fetch API
            ↓
       Spring Boot
            ↓
     Spring Data JPA
            ↓
          MariaDB
```

## データベース設計

### attendance テーブル

| カラム名 | 説明 |
|----------|------|
| id | ID |
| activity_date | 活動日 |
| member_name | 部員名 |
| status | 出席状況 |

## 実装した機能

### 出席登録

選択した活動日に対して出席状態を登録できます。

### 欠席登録

選択した活動日に対して欠席状態を登録できます。

### 出欠更新

同じ活動日・同じ部員のデータは更新され、重複登録されません。

### 出欠削除

誤って登録した出欠データを削除できます。

### 日付別出席管理

活動日を選択すると、その日の参加者・欠席者のみ表示されます。

## 起動方法

### 1. データベース作成

```sql
CREATE DATABASE attendance_db;
```

### 2. application.properties の設定

```properties
spring.datasource.url=jdbc:mariadb://localhost:3306/attendance_db
spring.datasource.username=root
spring.datasource.password=root

spring.jpa.hibernate.ddl-auto=update
```

### 3. Spring Boot 起動

```bash
./mvnw spring-boot:run
```

### 4. ブラウザで利用

attendance.html を開いて利用します。

## 学習した内容

- Spring BootによるREST API開発
- MariaDBとの接続
- JPAによるCRUD処理
- Fetch APIによるフロントエンド・バックエンド連携
- データベース設計
- Git / GitHub

## 今後の改善案

- 出席率の表示
- 管理者機能
- パスワード認証
- 出席履歴一覧画面
- Excel出力機能

## 作成者

高柴 陽多