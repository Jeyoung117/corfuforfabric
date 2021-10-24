#!bin/bash
HOME_DIR=/home/hwang/project/github.com/Corfu_build/CorfuDBforFabric

rm -rf $HOME_DIR/tmp/data1
mkdir $HOME_DIR/tmp/data1

$HOME_DIR/bin/corfu_server -l $HOME_DIR/tmp/data1 -s -a 141.223.121.139 12011
