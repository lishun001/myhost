java -jar start01.jar --spring.profiles.active=prod  > log01.file 2>&1 &  /r/n
java -jar start02.jar --spring.profiles.active=prod  > log02.file 2>&1 &  /r/n
java -jar start03.jar --spring.profiles.active=prod  > log03.file 2>&1 &  /r/n
java -jar start04.jar --spring.profiles.active=prod  > log04.file 2>&1 &  /r/n
java -jar start05.jar --spring.profiles.active=prod --server.port=8762 > log05.file 2>&1 &  /r/n
java -jar start06.jar --spring.profiles.active=prod --server.port=8766 > log06.file 2>&1 &  /r/n
java -jar start07.jar --spring.profiles.active=prod --server.port=8764 > log07.file 2>&1 &  /r/n
echo ZB-API start OK!
