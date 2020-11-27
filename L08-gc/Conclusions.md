# GC1 vs Serial GC

первое приложение запускалось с параметрами
java -Xms1024m^
 -Xmx1024m^
 -XX:+UseG1GC^
 -Xlog:gc=debug:file=C:\temp\gc-%p-%t.log:tags,uptime,time,level:filecount=5,filesize=10m^
 -XX:MaxGCPauseMillis=100^

второе 
java -Xms1024m^
 -Xmx1024m^
 -XX:+UseSerialGC^
 -Xlog:gc=debug:file=C:\temp\gc-%p-%t.log:tags,uptime,time,level:filecount=5,filesize=10m^
 -XX:MaxGCPauseMillis=100^


## Картинки
в результате visual vm
для G1
[!image gc1](file://C:\work\java\otus_java_2020_09\L08-gc\gc-gc1.png)

для Serial
[!image serial](file://C:\work\java\otus_java_2020_09\L08-gc\gc-serial.png)

## Статистика работы GC

|                        |  G1 GC       |  Serial GC |
|------------------------|--------------|------------|
| Общее время работы, ms | 19444        | 26655      |


dsfdsf