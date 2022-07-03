A JAVA program to create and manage a personal Todo list.

url:http://35.79.130.208:8080/todos

Models a task with:
task title
priority
completion status
sorted by user

Support the ability to:
add task
mark a task as done
delete tasks

使用spring boot建構以PSql為資料庫之備忘錄API，傳入AWS服務之EC2機器，連結RDS並以Tmux開啟長時間啟動之網站。
使用thymeleaf來連接前後端。

![](C:\Users\MA\Desktop\11.PNG)
登入後可添加備忘錄及其重要度，建立一該使用者之專屬備忘錄

![](C:\Users\MA\Desktop\111.PNG)
點擊該備忘錄選項可改變其狀態為done，點擊x按鈕可將其刪除。

todo及user兩個package分別管理兩個table之動作，views負責處理連結前端畫面之資料處理。
建一swagger之package來測試api。




