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
# Borra todos los archivos generados por el build
# ---------------------------------------------------------
cd "$( cd -P "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
cd ../..
rm -r classes
rm -r lib
cd bin