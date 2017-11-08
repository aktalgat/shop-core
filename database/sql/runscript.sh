#!/bin/bash

# run example:
# SQL/runscript.sh drop=true WFDB "/home/luger/work/Aura/Aurapostgres_hacks/SQL">Aura_scripts.log 2>&1

dropdb=$1
# name specified in 00_createdb.sql
dbname=$2
# root path where scripts exists, example /home/luger/work/Aura/fromDiary/SQL/
scriptroot=$3

if [ -z "$dropdb" ]
then exit 1
fi

if [ -z "$dbname" ]
then exit 1
fi

if [ -z "$scriptroot" ]
then exit 1
fi

if [[ "$dropdb" -eq 'drop=true' ]]; then
    sudo su - postgres -c "psql -U postgres $dbname -c \"SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = '$dbname';
\""
    sudo su - postgres -c "dropdb $dbname"
fi

# running scripts
sudo su - postgres -c "echo \"$dbname\""
sudo su - postgres -c "psql -U postgres -c \"\i $scriptroot/core/01-create-schema.sql\""

for file in $(find $scriptroot/initial-data -name '*.sql' | sort)
do
    sudo su - postgres -c "echo $'\n --------------------------------------------------------------- \n'"
    sudo su - postgres -c "echo $'\"$file\" \n'"
    sudo su - postgres -c "echo $'\n --------------------------------------------------------------- \n'"
    sudo su - postgres -c "psql -U postgres $dbname -c \"\i $file\""
done