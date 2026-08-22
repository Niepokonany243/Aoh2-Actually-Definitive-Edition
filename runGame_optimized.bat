@echo off
rem ============================================================
rem  AoH2 optimized launcher (TEMPORARY performance tuning)
rem
rem  Based on the PerfAnalyzer profile:
rem    - heap climbed ~318->750MB in ~25s then one big GC (~17MB/s
rem      allocation churn) -> reduce GC pause spikes
rem    - CPU-bound simulation on 8 cores -> keep GC lightweight so
rem      CPU stays on game logic, avoid ZGC's extra CPU overhead
rem
rem  Tune below to taste. Remove/replace this file to revert.
rem ============================================================

setlocal
cd /d "%~dp0"

rem -- This game.jar is compiled for Java 17 (class file 61.0).
rem    The bundled "jre" folder is Java 8 and CANNOT run it.
rem    Prefer JAVA_HOME, then the PATH java, then the bundled jre.
set "JAVA="
if defined JAVA_HOME if exist "%JAVA_HOME%\bin\java.exe" set "JAVA=%JAVA_HOME%\bin\java.exe"
if not defined JAVA set "JAVA=java"
if not exist "%JAVA%" set "JAVA=%CD%\jre\bin\java.exe"
if not exist "%JAVA%" echo WARNING: no java found in JAVA_HOME, PATH or .\jre & pause & exit /b 1

rem -- Heap: pre-size to avoid ramp-up reallocation; keep a high max
rem -- G1: cap pause target so the big per-turn GC spikes are softened
rem -- AlwaysPreTouch: commit heap up-front for steadier frame timing
rem -- -XX:-OmitStackTraceInFastThrow: keep FULL stack traces on the
rem    repeated NullPointerExceptions seen during AI turns (so we can
rem    pinpoint the army-disappearing bug instead of a bare 'java.lang.
rem    NullPointerException' line with no stack)
set "GC_FLAGS=-Xms1024m -Xmx4096m -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -XX:+AlwaysPreTouch -XX:-OmitStackTraceInFastThrow"

rem -- Optional experiments (uncomment one at a time, re-profile):
rem set "GC_FLAGS=-Xms1024m -Xmx8192m -XX:+UseZGC -XX:+AlwaysPreTouch"

"%JAVA%" %GC_FLAGS% -jar game.jar %*

endlocal
