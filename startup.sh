java -jar start01.jar --spring.profiles.active=prod  > log01.file 2>&1 &  /r/n
java -jar start02.jar --spring.profiles.active=prod  > log02.file 2>&1 &  /r/n
java -jar start03.jar --spring.profiles.active=prod  > log03.file 2>&1 &  /r/n
java -jar start04.jar --spring.profiles.active=prod  > log04.file 2>&1 &  /r/n
echo ZB-API start OK!
