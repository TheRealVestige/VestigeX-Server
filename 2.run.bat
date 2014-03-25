@echo off
title Vestige-x
echo Loading Up Files...
"c:\Program Files (x86)\Java\jdk1.7.0_45\bin\java.exe" -Xmx1024m -cp data/CompiledFiles;deps/poi.jar;deps/mysql.jar;deps/mina.jar;deps/slf4j.jar;deps/slf4j-nop.jar;deps/jython.jar;log4j-1.2.15.jar; server.Server
pause