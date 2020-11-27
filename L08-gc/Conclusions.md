# G1 vs Serial GC

первое приложение запускалось с параметрами
```
java -Xms1024m^
 -Xmx1024m^
 -XX:+UseG1GC^
 -Xlog:gc=debug:file=C:\temp\gc-%p-%t.log:tags,uptime,time,level:filecount=5,filesize=10m^
 -XX:MaxGCPauseMillis=100^
```
второе
``` 
java -Xms1024m^
 -Xmx1024m^
 -XX:+UseSerialGC^
 -Xlog:gc=debug:file=C:\temp\gc-%p-%t.log:tags,uptime,time,level:filecount=5,filesize=10m^
 -XX:MaxGCPauseMillis=100^
```

## Картинки
в результате visual vm
для G1
[!image gc1](./gc-gc1.png)

для Serial
[!image serial](./gc-serial.png)

## Статистика работы GC

|                        |  G1 GC       |  Serial GC |
|------------------------|--------------|------------|
| Общее время работы, ms | 15262        | 26213     |
| Количество операций    |  60          |      26    |
| среднее время операций, ms | 264      |    1008    |
| Минимальное время, ms  | 16.27        |     0.077  | 
| Максимальное время, ms | 1350         |    1692  |


## Вывод
В общем gc serial работает медленней но как видно из графиков visual vm менее агресивно для системы в целом. G1 в целом работает быстрее но при этом значительно использует CPU и RAM