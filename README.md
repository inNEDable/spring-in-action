Creating docket image for Casandra:

$ docker network create cassandra-net

...............................

Creating container

$ docker run --name my-cassandra --network cassandra-net -p 9042:9042 -d cassandra:latest

..................

Launching CQL shell for CQL commands:

docker run -it --network cassandra-net --rm cassandra cqlsh my-cassandra

.......................

QCL command for Creating keyspace for the Casandra DB:

create keyspace tacocloud with replication={'class':'SimpleStrategy', 'replication_factor':1} and durable_writes=true;

...............................

Select statement:
use tacocloud; --> to switch to our name space;

select id, name, createdAt, ingredients from tacos;