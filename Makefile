compile:
	javac src/Main.java

run:
	java src/Main

run-args:
	java src/Main arg1 arg2

gen-doc:
	javadoc -d html src/JavadocTest.java
