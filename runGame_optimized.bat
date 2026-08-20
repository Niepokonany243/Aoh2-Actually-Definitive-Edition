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

set "JAVA=%CD%\jre\bin\java.exe"
if not exist "%JAVA%" set "JAVA=java"

rem -- Heap: pre-size to avoid ramp-up reallocation; keep a high max
rem -- G1: cap pause target so the big per-turn GC spikes are softened
rem -- AlwaysPreTouch: commit heap up-front for steadier frame timing
set "GC_FLAGS=-Xms1024m -Xmx4096m -XX:+UseG1GC -XX:MaxGCPauseMillis=50 -XX:+AlwaysPreTouch"

rem -- Optional experiments (uncomment one at a time, re-profile):
rem set "GC_FLAGS=-Xms1024m -Xmx8192m -XX:+UseZGC -XX:+AlwaysPreTouch"

"%JAVA%" %GC_FLAGS% -jar game.jar %*

endlocal
