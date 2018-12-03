#!/usr/bin/env bash

cd /Users/hoda/Documents/UT/Fall97/PLC/phase2/smoola-AST/src/main
sudo curl -O https://www.antlr.org/download/antlr-4.7.1-complete.jar
export CLASSPATH=".:/usr/local/lib/antlr-4.7.1-complete.jar:$CLASSPATH"

rm *.class
rm *.tokens
rm Smoola*.java
rm *.interp
find . -type f -name "*.class" -delete

java -jar /usr/local/lib/antlr-4.7.1-complete.jar Smoola.g4
find . -name "*.java" > sources.txt
javac @sources.txt
java org.antlr.v4.gui.TestRig Smoola program < ../in.sml