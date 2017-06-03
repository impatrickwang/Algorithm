#!/bin/bash

LIST=$1

index=1
for line in `cat ${LIST}`
do
	mkdir ${index}
	mv ${line}.java ${index}/Solution.java
	echo "move ${line}.java into ${index}/Solution.java"
	((index=index+1))
done
