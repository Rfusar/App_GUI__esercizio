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
    javac -cp ";progetto\librerie\javax.mail.jar;progetto\librerie\postgresql-42.7.0.jar" ^
    ^
    progetto\Main.java ^
    ^
    progetto\astrazione\logica\Editor.java ^
    progetto\astrazione\logica\Email.java ^
    progetto\astrazione\logica\Home_page.java ^
    progetto\astrazione\logica\Login.java ^
    ^
    progetto\astrazione\variabili\MenuPair.java ^
    ^
    progetto\astrazione\Database.java ^
    progetto\astrazione\Pagina.java ^
    ^
    progetto\componenti\astrazione\CustomLayoutManager.java ^
    ^
    progetto\componenti\Menu.java ^
    progetto\componenti\Schermo.java ^
    ^
    -d target

echo COMPILAZIONE FINITA, AVVIO ...

cd target
java -cp ";progetto\librerie\javax.mail.jar;progetto\librerie\postgresql-42.7.0.jar" progetto.Main 

cd ..
pause
cls

) else if "%n%" == "eseguibile" (
    jar cvfe App.jar progetto.Main -C target progetto
    java -jar App.jar
    

) else (
    goto :ini
) 

