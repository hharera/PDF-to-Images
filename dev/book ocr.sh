#!/bin/bash

path="/home/hharera/Mol5s/موسوعة المسلم في التوبة والترقي في مدارج الإيمان المجلد الاول/pages";

for ((i = 1; i <= 650; i++)); do
    filename="${path}/${i}.png"
    output="${path}/${i}"

    tesseract "$filename" "$output" -l ara

    echo "Processed $filename"
done
