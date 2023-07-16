@echo off
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad de los Andes (Bogot� - Colombia)
REM Departamento de Ingenier�a de Sistemas y Computaci�n 
REM Licenciado bajo el esquema Academic Free License version 2.1 
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: n2_certificadoMaterias
REM Autor: Rafael Mu�oz - 05-oct-2012
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET CLASSPATH=

REM ---------------------------------------------------------
REM Ejecucion de las pruebas
REM ---------------------------------------------------------

cd ../..
	
java -ea -classpath lib/certificadoNotas.jar;test/lib/junit.jar;test/lib/certificadoNotasTest.jar junit.swingui.TestRunner uniandes.cupi2.certificadoNotas.test.CertificadoNotasTest
	
java -ea -classpath lib/certificadoNotas.jar;test/lib/junit.jar;test/lib/certificadoNotasTest.jar junit.swingui.TestRunner uniandes.cupi2.certificadoNotas.test.MateriaTest
cd bin/win