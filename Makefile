compile:
	mvn compile

package:
	mvn package

# 一旦、-Dexec.mainClassを書き換えて実行するようにする
start:
	mvn compile exec:java -Dexec.mainClass=io.tetsutech.PairtTest -Dexec.cleanupDaemonThreads=true

test:
	mvn test

# ↓はgradleを使って実行するやつ
start-gradle:
	./gradlew run

build-gradle:
	./gradlew build
