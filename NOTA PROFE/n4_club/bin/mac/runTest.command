# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# $Id$
# Universidad de los Andes (Bogota‡ - Colombia)
# Departamento de Ingenieri’a de Sistemas y Computacio—n
# Licenciado bajo el esquema Academic Free License version 2.1
#
# Proyecto Cupi2
# Ejercicio: n2_certificadoNotas
# Autor: Rafael Munoz Lattion - 05-oct-2012
# Creacion de Script: Juan Sebasti‡an Urrego
# ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
# ---------------------------------------------------------
# Asegura la creaci—n de los directorios classes y lib
# ---------------------------------------------------------
cd "$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
pwd
java -ea -classpath ../../lib/certificadoNotas.jar:../../test/lib/certificadoNotasTest.jar:../../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.certificadoNotas.test.MateriaTest
java -ea -classpath ../../lib/certificadoNotas.jar:../../test/lib/certificadoNotasTest.jar:../../test/lib/junit.jar junit.swingui.TestRunner uniandes.cupi2.certificadoNotas.test.CertificadoNotasTest


