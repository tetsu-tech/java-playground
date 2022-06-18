compile:
	mvn compile

package:
	mvn package

# 一旦、-Dexec.mainClassを書き換えて実行するようにする
start:
	mvn compile exec:java -Dexec.mainClass=io.tetsutech.Log4JTest -Dexec.cleanupDaemonThreads=true
