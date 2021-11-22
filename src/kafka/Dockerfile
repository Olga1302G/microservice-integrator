FROM daocloud.io/library/tomcat:7.0.77-jre8

# Определить рабочий каталог
ENV WORK_PATH /usr/local/work

# Определить имя папки kafka
ENV KAFKA_PACKAGE_NAME kafka_2.9.2-0.8.1

# Создать рабочий каталог
RUN mkdir -p $WORK_PATH

# Скопируйте оболочку, которая запустила сервер в рабочий каталог
COPY ./start_server.sh $WORK_PATH/

# Копировать кафки сжатых файлов в рабочий каталог
COPY ./$KAFKA_PACKAGE_NAME.tgz $WORK_PATH/

# Распаковать
RUN tar -xvf $WORK_PATH/$KAFKA_PACKAGE_NAME.tgz -C $WORK_PATH/

# Удалить сжатые файлы
RUN rm $WORK_PATH/$KAFKA_PACKAGE_NAME.tgz

# Выполните команду sed, чтобы изменить файл и изменить IP-адрес соединения zk на псевдоним контейнера zookeeper, соответствующий параметру link
RUN sed -i 's/zookeeper.connect=localhost:2181/zookeeper.connect=zkhost:2181/g' $WORK_PATH/$KAFKA_PACKAGE_NAME/config/server.properties

# Предоставить разрешения на выполнение для оболочки
RUN chmod a+x $WORK_PATH/start_server.sh

#запуск сборки - docker build -t bolingcavalry/kafka:0.0.1 .