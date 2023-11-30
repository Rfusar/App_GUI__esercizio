@echo off

:ini
cls
echo eseguibile
echo compila-test
echo.
echo.
echo.
set /p n=":"
if "%n%" == "compila-test" (
    javac ^
    progetto\Main.java ^
    ^
    progetto\astrazione\Pagina.java ^
    progetto\astrazione\Database.java ^
    ^
    progetto\astrazione\logica\Login.java ^
    progetto\astrazione\logica\Home_page.java ^
    ^
    progetto\astrazione\variabili\MenuPair.java ^
    ^
    progetto\componenti\Schermo.java ^
    progetto\componenti\Menu.java ^
    -d target

cd target
java -cp .;progetto\astrazione\postgresql-42.7.0.jar progetto.Main

cd ..
cls

) else if "%n%" == "eseguibile" (
    jar cvfe App.jar progetto.Main -C target progetto
    java -jar App.jar
    

) else (
    goto :ini
) 

