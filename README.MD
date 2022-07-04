# TODO LIST

A JAVA program to create and manage a personal Todo list.

## Demo

http://35.79.130.208:8080/todos

## 備忘錄選項:

- 要做的事
- 優先度
- 完成與否
- 使用者

## 備忘錄動作:

- 增加新備忘錄
- 標記已完成
- 刪除備忘錄

## 基本架構

使用spring boot建構以PSql為資料庫之備忘錄API，傳入AWS服務之EC2機器。  
將資料庫連結RDS並以Tmux開啟長時間啟動之網站。  
使用thymeleaf來連接前後端。

## 功能

![image](https://github.com/ericmakuan/todo/blob/main/11.PNG)

登入後可添加備忘錄及其重要度，輸入要做的事及優先度後按下Add。

![image](https://github.com/ericmakuan/todo/blob/main/111.PNG)

點擊該備忘錄可標記為已完成，而點擊x按鈕則可將其刪除。

## 程式架構

todo及user兩個package分別處理兩個備忘錄及使用者之動作，views負責連結前後端資料。  
另有建一swagger來測試api。

測試帳號名稱:Kuan Lun



