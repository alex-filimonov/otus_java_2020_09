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
| Общее время работы GC, ms | 15262        | 26213     |
| Количество операций, вызова gc    |  60          |      26    |
| среднее время операций(вызова gc), ms | 264      |    1008    |
| Минимальное время (вызова gc), ms  | 16.27        |     0.077  | 
| Максимальное время(вызова gc), ms | 1350         |    1692  |

## Файлы логов

для G1
[Log for g1 gc](./gc-t.logs)

для Serial
[log for serial gc](./serial-t.logs)


## Вывод
В общем gc serial работает медленней но как видно из графиков visual vm менее агресивно для системы в целом. G1 в целом работает быстрее но при этом значительно использует CPU и RAM
Вывод был выполнено на основе анализа логов (вызовов GC приложенно выше), а также на основе графиков visualVM.
