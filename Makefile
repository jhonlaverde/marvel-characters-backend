run:
	mvn clean install && mvn spring-boot:start -pl launcher
stop:
	mvn spring-boot:stop -pl launcher