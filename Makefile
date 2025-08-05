
run:
	docker run --name postgres -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres
	docker start postgres
	docker run -d --name redis -p 6379:6379 redis/redis-stack-server:latest
	mvn clean spring-boot:run
