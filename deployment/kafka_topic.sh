docker run -it --rm bitnami/kafka:3.6 kafka-topics.sh --list --bootstrap-server 10.16.1.3:9095

docker run -it --rm bitnami/kafka:3.6 kafka-topics.sh --create --topic sample-topic --partitions 12 --replication-factor 3 --bootstrap-server 10.16.1.3:9095

docker run -it --rm bitnami/kafka:3.6 kafka-topics.sh --describe --topic sample-topic --bootstrap-server 10.16.1.3:9095