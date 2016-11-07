LIB_FILES = junit/*:.

all:
	javac -d . -cp ${LIB_FILES} *.java 

doc:
	javadoc -d stackDoc/ -classpath ${LIB_FILES} *.java

clean:
	rm -r uga

gui:
	java uga.csci1302.test.GUItest

test:
	java -cp ${LIB_FILES} uga.csci1302.test.MyStackTester
