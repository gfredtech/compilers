SRC_DIR=src/
BASE_PKG=com/iloc/

iloc:
	@javac $(SRC_DIR)$(BASE_PKG)*.java -d build/

jar: iloc 
	@cd build ; jar cfm ../iloc.jar ../Manifest.txt $(BASE_PKG)*.class

.PHONY: clean

clean:
	@rm -r build/ iloc.jar
