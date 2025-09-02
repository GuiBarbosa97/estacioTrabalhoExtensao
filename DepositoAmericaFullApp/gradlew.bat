@ECHO OFF
SETLOCAL
set DIR=%~dp0
set CLASSPATH=%DIR%gradle\wrapper\gradle-wrapper.jar
set JAVA_EXE=java
"%JAVA_EXE%" -Xms64m -Xmx512m -cp "%CLASSPATH%" org.gradle.wrapper.GradleWrapperMain %*
