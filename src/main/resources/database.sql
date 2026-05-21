BEGIN TRANSACTION;
DROP TABLE IF EXISTS "商品";
CREATE TABLE 商品 (
    No INTEGER NOT NULL UNIQUE,
    商品コード TEXT NOT NULL UNIQUE,
    品名 TEXT NOT NULL,
    数量 INTEGER NOT NULL
);

INSERT INTO 商品 VALUES (1,'A100','高品質USB-Cケーブル 1m',30);
INSERT INTO 商品 VALUES (2,'B120','ワイヤレスマウス 静音タイプ',20);
INSERT INTO 商品 VALUES (3,'C200','Bluetoothスピーカー 防水仕様',25);
INSERT INTO 商品 VALUES (4,'D300','27インチ4Kモニター',35);
INSERT INTO 商品 VALUES (5,'E400','ノートパソコンスタンド アルミ製',40);
INSERT INTO 商品 VALUES (6,'F500','ゲーミングキーボード RGBライト',45);
INSERT INTO 商品 VALUES (7,'G600','500GB ポータブルSSD',50);
INSERT INTO 商品 VALUES (8,'H700','スマートウォッチ 心拍数計測',28);
INSERT INTO 商品 VALUES (9,'I800','ノイズキャンセリングヘッドホン',32);
INSERT INTO 商品 VALUES (10,'J900','モバイルバッテリー 20000mAh',60);

INSERT INTO 商品 VALUES (11,'K110','USB急速充電アダプタ 30W',22);
INSERT INTO 商品 VALUES (12,'L120','折りたたみ式Bluetoothキーボード',18);
INSERT INTO 商品 VALUES (13,'M130','ワイヤレスイヤホン 低遅延モデル',27);
INSERT INTO 商品 VALUES (14,'N140','LEDデスクライト 調光機能付き',33);
INSERT INTO 商品 VALUES (15,'O150','スマホ車載ホルダー マグネット式',40);
INSERT INTO 商品 VALUES (16,'P160','HDMIケーブル 2m 高耐久',55);
INSERT INTO 商品 VALUES (17,'Q170','USBハブ 4ポート 3.0対応',38);
INSERT INTO 商品 VALUES (18,'R180','ノートPC用冷却パッド 静音ファン',29);
INSERT INTO 商品 VALUES (19,'S190','ゲーミングマウス 6ボタン',31);
INSERT INTO 商品 VALUES (20,'T200','メカニカルキーボード 青軸',26);
INSERT INTO 商品 VALUES (21,'U210','スマート体重計 Bluetooth連携',24);
INSERT INTO 商品 VALUES (22,'V220','アクションカメラ 4K録画対応',19);
INSERT INTO 商品 VALUES (23,'W230','USBメモリ 128GB 高速モデル',45);
INSERT INTO 商品 VALUES (24,'X240','Wi-Fiルーター デュアルバンド',34);
INSERT INTO 商品 VALUES (25,'Y250','タブレットスタンド 角度調整式',37);
INSERT INTO 商品 VALUES (26,'Z260','モニターアーム ガススプリング式',21);
INSERT INTO 商品 VALUES (27,'AA270','スマホ三脚 Bluetoothリモコン付き',28);
INSERT INTO 商品 VALUES (28,'AB280','外付けDVDドライブ USB-C対応',23);
INSERT INTO 商品 VALUES (29,'AC290','電動エアダスター USB充電式',32);
INSERT INTO 商品 VALUES (30,'AD300','ノートPCバッグ 15インチ対応',36);


COMMIT;

