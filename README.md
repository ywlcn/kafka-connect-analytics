# kafka-connect-analytics



スレッド一覧

- `kafka-producer-network-thread |connector-producer-my-jdbc-connect-0`



- `task-thread-my-jdbc-connect-0`



- `SourceTaskOffsetCommitter-1`



　

``` java
KafkaProducer から　Sender　を作成して
　　KafkaThreadに詰め込んで、スレッド起動、メインの処理はSenderより実施　　　スレッドIdは：　kafka-producer-network-thread |connector-producer-my-jdbc-connect-0
　　　　ーーーー　Broker側の情報を常に監視する
　　　　　　　NetWork層の送信操作
　　
　　
　　
　　
KafkaProducer　の　　doSend　は　Recordをシリアライズして送信　　　＝＝＝　accumulator.append　　　RecordAccumulator.RecordAppendResultをGet
    public final static class RecordAppendResult {
        public final FutureRecordMetadata future;
        public final boolean batchIsFull;
        public final boolean newBatchCreated;
        public final boolean abortForNewBatch;
    }



RecordAccumulator
    ConcurrentMap<TopicPartition, Deque<ProducerBatch>> batches;
    
    
    

```







```
Task is being killed and will not recover until manually restarted
```



疑問

１．Task Kill 条件

２．Sender停止条件 Task

３．retry発生条件、

- retryはBrokerからレスポンス（handleProduceResponse()）があると発生する。

  - `kafka-producer-network-thread |connector-producer-my-jdbc-connect-0`より実施される

  - `kafka-producer-network-thread |connector-producer-my-jdbc-connect-0`はいつKill

    - ```
      KafkaProducerより　Close();　　正常Closeその後強制Close　　　ただし、呼び出すところ不明
      ```

  

```
        if (error == Errors.MESSAGE_TOO_LARGE && batch.recordCount > 1 && !batch.isDone() &&
                (batch.magic() >= RecordBatch.MAGIC_VALUE_V2 || batch.isCompressed())) {
        の場合に
```

