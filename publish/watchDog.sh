#!/bin/bash
# Created by zhaogj on 20170913
# ES的守护进程，发现es挂掉就拉起来
# ./watchDog.sh > /dev/null 2>&1 &

# 获取脚本名
cmd="$0"
file_name=${cmd##*/}
#echo file_name:$file_name
pid_self=$$
#echo pid_self:${pid_self}
# 铆劲杀之前启动的自己
pid=`ps aux | grep ${file_name} | grep -v 'grep' | grep -v ${pid_self} | awk '{print$2}'`
kill -9 ${pid}

# 启动狗
while true
do
  pid=`ps aux | grep 'elasticsearch/lib' | grep -v 'grep' | awk '{print$2}'`
  if [ -z ${pid} ]
    then
    /data/bangcle_es/es/bin/restart.sh
  fi
  sleep 7
done