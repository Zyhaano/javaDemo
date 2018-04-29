# 概述
这是个maven构建的springboot工程demo

# JDK
version 1.8

```
export JAVA_HOME=/home/zhaogj/jdk
export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib:$JAVA_HOME/jre/lib
export PATH=$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$PATH:$HOME/bin
```

# Feature
> 1. 识别当前是否为单元测试，如果为单元测试，启动线程将会被跳过
> 2. makeApplication.sh为打包脚本，用于部署服务器
> 3. resoources/application.properties文件外置，修改打包完成后config/application.properties文件即可在工程中生效
> 4. watchDog.sh可用于守护进程，异常退出时自动拉起来