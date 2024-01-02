@echo off

set path_astrazione="progetto\astrazione"
set path_componenti="progetto\componenti"


:ini
cls
echo eseguibile
echo compila-test
echo.
echo.
echo.
set /p n=":"
if "%n%" == "compila-test" (
    javac progetto\Main.java ^
    %path_astrazione%\logica\Editor.java ^
    %path_astrazione%\logica\Email.java ^
    %path_astrazione%\logica\Home_page.java ^
    %path_astrazione%\logica\Login.java ^
    %path_astrazione%\variabili\MenuPair.java ^
    %path_astrazione%\Database.java ^
    %path_astrazione%\Pagina.java ^
    %path_componenti%\astrazione\CustomLayoutManager.java ^
    %path_componenti%\Menu.java ^
    %path_componenti%\Schermo.java -d target

echo COMPILAZIONE FINITA, AVVIO ...

cd target
java progetto.Main 
cd ..
cls

) else if "%n%" == "eseguibile" (
    jar cvfe App.jar progetto.Main -C target progetto
    java -jar App.jar
    

) else (
    goto :ini
) 

