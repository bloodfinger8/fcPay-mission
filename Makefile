.PHONY: up
up:
	@echo "Running ./gradlew docker"
	@./gradlew docker -Pprofile=local
	@echo "Running docker-compose up -d"
	@docker-compose up -d

.PHONY: down
down:
	@echo "Running docker-compose down"
	@docker-compose down --remove-orphans