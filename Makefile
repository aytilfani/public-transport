SOURCE_DIR = ./src
TEST_DIR = ./tst
BUILD_DIR = ./build
PACKAGE_BUILD_DIR = ./build/tec
PACKAGE_SOURCE_DIR = ./src/tec

all: exe

build: buil

buil:
	javac -d ${BUILD_DIR} ${PACKAGE_SOURCE_DIR}/*.java

test: buil
	javac -d ${BUILD_DIR} -cp ${BUILD_DIR} ${TEST_DIR}/*.java

exe: test
	java -cp ${BUILD_DIR} -ea tec.TestJauge
	java -cp ${BUILD_DIR} -ea tec.TestPosition
	java -cp ${BUILD_DIR} -ea tec.TestPassagerStandard
	java -cp ${BUILD_DIR} -ea tec.TestAutobus

simple : buil
	javac -d ${BUILD_DIR} -cp ${BUILD_DIR} ${SOURCE_DIR}/Simple.java
	java -cp ${BUILD_DIR} -ea Simple
clean:
	rm -rf ${BUILD_DIR}/*.class
	rm -rf ${PACKAGE_BUILD_DIR}
