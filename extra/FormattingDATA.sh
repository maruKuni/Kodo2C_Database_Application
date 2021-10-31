#! /bin/bash
#javac MDtoCSV.java
for FILE in $*
do
    sed 's/<img.*">//g' $FILE \
    | sed 's/[ ]*<h3.*">/#/g'|sed 's/<\/h3>//g' | sed 's/.*<th>/##/g'| sed 's/<\/th>//g' \
    | sed 's/.*<td><span>//g' | sed 's/<\/span><\/.*>/ /g' | sed 's/<\/span><span>/ /g' \
    | sed 's/.*tr>//g' | sed 's/.*table.*//g' > tmp.txt
    sed '/^$/d' tmp.txt | sed 's/#/# /g'|sed 's/# # /## /g' |sed 's/##[ ]*/## /g'> $FILE
    java MDtoCSV "$(echo $FILE |awk -F. {'print $1'} )"
    rm tmp.txt
done