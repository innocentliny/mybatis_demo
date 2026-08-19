# Mybatis-Plus 簡單範例

以前用過 mybatis，當時使用 XML 對應 mapper，非常喜歡可以自己掌握 SQL 指令與自訂 cache，
還可以判斷 DB provider 來執行資料庫特定的 SQL 語法，
這次藉由簡單範例，看看 MP 有什麼過人之處。

## The demo
* 不使用 XML 進行配置。
* 使用 mapper class 讀取資料。
* 使用 mp IRepository 讀取資料。(**官方建議方式**)