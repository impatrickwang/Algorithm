#!/bin/bash

LIST=$1

index=1
for line in `cat ${LIST}`
do
	mkdir ${index}
	mv ${line}.java ${index}
	echo "move ${line}.java into ${index}"
	((index=index+1))
done
