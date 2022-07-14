# TODO LIST

A JAVA program to create and manage a personal Todo list.  
http://35.79.130.208:8080

## 功能:

- 將想做的事加入備忘錄清單
- 從下拉式選單選擇優先度
- 可以看到完成與否
- 依照使用者分類備忘錄
- 可將備忘錄項目標記為已完成
- 使用者可刪除自己的備忘錄
- 上傳圖片

## 基本架構

- 使用spring boot JPA建構以PostgreSql為資料庫之備忘錄API。
- 上傳至AWS服務之EC2執行個體，作為伺服器。
- 將database連結AWS服務之RDS資料庫。
- 在EC2內啟用Tmux使網站能長時間運行。
- 使用thymeleaf來連接前後端。
- 以AWS服務之S3 bucket為上傳圖片之儲存區。  

## 程式架構

todo及user兩個package分別處理兩個備忘錄及使用者之動作，views負責連結前後端資料。  

以PostgreSQL建立todo及users兩table。  
![image](https://github.com/ericmakuan/todo/blob/main/ERD.png)  

測試帳號名稱:Kuan Lun

## Demo
![image](https://github.com/ericmakuan/todo/blob/main/front.PNG)  
上方輸入使用者名稱及電子信箱來創建帳號，下方輸入使用者名稱來登入。  

![image](https://github.com/ericmakuan/todo/blob/main/11.PNG)  

登入後可添加備忘錄及其重要度，輸入要做的事及優先度後按下Add。  

![image](https://github.com/ericmakuan/todo/blob/main/111.PNG)  

點擊該備忘錄可標記為已完成，而點擊x按鈕則可將其刪除。  

另有建一swagger來測試api。  
http://35.79.130.208:8080/swagger-ui.html  
